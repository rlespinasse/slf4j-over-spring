package com.github.rlespinasse.slf4j.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.cal10n.LocLogger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-it/slf4j-autowired-loc-logger.xml"})
public class AutowiredLocLoggerITCase extends AutowiredLocLoggerBase {
}
