package com.github.rlespinasse.slf4j.spring;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import java.util.Locale;

/**
 * BeanDefinitionParser for @AutowiredLocLogger.
 * @see AutowiredLocLogger
 */
public class AutowiredLocLoggerBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    private static int n = 0;

    @Override
    protected Class<?> getBeanClass(Element element) {
        return AutowiredLocLoggerPostProcessor.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String locale = element.getAttribute("locale");
        if (StringUtils.hasText(locale)) {
            builder.addPropertyValue("locale", locale);
        }
    }


    @Override
    protected String resolveId(Element element, AbstractBeanDefinition definition, ParserContext parserContext) throws BeanDefinitionStoreException {
        String id = super.resolveId(element, definition, parserContext);
        if (StringUtils.hasText(id))
            return id;
        return "slf4jAutowiredLocLogger_GeneratedBeanId_" + n++;
    }
}
