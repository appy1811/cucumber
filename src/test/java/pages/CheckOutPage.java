package pages;

import core.TestContext;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;

public class CheckOutPage extends TestContext {
    public void shippingDetails(DataTable table) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("firstNameInput")).sendKeys(table.cell(1,0).trim());

        driver.findElement(By.id("lastNameInput")).sendKeys(table.cell(1,1).trim());

        driver.findElement(By.id("addressLine1Input")).sendKeys(table.cell(1,2).trim());
        driver.findElement(By.id("provinceInput")).sendKeys(table.cell(1,3).trim());

        driver.findElement(By.id("postCodeInput")).sendKeys(table.cell(1,4).trim());


    }

    public void clickOnSubmit()
    {
        driver.findElement(By.id("checkout-shipping-continue")).click();
    }
}
