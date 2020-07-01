package io.mohsinkd786.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/calculator.feature", "classpath:features/calculator-scenario.feature"}

)
public class CalculatorTest {
}
