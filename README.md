# Example code to reproduce a Hibernate bug

- Hibernate version: 6.1.6.Final
- Spring Boot version: 3.0.1

# Explanation of use case

We have a parent entity `Animal` and two children `Cat` and `Dog`. Both children have a property `toys` that should be serialized
as JSON into the database column.

# Reproduce

Just run `AnimalActionRepositoryTest.shouldReadOnlyADog` and see the exception rising.

```
Caused by: org.hibernate.HibernateException: Unable to extract JDBC value for position `4`
at org.hibernate.sql.results.jdbc.internal.JdbcValuesResultSetImpl.readCurrentRowValues(JdbcValuesResultSetImpl.java:271)
```

This occurs because Hibernate tries to deserialize the JSON into the wrong type.
It seems that Hibernate always uses the same type mapping for both JSON type properties (`Cat.toys` and `Dog.toys`). It seems that
it's always the first alphabetical match (`CatToys` here). `AnimalActionRepositoryTest.shouldReadOnlyACat` works fine.