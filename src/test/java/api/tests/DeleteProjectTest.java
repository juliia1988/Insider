package api.tests;

import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import org.testng.annotations.Test;

public class DeleteProjectTest {

    @Test
    public void deleteProjectApi() {
        ProjectApiSteps projectApiStepsApiStep = new ProjectApiSteps();
        String deleteProjectById = String.valueOf(projectApiStepsApiStep.deleteProject("48"));
    }

}
