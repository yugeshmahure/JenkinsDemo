package test;


//import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverScript
{

    AndroidDriver driver;
    WebDriverWait wait;


@BeforeTest
public void setUp() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("VERSION", "6.0.1");
    capabilities.setCapability("deviceName","Redmi Note 3");
    capabilities.setCapability("platformName","Android");
    //capabilities.setCapability("app","C:\\Users\\Yugesh.Mahure\\Desktop\\WhatsApp.apk");
    capabilities.setCapability("noReset",true);
    capabilities.setCapability("appPackage", "app.globallogic.com.glo");
    capabilities.setCapability("appActivity","app.globallogic.com.glo.view.activities.Splash");
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver,15);
}
@Test(enabled = false)
    public void TestLogin() throws InterruptedException {
    String username = "yugesh.mahure";
    Thread.sleep(5000);

    driver.findElement(By.xpath("//*[@text = 'Username']")).sendKeys(username);
    driver.findElement(By.xpath("//*[contains(@resource-id,'password')]")).sendKeys("Version4#"); driver.findElement(By.xpath("//*[contains(@resource-id,'password')]")).sendKeys("Version4#");
    driver.findElement(By.xpath("//*[@text = 'Login']")).click();
    Thread.sleep(8000);
    driver.findElement(By.xpath("//*[contains(@content-desc,'Open')]")).click();
    Thread.sleep(3000);
    String homeusername = driver.findElement(By.xpath("//*[contains(@resource-id,'username')]")).getText();
    String firstName = homeusername.toLowerCase().substring(0,6);
    if(username.contains(firstName.toLowerCase()))
    {
        Assert.assertEquals(true,true);
    }
    else
        Assert.assertFalse(true);
    driver.findElement(By.xpath("//*[@text = 'Home']")).click();
}
@Test(enabled = false)
public void TestSearch() throws InterruptedException {
    Thread.sleep(5000);

    driver.findElement(By.xpath("//*[contains(@resource-id,'action_search')]")).click();
    driver.findElement(By.xpath("//*[contains(@resource-id,'searchKeyword')]")).sendKeys("Selenium");
    driver.findElement(By.xpath("//*[contains(@resource-id,'searchType')]")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text = 'Skill']")));
    driver.findElement(By.xpath("//*[@text = 'Skill']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'tvResultType')]")));
    String type = driver.findElement(By.xpath("//*[contains(@resource-id,'tvResultType')]")).getText();
    if(type.equalsIgnoreCase("People"))
        Assert.assertFalse(false);
    driver.findElement(By.xpath("//*[contains(@content-desc,'up')]")).click();
}

@Test
public void TestUpdateInfo()
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Open')]")));
    driver.findElement(By.xpath("//*[contains(@content-desc,'Open')]")).click();
    driver.findElement(By.xpath("//*[@text = 'Me']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text = 'TEAMS']")));
    driver.findElement(By.xpath("//*[@text = 'TEAMS']")).click();
    //TouchActions touchActions = new TouchActions(driver);

}
}
