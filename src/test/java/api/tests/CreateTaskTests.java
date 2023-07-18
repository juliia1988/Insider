package api.tests;

import api.steps.ProjectApiSteps;
import api.steps.TaskApiSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateTaskTests {
    @Test
    public void createTaskApi() {
        TaskApiSteps taskApiStep = new TaskApiSteps();
        String createdTask = taskApiStep.createTask("NewTaskName", 1);
        Assert.assertFalse(createdTask.isEmpty(), "Task was not created");
        System.out.println(createdTask.toString());
    }
}

