package bddProj.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	tags = "", 
					features = "src/test/resources/features/Login.feature", 
					glue = "bddProj.stepDefinitions"
				)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}
