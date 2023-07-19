package api.tests;

import api.steps.ProjectApiSteps;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectApiTests {

    private String projectId;

    @Test
    @Description("Check Project can be created with valid mandatory data (name)")
    public void createProjectApiPositive() {
        String name = "project YS";
        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        projectId = String.valueOf(projectApiSteps.createProject(name));
        System.out.println("Project was created successfuly with id: " + projectId);
    }
    @Test
    @Description("Check Project could be deleted")
//    @AfterMethod(alwaysRun = true)
    public void removeProjectAfterTest() {
        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        projectApiSteps.deleteProject(projectId);
        System.out.println("Project was deleted succesfuly");
    }

    @Test
    @Description("Check Project could not be created with empty name")
    public void createProjectApiNegative() {
        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        projectApiSteps.createProject("");
        Assert.assertEquals(false,false);
        System.out.println("Project was not created because mandatory data is empty");
    }
}
