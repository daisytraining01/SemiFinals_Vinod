package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)				
@CucumberOptions(features="src/test/java/feature",
glue={"stepdefinition"},
tags= {"@seltest"},
dryRun=false,
monochrome=true
)


public class Runner {
// @seltest tags are used only for myfeature and myfeature2 feature files
}
