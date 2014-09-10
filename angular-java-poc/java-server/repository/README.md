# Spring JPA Repo

> This is intented to showcase the usage of SpringDataJPA.

[Spring Docs](http://docs.spring.io/spring-data/jpa/docs/1.7.0.RELEASE/reference/html/#repositories.custom-implementations)

## Migration Gotchas!!!!!!

Note the naming convention of the SpringDataJPA is COC based. As a result, pay careful attention to the how you name your custom interface an class.

### In short:
You will need to create your custom interface with the same name as your as your JPA interface. 

For example, in this example our JPA repo is called IClientRepo. As a result, will need to call the class instance (for our custom interface) with the name 'IClientRepoImpl' in order for spring to wire it in.


