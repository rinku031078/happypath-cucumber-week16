package com.jotform.pages;

import com.jotform.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage extends Utility {

    private static final Logger log = LogManager.getLogger(PersonalDetailsPage.class.getName());
    public PersonalDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (id = "first_2")
    WebElement firstName;

    @CacheLookup
    @FindBy (id = "last_2")
    WebElement lastName;

    @CacheLookup
    @FindBy (xpath = "(//button[contains(@class,'jfInput-button forNext')])[1]")
    WebElement nextButton;

    public void enterFirstNameAndLastName(String fName, String lname) throws InterruptedException {
        log.info("Entering first name " + firstName.toString());
        doSendTextToElement(firstName, fName);
        log.info("Entering last name " + lastName.toString());
        doSendTextToElement(lastName, lname);
        Thread.sleep(1000);
        log.info("clicking on next button " + nextButton.toString());
        doClickOnElement(nextButton);
    }


    public void clickOnNextButton(){
        doClickOnElement(nextButton);
    }


}
