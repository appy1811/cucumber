package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.CheckOutPage;
import pages.ConfirmationPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class CheckedSteps {
    HomePage homepage;
    LoginPage loginpage;
    ConfirmationPage confirmationpage;
    CheckOutPage checkOutPage;




    String data;


    @Given("I am signed in with following credentials:")
    public void iAmSignedInWithFollowingCredentials(DataTable table)throws InterruptedException {
        loginpage=new LoginPage();

           homepage=new HomePage();
           homepage.clickOnSignInLink();
           loginpage.enterLoginCredentials(table);
           loginpage.clickOnLoginButton();
        }



    @When("I click on {string} on a product with name {string}")
    public void iClickOnAddToCartOnAProductWithNameIPhoneXR(String link,String phone) throws InterruptedException {
       homepage =new HomePage();
       homepage.addToCart();

        //actions.moveToElement(driver.findElement(By.xpath("//div[@id=8]//div[@class='shelf-item__buy-btn']")));

        Thread.sleep(2000);
    }

    @And("I click on checkout")
    public void iClickOnCheckout() {
       homepage=new HomePage();
       homepage.checkOut();
    }

    @And("I enter shipping address as below:")
    public void iEnterShippingAddressAsBelow(DataTable table) throws InterruptedException {
    checkOutPage=new CheckOutPage();
    checkOutPage.shippingDetails(table);

    }
    @And("I click on Submit button")
    public void iClickOnSubmitButton() {
        checkOutPage=new CheckOutPage();
        checkOutPage.clickOnSubmit();


    }
    @Then("I see a message {string}")
    public void iSeeAMessageYourOrderHasBeenSuccessfullyPlaced(String expectedMessage) throws InterruptedException {
        confirmationpage=new ConfirmationPage();
        Assert.assertEquals(confirmationpage.getConfirmationMessage(),expectedMessage);



    }
    @And("I see the product {string} on final page right hand side")
    public void iSeeTheProductIPhoneXROnFinalPageRightHandSide(String expectedInfo) {
        confirmationpage=new ConfirmationPage();
       Assert.assertEquals( confirmationpage.getProductInfo(),expectedInfo);


    }


}
