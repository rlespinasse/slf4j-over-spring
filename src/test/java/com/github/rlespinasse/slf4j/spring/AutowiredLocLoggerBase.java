package com.github.rlespinasse.slf4j.spring;

import ch.qos.cal10n.MessageConveyor;
import org.junit.Test;
import org.slf4j.cal10n.LocLogger;

import java.lang.reflect.Field;
import java.util.Locale;

import static org.fest.assertions.Assertions.assertThat;

public abstract class AutowiredLocLoggerBase {

    @AutowiredLocLogger
    LocLogger logger;

    @Test
    public void should_be_injected() {
        assertThat(logger).isNotNull();
    }

    @Test public void should_be_the_logger_of_this_class() {
        assertThat(logger.getName()).isEqualTo(this.getClass().getCanonicalName());
    }

    @Test public void should_be_localize_in_english() throws NoSuchFieldException, IllegalAccessException {
        Field imc = logger.getClass().getDeclaredField("imc");
        imc.setAccessible(true);
        MessageConveyor messageConveyor = (MessageConveyor) imc.get(logger);
        Field locale = messageConveyor.getClass().getDeclaredField("locale");
        locale.setAccessible(true);
        assertThat(((Locale) locale.get(messageConveyor))).isNotNull().isEqualTo(Locale.ENGLISH);
    }
}
