package com.dlg.webBau.utils.AggregatorUtil;

import com.dlg.webBau.pages.IGO4.DarwinFindCarPage;
import com.dlg.webBau.pages.IGO4.DarwinYourCarPage;
import com.dlg.webBau.steps.AbstractSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DarwinWebUtil extends AbstractSteps {
    private DarwinFindCarPage darwinFindCarPage = new DarwinFindCarPage();
    private DarwinYourCarPage darwinYourCarPage = new DarwinYourCarPage();

    public void findYourCar(){
        darwinFindCarPage.findElementPresent("enterCarRegNumTxtBox").sendKeys("ABC123");
        darwinFindCarPage.findElementPresent("getAQuoteBtn").click();
        if (darwinFindCarPage.isElementPresent("isInformationCorrectBtn")){
            darwinFindCarPage.findElementPresent("isInformationCorrectBtn").click();
        }else{
            System.out.println("All Mandatory fields are not filled.");
        }
        /*darwinFindCarPage.enterCarRegNumTxtBox().sendKeys("ABC123");
        darwinFindCarPage.getAQuoteBtn().click();
        darwinFindCarPage.isInformationCorrectBtn().click();*/
    }

    public void filYourCarSection(){
        new Select (darwinYourCarPage.isAlarmFittedDropDown()).selectByIndex(2);
        new Select (darwinYourCarPage.isImmobiliserFittedDropDown()).selectByIndex(2);
        darwinYourCarPage.isTrackingDeviceFittedBtn(false).click();
        darwinYourCarPage.isABSFittedBtn(false).click();
        darwinYourCarPage.isCarLeftHandDriveBtn(true).click();
        new Select (darwinYourCarPage.noOfseatsDropDown()).selectByIndex(2);
        darwinYourCarPage.isCarPurchasedBtn(true).click();
        darwinYourCarPage.carMarketValueTxtBox().sendKeys("5000");
        new Select (darwinYourCarPage.carOwnerDropdown()).selectByIndex(2);
        new Select (darwinYourCarPage.registeredKeeperDropdown()).selectByIndex(2);
        darwinYourCarPage.carModificationsBtn(false).click();
        darwinYourCarPage.carImportedBtn(false).click();
        darwinYourCarPage.confirmYourCarSectionBtn().click();

        /*More info about the car*/
        new Select (darwinYourCarPage.carParkedOvernightdropDown()).selectByIndex(2);
        new Select (darwinYourCarPage.carParkedOverNightLocationDropDown()).selectByIndex(2);
        new Select (darwinYourCarPage.carParkedDayLocationDropDown()).selectByIndex(2);
        new Select (darwinYourCarPage.NumberOfCarsDropDown()).selectByIndex(2);
        new Select (darwinYourCarPage.useOfCarDropDown()).selectByIndex(2);
        darwinYourCarPage.annualMileageTextBox().sendKeys("2500");
        darwinYourCarPage.confirmYourCarSectionBtn().click();
    }



    /**
     * Description : Generic method to perform any action on any Webelement on given page
     *
     * @param page  Page object which contain Webelement
     * @param field String array where field[0] is the name of Webelement from Page class and field[1] is the action or value
     */
    public void fillDetailsInScreen(AbstractSteps page, String[] field) {


        waitForElementEnable(page, field[0]);


        for (int i = 0; i < 100; i++) {
            try {
                if (field[0].toLowerCase().contains("dropdown")) {
                    selectOptionFromDropdown(page, field);
                } else if (field[0].toLowerCase().contains("textfield")) {
                    enterTextInTextField(page, field);
                } else if (field[0].toLowerCase().contains("label")) {
                    page.findElementVisible(field[0]);
                } else if (field[0].toLowerCase().contains("list")) {
                    selectOptionFromList(page, field);
                } else if (field[0].toLowerCase().contains("radiobutton")) {
                    selectRadioButton(page, field);
                } else if (field[0].toLowerCase().contains("checkbox")) {
                    selectCheckBox(page, field);
                } else if (field[0].toLowerCase().contains("button")) {
                    clickButton(page, field);
                } else {
                    if (field[1].toLowerCase().contains("navigateclick")) {
                        ((JavascriptExecutor) getDriver).executeScript("arguments[0].scrollIntoView(true);", page.findElementIsClickable(field[0]));
                    }
                    page.findElementIsClickable(field[0]).click();
                }

            } catch (Exception e) {
                if (i < 99) {
                    if (getDriver.findElements(By.xpath("//app-root[@class='is-loading']")).size() != 0) {

                        continue;
                    } else if (e.toString().contains("is not clickable at point")) {
                        System.out.println("Element " + field[0] + " on " + page.toString() + " is not clickable for attempt " + i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        continue;
                    } else if (e.toString().contains("stale element reference: element is not attached to the page document")) {
                        System.out.println("Element " + field[0] + " on " + page.toString() + " is not attached to the page document " + i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        continue;
                    } else if (e.toString().contains("waiting for presence of element")) {
                        waitForPageLoad();
                        i = i + 98;
                        continue;
                    }
                }
                Assert.fail("Exception occurred in WebElement: " + field[0] + "\n" + e.toString());
            }

            return;
        }

    }
    /**
     * Description : Generic method to select option from a dropdown
     *
     * @param page  Page object which contains dropdown Webelement
     * @param field String array where field[0] is the name of dropdown Webelement from Page class and field[1] is the option which need to be selected
     */
    private void selectOptionFromDropdown(AbstractSteps page, String[] field) {
        Select select = waitForOptions(page, field);
//        System.out.println("Before select " + field[1]);
        select.selectByVisibleText(field[1]);
        //System.out.println("After select" + field[1]);
        for (int i = 0; i < 10; i++) {
            if (!select.getFirstSelectedOption().getText().contentEquals(field[1])) {
                System.out.println("current value " + select.getFirstSelectedOption().getText());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                select.selectByVisibleText(field[1]);
            } else {
                //      System.out.println("current value" + select.getFirstSelectedOption().getText());
                break;
            }
        }
    }


    /**
     * Description : Generic method to select option from a List
     *
     * @param page  Page object which contains dropdown Webelement
     * @param field String array where field[0] is the name of List Webelement from Page class and field[1] is the option which need to be selected
     */
    private void selectOptionFromList(AbstractSteps page, String[] field) {

        page.findElementIsClickable(field[0]).findElement(By.xpath("li[text()='" + field[1] + "']")).click();

    }


    /**
     * Description : Generic method to select option from a List
     *
     * @param page  Page object which contains dropdown Webelement
     * @param field String array where field[0] is the name of List Webelement from Page class and field[1] is the option which need to be selected
     */
    private void selectRadioButton(AbstractSteps page, String[] field) throws InterruptedException {
//        for (int i = 0; i < 100; i++) {
//            try {
        page.findElementIsClickable(field[0]).click();
//            } catch (WebDriverException e) {
//                if (e.toString().contains("is not clickable at point")) {
//                    System.out.println("Element " + field[0] + " is not clickable");
//                    Thread.sleep(100);
//                    continue;
//                }
//            }
//            return;
//        }
    }

    /**
     * Description : Generic method to select option from a List
     *
     * @param page  Page object which contains checkbox Webelement
     * @param field String array where field[0] is the name of checkBox Webelement from Page class and field[1] is the value as select or deselect
     */
    private void selectCheckBox(AbstractSteps page, String[] field) {
        WebElement precedingSiblingElement = page.findElement(field[0]).findElement(By.xpath("preceding-sibling::input[@type='checkbox']"));

        if (field[1].toLowerCase().contentEquals("select")) {

            if (precedingSiblingElement.isSelected()) {
                return;
            } else {
                page.findElementIsClickable(field[0]).click();
            }

        } else {
            if (!precedingSiblingElement.isSelected()) {
                return;
            } else {
                page.findElementIsClickable(field[0]).click();
            }
        }

    }

    /**
     * Description : Generic method to click a Button
     *
     * @param page  Page object which contains checkbox Webelement
     * @param field String array where field[0] is the name of checkBox Webelement from Page class and field[1] is the value as select or deselect
     */
    private void clickButton(AbstractSteps page, String[] field) throws InterruptedException {
        page.findElementIsClickable(field[0]).click();
        Thread.sleep(100);
//        int counter = 0;
//        // System.out.println("I am here ");
//        while (getDriver.findElements(By.xpath("//app-root[@class='is-loading']")).size() != 0 && counter < 900) {
//
//            //while (globalContainerPage.findElements("appLoadingState").size() != 0 && counter < 900) {
//            counter++;
//            //   System.out.println("waiting for app load to finish " + counter);
//            Thread.sleep(100);
//        }
        //System.out.println("app load finished " + counter);

    }

    /**
     * Description : Generic method to validate if given option is present in a List
     *
     * @param page  Page object which contains dropdown Webelement
     * @param field String array where field[0] is the name of List Webelement from Page class and field[1] is the option which need to be checked
     */
    private void validateList(AbstractSteps page, String[] field) {

        Assert.assertTrue(page.findElementIsClickable(field[0]).findElements(By.xpath("li[text()='" + field[1] + "']")).size() > 0);
    }

    /**
     * Description : Generic method to clear, delete(using back space) or enter text in a Textbox
     *
     * @param page  Page object which contains Textbox Webelement
     * @param field String array where field[0] is the name of Textbox Webelement from Page class and field[1] is the action or value
     */
    private void enterTextInTextField(AbstractSteps page, String[] field) throws InterruptedException {
        if (field[1].contentEquals("clear")) {
            String value = page.findElementPresent(field[0]).getAttribute("value");
            while (value.length() > 0) {
                page.findElementPresent(field[0]).sendKeys(Keys.BACK_SPACE);
                value = page.findElementPresent(field[0]).getAttribute("value");
            }
        } else if (field[1].contentEquals("space")) {
            page.findElementPresent(field[0]).clear();
            page.findElementPresent(field[0]).sendKeys(" ");
        } else {
            for (int i = 0; i < 10; i++) {
                try {
                    page.findElementVisible(field[0]).clear();
                    page.findElementPresent(field[0]).sendKeys(field[1]);
                    break;
                } catch (Exception InvalidElementStateException) {
                    System.out.println("Invalid Element State Exception for :" + field[0]);
                    Thread.sleep(100);
                    continue;
                }
            }
        }
    }

    /**
     * Description : Generic method to return current day, month or year in MMM,D,YYYY format
     *
     * @param value String containing currentDay, currentMonth or currentYear that need to be return
     * @return return current day, month or year in MMM,D,YYYY format based on value
     */
    public String getCurrentDate(String value) {
        SimpleDateFormat format = new SimpleDateFormat("MMM,d,yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("d MMMM yyyy");
        String input = format.format(new Date());
        String[] out = input.split(",");

        if (value.contentEquals("currentDay")) {
            return out[1];
        } else if (value.contentEquals("currentMonth")) {

            return out[0];
        } else if (value.contentEquals("today")) {

            return format1.format(new Date());
        } else if (value.contentEquals("today date")) {

            return format2.format(new Date());
        } else if (value.contentEquals("today to 1year")) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, 1);
            cal.add(Calendar.DATE, -1);
            Date nextYear = cal.getTime();
            return format1.format(new Date()) + " to " + format1.format(nextYear);
        } else {
            return out[2];
        }
    }
    /**
     * Description : Generic method to wait until(max 10 seconds) given Webelement is enabled on specified page
     *
     * @param page    Page object which contains the Webelement
     * @param element Webelement present in the page class
     */
    private void waitForElementEnable(AbstractSteps page, String element) {
        for (int i = 0; i < 6; i++) {

            if (page.findElementPresent(element).isEnabled() == true)
                return;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    /**
     * Description : Generic method to wait until(max 10 seconds) given option to appear in specified dropdown
     *
     * @param page   Object of Select class which hold Dropdown Webelement
     * @param option Option which need to be checked in the dropdown
     */
    private Select waitForOptions(AbstractSteps page, String[] option) {
        Select select = new Select(page.findElementPresent(option[0]));
        for (int i = 0; i < 50; i++) {
            List<WebElement> options = select.getOptions();
            for (WebElement element : options) {
                if (element.getText().equalsIgnoreCase(option[1])) {
                    return select;
                }
            }
            try {
                Thread.sleep(500);
                select = new Select(page.findElementPresent(option[0]));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return select;
    }

}
