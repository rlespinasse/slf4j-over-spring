# SLF4J spring enhancement
## Features
### @AutowiredLogger
add a SLF4J Logger on a @Component class

```java
@Component
public class BeanWithLogger {
    @AutowiredLogger
    Logger logger;
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:slf4j="http://rlespinasse.github.com/schema/slf4j"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
       http://rlespinasse.github.com/schema/slf4j http://rlespinasse.github.com/schema/slf4j/slf4j.xsd">

   <slf4j:autowired-logger />
</beans>
```

### @AutowiredLocLogger
add a SLF4J LocLogger on a @Component class

```java
@Component
public class BeanWithLocLogger {
    @AutowiredLocLogger
    LocLogger logger;
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:slf4j="http://rlespinasse.github.com/schema/slf4j"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
       http://rlespinasse.github.com/schema/slf4j http://rlespinasse.github.com/schema/slf4j/slf4j.xsd">

   <!-- simple usage -->
   <slf4j:autowired-loc-logger />
   
   <!-- custom usage to define a specific locale (instead of default Locale.ENGLISH)  -->
   <slf4j:autowired-loc-logger locale="en"/>
</beans>
```