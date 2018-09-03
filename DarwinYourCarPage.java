package com.dlg.webBau.pages.IGO4;

import com.dlg.webBau.steps.AbstractSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DarwinYourCarPage extends AbstractSteps {

    public WebElement isAlarmFittedDropDown(){
        return waitForElementVisible(By.name("your_car_fitted_with_an_alarm"));

    }
    public WebElement isImmobiliserFittedDropDown(){
        return waitForElementPresent(By.name("your_car_has_immobiliser"));
    }
    public WebElement isTrackingDeviceFittedBtn(Boolean DeviceFitted){
        if(DeviceFitted) {
            return waitForElementPresent(By.xpath("//input[@name='your_car_has_tracker' and @value='Y']//parent::label"));
        }else{
            return waitForElementPresent(By.xpath("//input[@name='your_car_has_tracker' and @value='NONE']//parent::label"));
        }
    }

    public WebElement isABSFittedBtn(Boolean ABSFitted){
        if(ABSFitted) {
            return waitForElementPresent(By.xpath("//input[@name='your_car_abs_fitted' and @value='1']//parent::label"));
        }else{
            return waitForElementPresent(By.xpath("//input[@name='your_car_abs_fitted' and @value='0']//parent::label"));
        }
    }


    public WebElement isCarLeftHandDriveBtn(Boolean LeftHandDrive){
        if(LeftHandDrive) {
            return waitForElementPresent(By.xpath("//input[@name='your_car_left_hand_drive' and @value='1']//parent::label"));
        }else{
            return waitForElementPresent(By.xpath("//input[@name='your_car_left_hand_drive' and @value='0']//parent::label"));
        }
    }

    public WebElement noOfseatsDropDown(){
        return waitForElementPresent(By.name("your_car_number_of_seats"));
    }

    public WebElement isCarPurchasedBtn(Boolean carBought){
        if(carBought) {
            return waitForElementPresent(By.xpath("//input[@name='your_car_purchased_the_car_yet' and @value='1']//parent::label"));
        }else{
            return waitForElementPresent(By.xpath("//input[@name='your_car_purchased_the_car_yet' and @value='0']//parent::label"));
        }
    }

    public WebElement carMarketValueTxtBox(){
        return waitForElementPresent(By.name("your_car_market_value"));
    }

    public WebElement carOwnerDropdown(){
        return waitForElementPresent(By.name("your_car_vehicle_owner"));
    }
    public WebElement registeredKeeperDropdown(){
        return waitForElementPresent(By.name("your_car_vehicle_keeper"));
    }
    public WebElement carModificationsBtn(Boolean carModified){
        if(carModified) {
            return waitForElementPresent(By.xpath("//input[@name='your_car_has_modifications' and @value='1']//parent::label"));
        }else{
            return waitForElementPresent(By.xpath("//input[@name='your_car_has_modifications' and @value='0']//parent::label"));
        }
    }
    public WebElement carImportedBtn(Boolean carImported){
        if(carImported) {
            return waitForElementPresent(By.xpath("//input[@name='your_car_imported' and @value='1']//parent::label"));
        }else{
            return waitForElementPresent(By.xpath("//input[@name='your_car_imported' and @value='0']//parent::label"));
        }
    }
    public WebElement confirmYourCarSectionBtn(){
        return waitForElementPresent(By.xpath("//*[contains(text(),'I CONFIRM')]/parent::button"));
    }

    public WebElement  carParkedOvernightdropDown(){
        return waitForElementPresent(By.name("use_of_your_car_kept"));
    }
    public WebElement  carParkedOverNightLocationDropDown(){
        return waitForElementPresent(By.name("use_of_your_car_kept_location"));
    }
    public WebElement  carParkedDayLocationDropDown(){
        return waitForElementPresent(By.name("use_of_your_car_day_parking"));
    }
    public WebElement  NumberOfCarsDropDown(){
        return waitForElementPresent(By.name("use_of_your_car_total_vehicles_on_household"));
    }

    public WebElement  useOfCarDropDown(){
        return waitForElementPresent(By.name("use_of_your_car_class_of_use"));
    }
    public WebElement annualMileageTextBox(){
        return waitForElementPresent(By.name("[name=use_of_your_car_annual_mileage]"));
    }

}
