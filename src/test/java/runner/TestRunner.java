package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {
        "steps" }, monochrome = true, tags = "@smoke", plugin = { "pretty", "junit:target/JUnitReports/reports.xml",
                "json:target/JsonReports/reports.json", "html:target/HtmlReports/reports.html" })

public class TestRunner {

}
