package com.usmanhussain.paprika.hooks;

import com.usmanhussain.habanero.framework.WebDriverDiscovery;
import com.usmanhussain.paprika.BaseStepDef;
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

public class ScreenShotHook extends BaseStepDef {

    protected static final Logger LOG = LoggerFactory.getLogger(ScreenShotHook.class);

    /**
     * Takes screen-shot if the scenario fails
     * <p>
     *
     * @param scenario
     */
    @After()
    public void afterTest(Scenario scenario) throws InterruptedException, IOException {
        if (scenario.isFailed()) {
            try {
                scenario.write(getDriver().getCurrentUrl());
                byte[] screenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
                Har har = WebDriverDiscovery.server.getHar();
                File harFile = new File("target/cucumber_reports/" + scenario.getName().replace("/", "").replace(" ", "") + ".har");
                har.writeTo(harFile);
            } catch (WebDriverException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    @Before()
    public void beforeScenario(Scenario scenario) {
        WebDriverDiscovery.server.newHar(scenario.getName());
    }

}