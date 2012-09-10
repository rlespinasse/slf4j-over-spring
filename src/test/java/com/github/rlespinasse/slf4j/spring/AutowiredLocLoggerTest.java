package com.github.rlespinasse.slf4j.spring;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/slf4j-autowired-loc-logger.xml"})
public class AutowiredLocLoggerTest extends AutowiredLocLoggerBase {
}
