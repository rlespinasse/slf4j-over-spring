package com.github.rlespinasse.slf4j.spring;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * BeanDefinitionParser for @AutowiredLogger.
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
