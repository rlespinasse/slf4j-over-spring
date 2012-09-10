package com.github.rlespinasse.slf4j.spring;

import ch.qos.cal10n.IMessageConveyor;
import ch.qos.cal10n.MessageConveyor;
import org.slf4j.cal10n.LocLogger;
import org.slf4j.cal10n.LocLoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Locale;

import static org.springframework.util.ReflectionUtils.FieldCallback;

/**
 * BeanPostProcessor for @AutowiredLocLogger.
 * @see AutowiredLocLogger
 */
public class AutowiredLocLoggerPostProcessor implements BeanPostProcessor {

    Locale locale = Locale.ENGLISH;

    public void setLocale(String locale) {
        assert locale != null;
        String[] splitLocale = locale.split("_");
        String language = "";
        String country = "";
        String variant = "";
        if(splitLocale.length > 0) {
            language = splitLocale[0];
        }
        if(splitLocale.length > 1) {
            country = splitLocale[1];
        }
        if(splitLocale.length > 2) {
            variant = splitLocale[2];
        }
        this.locale = new Locale(language, country, variant);
    }

    /**
     * {@inheritDoc}
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * {@inheritDoc}
     */
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {
            @SuppressWarnings("unchecked")
            public void doWith(Field field) throws IllegalArgumentException,
                    IllegalAccessException {
                ReflectionUtils.makeAccessible(field);
                if (field.getAnnotation(AutowiredLocLogger.class) != null) {
                    IMessageConveyor messageConveyor = new MessageConveyor(locale);
                    LocLoggerFactory locLoggerFactory = new LocLoggerFactory(messageConveyor);
                    LocLogger locLogger = locLoggerFactory.getLocLogger(bean.getClass());
                    field.set(bean, locLogger);
                }
            }
        });

        return bean;
    }
}
