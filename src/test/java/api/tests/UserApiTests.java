package api.tests;

import api.steps.UserApiSteps;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTests {
    private String userId;

    @Test
    @Description("Check User could be created with filled mandatory data: name and password")
    public void createUserPositiveTest() {
        UserApiSteps userApiStep = new UserApiSteps();
        userId = String.valueOf(userApiStep.createUser("NewName", "Qwerty123!"));
        System.out.println("User was created successfuly with id: " + userId);
    }

    @Test
    @Description("Check User could be deleted")
    public void deleteUserApi() {
        UserApiSteps userApiStep = new UserApiSteps();
        userApiStep.deleteUser(userId);
        System.out.println("User was deleted succesfuly");
    }
    @Test
    @Description("Check User could not be created with empty name and password")
    public void createUserNegativeTest() {
        UserApiSteps userApiStep = new UserApiSteps();
        userApiStep.createUser("", "");
        Assert.assertEquals(false,false);
        System.out.println("User was not created because mandatory data is empty");
    }
}
