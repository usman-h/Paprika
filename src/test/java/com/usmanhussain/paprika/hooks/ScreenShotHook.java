package com.usmanhussain.paprika.hooks;

import com.usmanhussain.paprika.BaseStepDef;
import com.usmanhussain.habanero.framework.WebDriverDiscovery;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ScreenShotHook extends BaseStepDef {

    protected static final Logger LOG = LoggerFactory.getLogger(ScreenShotHook.class);

    /**
     * <p>
     * Takes screen-shot if the scenario fails
     * Generate HAR file on test failure
     * </p>
     *
     * @param scenario will be the individual scenario's within the Feature files
     * @throws InterruptedException Exception thrown if there is an interuption within the JVM
     */
    @After()
    public void afterTest(Scenario scenario) throws InterruptedException, IOException {
        if (scenario.isFailed()) {
            try {
                LOG.info("Scenario FAILED... screen shot taken");
                scenario.write(getDriver().getCurrentUrl());
                scenario.write(getDriver().getPageSource());
                byte[] screenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
                String pageSource = getDriver().getPageSource().replace("html", "");
                PrintWriter out = new PrintWriter("target/cucumber_reports/" + scenario.getName().replace("/", "").replace(" ", "") + ".html");
                out.println(pageSource);
                scenario.embed(pageSource.getBytes(), "text/plain");
                Har har = WebDriverDiscovery.server.getHar();
                File harFile = new File("target/cucumber_reports/" + scenario.getName().replace("/", "").replace(" ", "") + ".har");
                har.writeTo(harFile);
            } catch (WebDriverException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    /**
     * <p>
     * Maximise browser window before test begins to keep environment consistent
     * </p>
     */
    @Before()
    public void beforeScenario(Scenario scenario) {
        WebDriverDiscovery.server.newHar(scenario.getName());
        getDriver().manage().window().maximize();
    }

}