package br.com.challenge.core.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/br/com/challenge/core/features/",
        glue = "br.com.challenge.core.steps",
        plugin = {"pretty","html:target/report-html", "json:target/report.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        dryRun = false
)
public class Runner {
}
