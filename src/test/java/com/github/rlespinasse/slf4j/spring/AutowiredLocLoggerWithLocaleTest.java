package com.github.rlespinasse.slf4j.spring;

import ch.qos.cal10n.MessageConveyor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.cal10n.LocLogger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.util.Locale;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/slf4j-autowired-loc-logger-locale.xml"})
public class AutowiredLocLoggerWithLocaleTest extends AutowiredLocLoggerWithLocaleBase {
}
