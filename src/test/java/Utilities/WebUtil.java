package Utilities;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class WebUtil {
    static public WebDriver driver;

    public static WebDriver initWebDriver() throws IOException {
        if(ConfigUtil.getPropValue("run_mode").equals("local")) {
            driver = new ChromeDriver();
            driver.get(ConfigUtil.getPropValue("base_url"));
            driver.manage().window().maximize();
        }else if(ConfigUtil.getPropValue("run_mode").equals("browserstack"))
        {
            String URL = "https://" + ConfigUtil.getPropValue("bs_user") + ":" + ConfigUtil.getPropValue("bs_access_key") + "@hub.browserstack.com/wd/hub";
            MutableCapabilities capabilities = new MutableCapabilities();

            capabilities.setCapability("browserName",  ConfigUtil.getPropValue("browserName") );
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("os", ConfigUtil.getPropValue("os"));
            browserstackOptions.put("osVersion", ConfigUtil.getPropValue("osVersion"));
            browserstackOptions.put("browserVersion", ConfigUtil.getPropValue("browserVersion"));
            browserstackOptions.put("projectName", ConfigUtil.getPropValue("projectName"));
            browserstackOptions.put("buildName", ConfigUtil.getPropValue("buildName"));
            browserstackOptions.put("sessionName", ConfigUtil.getPropValue("sessionName"));
            browserstackOptions.put("seleniumVersion", ConfigUtil.getPropValue("seleniumVersion"));
            capabilities.setCapability("bstack:options", browserstackOptions);
            driver = new RemoteWebDriver(new URL(URL), capabilities);
            driver.get(ConfigUtil.getPropValue("base_url"));
            driver.manage().window().maximize();
        }
           return driver;
    }

    public static byte[] takeScrrenshot(){
        TakesScreenshot takesScreenshot=((TakesScreenshot) driver);
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }



    public static void closeDriver() {
        driver.close();
        driver.quit();
    }
}