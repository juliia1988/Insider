package api.tests;

import api.steps.UserApiSteps;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Locale;

public class CreateUserTests {

    @Test
    public void createUserApi() {
        UserApiSteps userApiStep = new UserApiSteps();
        String createdUser = userApiStep.createUser("NewName", "Qwerty123!");
        Assert.assertTrue(createdUser.length() > 0);
        System.out.println(createdUser.toUpperCase(Locale.ROOT));
    }
}
