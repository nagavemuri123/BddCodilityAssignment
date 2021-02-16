package com.automationpractice.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features"
		,glue={"com.automationpractice.stepdef"}
		,format = {"html:Reports"}
		)
public class TestRunner {

}
