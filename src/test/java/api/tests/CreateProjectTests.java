package api.tests;

import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class CreateProjectTests {

    @Test
    public void createProjectApi() {
        ProjectApiSteps userApiStep = new ProjectApiSteps();
        String createdProject = userApiStep.createProject("NewProjectName");
        Assert.assertTrue(createdProject.length() > 0);
        System.out.println(createdProject.toString());
    }
}
