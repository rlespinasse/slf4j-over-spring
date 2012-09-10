package com.github.rlespinasse.slf4j.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Namespace Handler for {@code com/github/rlespinasse/slf4j/spring/slf4j.xsd}
 */
public class Slf4jNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("autowired-logger", new AutowiredLoggerBeanDefinitionParser());
        registerBeanDefinitionParser("autowired-loc-logger", new AutowiredLoggerBeanDefinitionParser());
    }
}
