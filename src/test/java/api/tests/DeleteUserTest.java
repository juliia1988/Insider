package api.tests;

import api.steps.UserApiSteps;
import org.testng.annotations.Test;

public class DeleteUserTest {

    @Test
    public void deleteUserApi() {
        UserApiSteps userApiStep = new UserApiSteps();
        String deleteUserById = String.valueOf(userApiStep.deleteUser("14"));
    }
}
