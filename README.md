# SLF4J spring enhancement
## How to use it?
### 1. declare a Maven dependency
```xml
<dependency>
    <groupId>com.github.rlespinasse</groupId>
    <artifactId>slf4j-over-spring</artifactId>
    <version>1.0</version>
</dependency>
```
### 2. use the annotation `@AutowiredLogger` on a SLF4J Logger in a `@Component` bean
```java
@Component
public class BeanWithLogger {
    @AutowiredLogger
    org.slf4j.Logger logger;
}
```

### 3. setup autowired logger system
#### by his `Spring XML configuration` implementation
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

#### or by his `BeanPostProcessor` implementation
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean class="com.github.rlespinasse.slf4j.spring.AutowiredLoggerPostProcessor"/>
</beans>
```