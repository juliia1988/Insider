package api.tests;

import api.models.BoardInfo;
import api.models.Result;
import api.models.args.users.CreateUser;
import api.models.args.users.UserId;
import api.steps.BoardApiSteps;
import api.steps.UserApiSteps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
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
