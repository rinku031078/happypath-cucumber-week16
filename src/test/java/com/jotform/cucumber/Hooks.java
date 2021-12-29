package com.jotform.cucumber;

import com.cucumber.listener.Reporter;
import com.jotform.propertyreader.PropertyReader;
import com.jotform.utility.Utility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks extends Utility {

    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
        Reporter.assignAuthor("Anand Tripathi");
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            String screenshotPath = Utility.getScreenshot(driver, scenario.getName().replace(" ", "_"));
            try {
                Reporter.addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        closeBrowser();
    }
}
