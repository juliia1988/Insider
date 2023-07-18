package api.tests;

import api.steps.ProjectApiSteps;
import api.steps.TaskApiSteps;
import org.testng.annotations.Test;

public class DeleteTaskTests {

    @Test
    public void deleteTaskApi() {
        TaskApiSteps taskApiSteps = new TaskApiSteps();
        String deleteProjectById = String.valueOf(taskApiSteps.deleteTask(38));
    }

}
