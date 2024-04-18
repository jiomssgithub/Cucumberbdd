package TestRunner;

import org.junit.runner.*;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
   features = ".//Features/Login.feature",
   glue="StepDefinition",
   dryRun=false,
   monochrome= true,
   tags="@regression",
   plugin= {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class Runner {

}
