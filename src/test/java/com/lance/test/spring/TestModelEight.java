package com.lance.test.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by perdonare on 2015/12/13.
 */
@Component
public class TestModelEight {

    @Bean
    @Qualifier("public")
    public TestModelNine createNine() {
        return new TestModelNine();
    }

}
