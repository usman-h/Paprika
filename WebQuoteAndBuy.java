package com.dlg.webBau.step_definitions;

import com.dlg.webBau.BaseStepDef;
import com.dlg.webBau.pages.IGO4.DarwinFindCarPage;
import com.dlg.webBau.steps.AbstractSteps;
import com.dlg.webBau.utils.AggregatorUtil.DarwinWebUtil;
import cucumber.api.java.en.And;

import java.util.Arrays;
import java.util.List;

public class WebQuoteAndBuy extends BaseStepDef {
    DarwinWebUtil darwinWebUtil = new DarwinWebUtil();
    private AbstractSteps darwinFindCarPage = new DarwinFindCarPage();

    @And("^I click on get a quote to fill the vehicle info and Policy holder details$")
    public void iClickOnGetAQuoteToFillTheVehicleInfoAndPolicyHolderDetails() throws Throwable {
        DarwinFindCarPage homepage = new DarwinFindCarPage();
        homepage.getQuoteBtn().click();
        darwinWebUtil.findYourCar();
        darwinWebUtil.filYourCarSection();


      /*  List<String[]> exa = Arrays.asList(new String[]{"elementName1","action1"}, new String[]{"elementName2","action2"}, new String[]{"elementName3","action3"});
        for(String[] data: exa)
            darwinWebUtil.fillDetailsInScreen(darwinFindCarPage,data);*/

    }
}
