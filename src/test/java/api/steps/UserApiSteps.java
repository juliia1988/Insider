package api.steps;

import api.enums.UserRoles;
import api.methods.Users;
import api.models.args.users.UserId;
import io.restassured.response.Response;
import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.users.CreateUser;


import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;


public class UserApiSteps extends BaseApiSteps {
    public String createUser(String username, String pass) {
        CreateUser args = CreateUser.builder()
                .username(username)
                .name(username)
                .password(pass)
                .email(username + "@mail.com")
                .role(UserRoles.USER.getRole())
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(Users.CREATE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    public boolean deleteUser(String userId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new UserId(Integer.valueOf(userId)))
                .method(Users.DELETE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

}
