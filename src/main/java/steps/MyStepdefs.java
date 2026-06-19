package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("I open a browser")
    public void iOpenABrowser() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("I navigate to {word}")
    public void iNavigateToTheLocalForm(String url) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("I complete the following")
    public void iCompleteTheFollowing() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
