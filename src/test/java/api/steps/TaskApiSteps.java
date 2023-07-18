package api.steps;

import api.methods.Projects;
import api.methods.Tasks;
import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.projects.CreateTask;
import api.models.args.projects.ProjectId;
import api.models.args.projects.TaskId;
import api.models.args.users.CreateUser;
import io.restassured.response.Response;

import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class TaskApiSteps extends BaseApiSteps {

    public String createTask(String taskTitle, Integer projectId) {
        CreateTask args = CreateTask.builder()
                .title(taskTitle)
                .project_id(projectId)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(Tasks.CREATE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    public boolean deleteTask(Integer taskId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new TaskId(Integer.valueOf(taskId)))
                .method(Tasks.DELETE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

}
