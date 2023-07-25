package api.tests;

import api.steps.LinkProjectApiSteps;
import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LinkProjectTests {

    private String userId;
    private String projectId;

    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();

    @Test
    @Description("Check Project can be linked to User succesfully")
    public void linkProjectApiTestPositive() {
        UserApiSteps userApiStep = new UserApiSteps();
        userId = String.valueOf(userApiStep.createUser("NewName", "Qwerty123!"));
        System.out.println("User was created successfuly with id: " + userId);

        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        projectId = String.valueOf(projectApiSteps.createProject("Project to Link"));
        System.out.println("Project was created successfuly with id: " + projectId);

        LinkProjectApiSteps linkProjectApiStep = new LinkProjectApiSteps();
        Boolean linkProject = linkProjectApiStep.linkProject(projectId, userId);
        Assert.assertTrue(linkProject.equals(true));
        System.out.println("Project with id " + projectId + " was sucdesfully linked to the User with id " + userId);
    }

    @AfterMethod(alwaysRun = true)
    public void removeProjectAfterTest() {
        projectApiSteps.deleteProject(projectId);
    }

    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(userId);
    }
}
