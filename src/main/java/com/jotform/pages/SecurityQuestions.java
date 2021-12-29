package com.jotform.pages;

import com.jotform.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurityQuestions extends Utility {

    private static final Logger log = LogManager.getLogger(SecurityQuestions.class.getName());
    public SecurityQuestions() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//div[@class='jfDropdown-chipContainer']")
    WebElement dropdown;

    @CacheLookup
    @FindBy (id = "input_6_field_2")
    WebElement answerField;

    @CacheLookup
    @FindBy (xpath = "//li[contains(text(),'Favourite School')]")
    WebElement favouriteSchool;

    @CacheLookup
    @FindBy (xpath = "//div[@data-type='control_mixed']//button[@aria-label='Next'][normalize-space()='Next']")
    WebElement nextButton;

    public void selectSecurityQuestion(String answer) throws InterruptedException {
        log.info("Clicking on dropdown " + dropdown.toString());
        doClickOnElement(dropdown);
        Thread.sleep(2000);
        log.info("Selecting Favourite school " + favouriteSchool.toString());
        doMouseHoverAndClick(favouriteSchool);
        log.info("Entering answer for Security question " + answerField.toString());
        doSendTextToElement(answerField, answer);
        Thread.sleep(1000);
//        doSelectByVisibleTextFromDropDown(dropdown,question);
        log.info("Clicking on next button " + nextButton.toString());
        doClickOnElement(nextButton);
    }

    public void answerSecurityQuestion(String answer) throws InterruptedException {
        Thread.sleep(1000);
        doSendTextToElement(answerField, answer);
    }

}
