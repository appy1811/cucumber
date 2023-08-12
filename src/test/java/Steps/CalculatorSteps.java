package Steps;
import Testng.Calculator;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;



public class CalculatorSteps {
    Calculator calculator;
    int actualResult;
    int number1;
    int number2;


    @Given("I have created calculator instance")
    public void iHaveCreatedCalculatorInstance() {
        calculator = new Calculator();

    }

    @When("I send {int} and {int} to function")
    public void iSendNumberAndNumberToFunction(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;


    }
    @And("I send {string}")
    public void iSendOperator(String operator) {
        if (operator.equals("+")) {
            actualResult = calculator.add(number1, number2);

        } else if (operator.equals("-")) {
            actualResult = calculator.sub(number1, number2);

        } else if (operator.equals("*")) {
            actualResult = calculator.multi(number1, number2);

        } else if (operator.equals("/")) {

            actualResult = calculator.div(number1, number2);

        }
    }


        @Then("I get {int} as result")
        public void iGetExpectedResultAsResult (int expectedResult) {
            Assert.assertEquals(expectedResult, actualResult);
        }








}

