package com.project.TechnicalTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfiguration {

    @Bean
    public TestRunner testRunner(){
        TestRunner testRunner = new TestRunner();
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int sumOfEvens = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();

        testRunner.setMessage("Runner - Test Stream Result = " + sumOfEvens);

        return testRunner;
    }

}
