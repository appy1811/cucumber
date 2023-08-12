package pages;

import core.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage  extends TestContext {
    public void clickOnSignInLink() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='signin']")).click();

        Thread.sleep(3000);
        Thread.sleep(2000);
    }
    public void addToCart() throws InterruptedException {
        Actions actions=new Actions(driver);

        Thread.sleep(2000);
        WebElement element=driver.findElement(By.xpath("//p[contains(text(),'iPhone XR')]/following-sibling::div[contains(text(),'Add to cart')]"));
        actions.moveToElement(element).click().perform();


    }
    public void checkOut() {
        WebElement checkeOutButton=driver.findElement(By.xpath("//div[@class='float-cart__content']/div/div[@class='buy-btn']"));
        checkeOutButton.click();

        System.out.println("Clicked on checkout");
    }
}
