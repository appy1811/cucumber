package Steps;

import Testng.Calculator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableSteps {
    Calculator calculator;
    List<Integer> actualResult=new ArrayList<Integer>();
    List<Integer> expectedResult=new ArrayList<Integer>();
    int number1;
    int number2;


   // int expectedResult;



    @Given("I have created a calculator instance")
    public void iHaveCreatedACalculatorInstance() {
        calculator = new Calculator();

    }

    @When("I send following numbers")
    public void iSendFollowingNumbers(DataTable table) {
        for (int i=1;i<=4;i++)
        {
            String operator=(table.cell(i,2));
            number1=Integer.parseInt(table.cell(i,0));
            number2=Integer.parseInt(table.cell(i,1));
            switch (operator)
            {
                case "+": actualResult.add(calculator.add(number1,number2)); break;
                case "-": actualResult.add(calculator.sub(number1,number2));break;
                case "*": actualResult.add(calculator.multi(number1,number2));break;
                case "/": actualResult.add(calculator.div(number1,number2));break;
            }



        }



    }

    @Then("I get following result")
    public void iGetFollowingResult(DataTable table) {

        expectedResult.add(0,0);
        for (int i=1;i<expectedResult.size();i++){
            expectedResult.add(Integer.parseInt(table.cell(i,0)));
            Assert.assertEquals(expectedResult, actualResult);
        }


    }
}
