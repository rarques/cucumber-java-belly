package mybelly.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mybelly.Belly;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BellyCukesSteps {
    private Belly belly;
    private int waitingTime;

    @Given("^I have (\\d+) (?:cuke|cukes) in my belly$")
    public void iHaveCukesInMyBelly(int cukes) throws Throwable {
        belly = new Belly();
        belly.eatCukes(cukes);
    }

    @Then("^My belly should (?:be )?\"([^\"]*)\"$")
    public void myBellyShould(String expectedSound) throws Throwable {
        String actualSound = belly.getSound(waitingTime);
        assertThat(actualSound, is(expectedSound));
    }

    @When("^I don't wait$")
    public void iDonTWait() throws Throwable {
        belly.getSound(0);
    }

    @When("^I wait (\\d+) hour$")
    public void iWaitHour(int waitingTime) throws Throwable {
        this.waitingTime = waitingTime;
    }
}
