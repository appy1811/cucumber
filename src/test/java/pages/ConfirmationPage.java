package pages;

import core.TestContext;
import org.openqa.selenium.By;

public class ConfirmationPage  extends TestContext {
    public String getConfirmationMessage() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElement(By.xpath("//legend[@id='confirmation-message']")).getText();
    }

    public String getProductInfo() {
        return driver.findElement(By.xpath("//div[@class='product-column product-body']/h5")).getText();

    }
}
