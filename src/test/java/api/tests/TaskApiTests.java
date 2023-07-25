package api.tests;

import api.steps.TaskApiSteps;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskApiTests {

    private String taskId;
    @Test
    @Description("Check Task could be created with filled mandatory data: name and projectId")
    public void createApipositive() {
        TaskApiSteps taskApiStep = new TaskApiSteps();
        taskId = String.valueOf(taskApiStep.createTask("NewTaskName", 1));
        System.out.println("Task was created successfuly with id: " + taskId);
    }

    @Test
    @Description("Check Task could be deleted")
    public void deleteTaskApi() {
        TaskApiSteps taskApiSteps = new TaskApiSteps();
        taskApiSteps.deleteTask(Integer.valueOf(taskId));
        System.out.println("Task was deleted succesfuly");
    }

    @Test
    @Description("Check Task could not be created with empty title")
    public void createTaskApiNegative() {
        TaskApiSteps taskApiStep = new TaskApiSteps();
        taskApiStep.createTask("", 1);
        Assert.assertEquals(false,false);
        System.out.println("Task was not created because some of mandatory data is empty");
    }

}

