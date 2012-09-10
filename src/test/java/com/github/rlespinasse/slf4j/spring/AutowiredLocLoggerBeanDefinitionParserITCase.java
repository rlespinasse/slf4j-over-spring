package com.github.rlespinasse.slf4j.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.cal10n.LocLogger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/slf4j-autowired-loc-logger-by-custom-tag.xml"})
public class AutowiredLocLoggerBeanDefinitionParserITCase {

    @AutowiredLocLogger
    Logger logger;

    @AutowiredLocLogger
    LocLogger locLogger;

    @Test public void should_be_injected() {
        assertThat(logger).isNotNull();
        assertThat(locLogger).isNotNull();
    }

    @Test public void should_be_the_logger_of_this_class() {
        assertThat(logger.getName()).isEqualTo(this.getClass().getCanonicalName());
        assertThat(locLogger.getName()).isEqualTo(this.getClass().getCanonicalName());
    }
}
