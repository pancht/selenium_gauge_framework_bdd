package test_configurations;

import org.openqa.selenium.WebDriver;

public class ExecutionHooks {

    private final WebDriver driver;

    public ExecutionHooks() {
        this.driver = DriverFactory.getDriver();
    }

   /* @com.thoughtworks.gauge.BeforeScenario 
    public void BeforeSuite() {
        // Code for before suite
     }

   

     @com.thoughtworks.gauge.BeforeSpec
     public void BeforeSpec() {
        // Code for before spec
     }

     @com.thoughtworks.gauge.AfterSpec
     public void AfterSpec() {
        // Code for after spec
     }

     @com.thoughtworks.gauge.BeforeScenario
     public void BeforeScenario() {
        // Code for before scenario
     }

     @com.thoughtworks.gauge.AfterScenario
     public void AfterScenario() {
        // Code for after scenario
     }

     @com.thoughtworks.gauge.BeforeStep
     public void BeforeStep() {
        // Code for before step
     }

     @com.thoughtworks.gauge.AfterStep
     public void AfterStep() {
        // Code for after step
     }
*/

}
