package pages;

import core.TestContext;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends TestContext {
    public void enterLoginCredentials(DataTable table) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.className("css-tlfecz-indicatorContainer"));
        elements.get(0).click();
        driver.findElement(By.xpath("//*[contains(text(),'"+table.row(1).get(0)+"')]")).click();
        elements.get(1).click();
        driver.findElement(By.xpath("//*[contains(text(),'"+table.row(1).get(1)+"')]")).click();
    }
    public void clickOnLoginButton() throws InterruptedException {
        driver.findElement(By.id("login-btn")).click();
        Thread.sleep(2000);
    }
    }


