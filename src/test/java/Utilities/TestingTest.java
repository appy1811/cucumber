//package Utilities;
//
//import org.openqa.selenium.MutableCapabilities;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.net.URL;
//
//@Test
//public class TestingTest {
//    WebDriver driver;
//    public static WebDriver initWebDriver() throws IOException {
//        if (ConfigUtil.getPropValue("run_mode").equals("local")) {
//
//
//            driver = new ChromeDriver();
//            driver.get(ConfigUtil.getPropValue("base_url"));
//            // driver.get("https://bstackdemo.com/");
//            driver.manage().window().maximize();
//        } else if (ConfigUtil.getPropValue("run_mode").equals("browserstack")) {
//            String URL = "https://" + ConfigUtil.getPropValue("bs_user") + ":" + ConfigUtil.getPropValue("bs_access_key") +"@hub.browserstack.com/wd/hub";
//            MutableCapabilities capabilities = new MutableCapabilities();
//            driver = new RemoteWebDriver(new URL(URL), capabilities);
//            driver.get(ConfigUtil.getPropValue("base_url"));
//            driver.manage().window().maximize();
//        }
//
//
//        return driver;
//    }
//
//
//    public static void closeDriver(){
//        driver.close();
//        driver.quit();
//    }
//
//}
//
//
//}
