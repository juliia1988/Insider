package api.steps;

import api.methods.Boards;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import api.models.BoardInfo;
import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.projects.ProjectId;

import java.util.List;

import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;


public class BoardApiSteps extends BaseApiSteps {
    public Result<List<BoardInfo>> getBoardForProject(Integer projectId) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new ProjectId(projectId))
                .method(Boards.GET_BOARD)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return response.as(new TypeRef<Result<List<BoardInfo>>>() {});

//        return response.as(Result.class);
    }
}