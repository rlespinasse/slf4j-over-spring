package com.github.rlespinasse.slf4j.spring;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * BeanDefinitionParser for @AutowiredLogger.<br/>
 *
 * To use this BeanDefinitionParser
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
 * @see AutowiredLogger
 */
public class AutowiredLoggerBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    private static int n = 0;

    @Override
    protected Class<?> getBeanClass(Element element) {
        return AutowiredLoggerPostProcessor.class;
    }

    @Override
    protected String resolveId(Element element, AbstractBeanDefinition definition, ParserContext parserContext) throws BeanDefinitionStoreException {
        String id = super.resolveId(element, definition, parserContext);
        if (StringUtils.hasText(id))
            return id;
        return "slf4jAutowiredLogger_GeneratedBeanId_" + n++;
    }
}
