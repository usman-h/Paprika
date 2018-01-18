package com.usmanhussain.paprika.utils;

import com.usmanhussain.paprika.pages.MyDetailsSectionCar;

public class OopMethods {

    private MyDetailsSectionCar myDetailsSection = new MyDetailsSectionCar();

    public void fillInMyCarDetailsSection(String vehicleRegistationNumber, String annualMilage, String carValue) {
        myDetailsSection.carRegistrationTextField().sendKeys(vehicleRegistationNumber);
        myDetailsSection.findRegistrationButton().click();
        myDetailsSection.annualMileageDropdown().sendKeys(annualMilage);
        myDetailsSection.carNotYetPurchasedRadioBtn().click();
        myDetailsSection.estimatedCarValueTextField().sendKeys(carValue);
    }

    public void clickOnNextButton() {
        myDetailsSection.nextButton().click();
    }

}
