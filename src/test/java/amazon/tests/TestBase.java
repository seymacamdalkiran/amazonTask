package amazon.tests;

import amazon.pages.BasePage;
import amazon.utilities.BrowserUtils;
import amazon.utilities.ConfigurationReader;
import amazon.utilities.Driver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeMethod
    public void setup(){
    driver= Driver.get();
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    wait=new WebDriverWait(driver,7);
    actions=new Actions(driver);

}
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            extentLogger.fail(result.getName());
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            extentLogger.fail(result.getThrowable());
        }
        Driver.closeDriver();
    }
    @BeforeTest
    public void setUpTest(){
        report=new ExtentReports();
        String projectPath=System.getProperty("user.dir");
        String reportPath=projectPath+"/test-output/report.html";

        htmlReporter=new ExtentHtmlReporter(reportPath);

        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Batch 3 Smoke Test");

        report.setSystemInfo("Environment","Test");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS","os.name");
        report.setSystemInfo("Test Engineer","Seyma");
    }
    @AfterTest
    public void tearDownTest(){
        report.flush();
    }
}
