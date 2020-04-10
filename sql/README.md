##Setting up the database

### Set up Postgres
1) Install Postgres. Use default super user 'postgres'.
2) Run `psql -U postgres -f setup.sql`
3) Run `psql -U datingappdbuser -d datingappdb -f datingappdb.sq`

### Configure jooq
- Apply gradle jooq plugin 
```groovy
plugins {
      id 'nu.studer.jooq' version '4.1'
  }
 ```
- Add jooq dependencies 
```groovy
dependencies {
    implementation 'org.jooq:jooq:3.13.1'
    jooqRuntime 'postgresql:postgresql:9.1-901.jdbc4'
}
```
- Configure jooq 
```groovy
jooq {
    generateSchemaSourceOnCompilation = true
    datingappdb(sourceSets.main) {
        jdbc {
            driver = 'org.postgresql.Driver'
            url = 'jdbc:postgresql://localhost:5432/datingappdb'
            user = 'datingappdbuser'
            password = 'datingappdbuser'
        }

        generator {
            name = 'org.jooq.codegen.DefaultGenerator'
            
            database {
                name = 'org.jooq.meta.postgres.PostgresDatabase'
                inputSchema = 'public'
                includes = '.*'
                excludes = ''
            }

            generate {
                relations = true
                deprecated = false
                records = true
                immutablePojos = true
                fluentSetters = true
            }
        }
    }
}
```

- Optionally, configure naming strategy
```groovy
generator {
            name = 'org.jooq.codegen.DefaultGenerator'

            strategy {
                name = null
                matchers {
                    tables {
                        table {
                            pojoClass {
                                transform = 'PASCAL'
                                expression = 'Postgres_$0'
                            }
                            tableClass {
                                transform = 'PASCAL'
                                expression = 'Postgres_$0'
                            }
                        }
                    }
                }
            }
        }
```