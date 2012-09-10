package com.github.rlespinasse.slf4j.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

import static org.springframework.util.ReflectionUtils.FieldCallback;

/**
 * BeanPostProcessor for @AutowiredLogger.<br/>
 *
 * To use this BeanPostProcessor
<pre>{@code
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean class="com.github.rlespinasse.slf4j.spring.AutowiredLoggerPostProcessor"/>
</beans>
}</pre>
 * @see AutowiredLogger
 */
public class AutowiredLoggerPostProcessor implements BeanPostProcessor {
    /**
     * {@inheritDoc}
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws
            BeansException {
        return bean;
    }

    /**
     * {@inheritDoc}
     */
    public Object postProcessBeforeInitialization(final Object bean, String beanName)
            throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {
            @SuppressWarnings("unchecked")
            public void doWith(Field field) throws IllegalArgumentException,
                    IllegalAccessException {
                ReflectionUtils.makeAccessible(field);
                if (field.getAnnotation(AutowiredLogger.class) != null) {
                    Logger logger = LoggerFactory.getLogger(bean.getClass());
                    field.set(bean, logger);
                }
            }
        });

        return bean;
    }
}
