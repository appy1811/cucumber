package Steps;

import core.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.ConfirmationPage;
import pages.LoginPage;

import java.util.List;

public class BSSteps extends TestContext {
   LoginPage loginpage;
    @Given("I am on BS demo website")
    public void iAmOnBSDemoWebsite() {

    }

    @When("I click on {string} link")
    public void iClickOnSignInLink(String link) throws InterruptedException {
        driver.findElement(By.id("signin")).click();
        Thread.sleep(2000);
    }

    @And("I enter following credentials")
    public void iEnterFollowingCredentials(DataTable table) throws InterruptedException {
      loginpage=new LoginPage();
      loginpage.enterLoginCredentials(table);
    }





    @And("I click on Login button")
    public void iClickOnLoginButton() throws InterruptedException {
       loginpage=new LoginPage();
       loginpage.clickOnLoginButton();
    }
    @Then("I am successfully logged in")
    public void iAmSuccessfullyLoggedIn() {
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//          wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//span[contains(text(),'demouser')]"))));
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'demouser')]")).isDisplayed());

    }
    @And("I enter {string} and {string} credentials")
    public void iEnterUsernameAndPasswordCredentials(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.className("css-tlfecz-indicatorContainer")); //username dropdown
        elements.get(0).click();
        driver.findElement(By.xpath("//*[contains(text(),'"+username+"')]")).click();
        elements.get(1).click();
        driver.findElement(By.xpath("//*[contains(text(),'"+password+"')]")).click();
        Thread.sleep(2000);
    }
    @Then("I verified {string} successfully logged in")
    public void iVerifiedUsernameSuccessfullyLoggedIn(String username) {
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+username+"')]")).isDisplayed());
    }








}









