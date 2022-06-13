package com.epam.task.cucumber.steps;

import com.epam.task.cucumber.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    @Given("I open Homepage")
    public void iOpenHomepage() {
        loginPage.openHomePage();
    }

    @When("I enter a {string} and {string}")
    public void iEnterLoginAndPassword(String login, String password) {
        loginPage.setLoginAndPassword(login, password);
    }

    @And("Click to login button")
    public void clickToButton() {
        loginPage.clickLoginButton();
    }

    @Then("Page with {string} is opened")
    public void pageWithUrlIsOpened(String url) {
        Assertions.assertThat(loginPage.getPageUrl()).as("Wrong URL!").isEqualTo(url);
    }

    @Then("Url is not change")
    public void urlIsNotChange() {
        Assertions.assertThat(loginPage.getPageUrl()).as("Wrong URL!").isEqualTo(loginPage.URL);
    }

    @When("All fields is empty")
    public void allFieldsIsEmpty() {
        Assertions.assertThat(loginPage.isUserNameFieldEmpty())
                .as("Fields is not empty!").isEqualTo("");
        Assertions.assertThat(loginPage.isPasswordFieldEmpty())
                .as("Field is not empty!").isEqualTo("");
    }

    @Then("I can see error message")
    public void iCanSeeErrorMessage() {
        Assertions.assertThat(loginPage.isErrorMessageDisplayed())
                .as("Error message is not displayed!").isTrue();
    }
}
