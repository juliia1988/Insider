package api.tests;

import api.steps.ProjectApiSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateProjectTests {

    @Test
    public void createProjectApi() {
        ProjectApiSteps userApiStep = new ProjectApiSteps();
        String createdProject = userApiStep.createProject("NewProjectName");
        Assert.assertTrue(createdProject.length() > 0);
        System.out.println(createdProject.toString());
    }
}
