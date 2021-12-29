package com.jotform.pages;

import com.jotform.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFilePage extends Utility {

    private static final Logger log = LogManager.getLogger(UploadFilePage.class.getName());
    public UploadFilePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//label[contains(text(),'Browse Files')]")
    WebElement browseFilesButton;

    @CacheLookup
    @FindBy (xpath = "(//button[contains(@class,'jfInput-button forNext')])[2]")
    WebElement nextButton;


    public void clickOnBrowseFileButton(){
        doClickOnElement(browseFilesButton);
    }

    public void uploadFile() throws AWTException, InterruptedException {
        log.info("Clicking on Brwose File button " + browseFilesButton.toString());
        doClickOnElement(browseFilesButton);
        Thread.sleep(2000);

        // creating object of Robot class
        Robot robot = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection("Demo.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(5000);

        log.info("Clicking on next button " + nextButton.toString());
        doClickOnElement(nextButton);

        //        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_D);
//        robot.keyRelease(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_E);
//        robot.keyPress(KeyEvent.VK_M);
//        robot.keyPress(KeyEvent.VK_O);
//        robot.keyPress(KeyEvent.VK_PERIOD);
//        robot.keyPress(KeyEvent.VK_T);
//        robot.keyPress(KeyEvent.VK_X);
//        robot.keyPress(KeyEvent.VK_T);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        Thread.sleep(5000);
    }

//    public void clickOnNextButton() throws InterruptedException {
//        Thread.sleep(1000);
//        doClickOnElement(nextButton);
//    }
}
