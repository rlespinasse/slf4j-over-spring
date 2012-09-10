package com.github.rlespinasse.slf4j.spring;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation to automatically setup a slf4j Logger in a @Component class with
 * <ul>
 *     <li>
 *     his {@link org.springframework.beans.factory.config.BeanPostProcessor} implementation,
<pre>{@code
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

<bean class="com.github.rlespinasse.slf4j.spring.AutowiredLoggerPostProcessor"/>
</beans>
}</pre>
 *     </li>
 *     <li>
 *     or his {@link org.springframework.beans.factory.xml.BeanDefinitionParser} implementation.
<pre>{@code
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:slf4j="http://rlespinasse.github.com/schema/slf4j"
xsi:schemaLocation="
http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
http://rlespinasse.github.com/schema/slf4j http://rlespinasse.github.com/schema/slf4j/slf4j.xsd">

<slf4j:autowired-logger />
</beans>}</pre>
 *     </li>
 * </ul>
 */
@Retention(RUNTIME)
@Target(FIELD)
@Documented
public @interface AutowiredLogger {
}
