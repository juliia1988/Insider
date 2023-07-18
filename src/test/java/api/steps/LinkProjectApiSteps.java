package api.steps;

import api.methods.Projects;
import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.projects.LinkProject;
import io.restassured.response.Response;

import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class LinkProjectApiSteps extends BaseApiSteps {
    public Boolean linkProject(String projectId, String userId) {
        LinkProject args = LinkProject.builder()
                .project_id(Integer.valueOf(projectId))
                .user_id(Integer.valueOf(userId))
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(Projects.LINK_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }
}
