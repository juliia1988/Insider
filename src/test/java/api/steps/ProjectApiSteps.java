package api.steps;

import api.enums.UserRoles;
import api.methods.Projects;
import api.methods.Users;
import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.projects.ProjectId;
import api.models.args.users.CreateUser;
import api.models.args.users.UserId;
import io.restassured.response.Response;

import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class ProjectApiSteps extends BaseApiSteps {
    public String createProject(String name) {
        CreateUser args = CreateUser.builder()
                .name(name)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(Projects.CREATE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    public boolean deleteProject(String projectId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new ProjectId(Integer.valueOf(projectId)))
                .method(Projects.DELETE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

}
