package api.tests;

import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import org.testng.annotations.Test;

public class DeleteProjectTest {

    @Test
    public void deleteProjectApi() {
        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        String deleteProjectById = String.valueOf(projectApiSteps.deleteProject("70"));
    }

}
