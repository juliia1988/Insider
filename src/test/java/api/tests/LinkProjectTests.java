package api.tests;

import api.steps.LinkProjectApiSteps;
import api.steps.ProjectApiSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LinkProjectTests {

    @Test
    public void linkProjectApi() {
        LinkProjectApiSteps linkProjectApiStep = new LinkProjectApiSteps();
        Boolean linkProject = linkProjectApiStep.linkProject("60", "18");
        Assert.assertTrue(linkProject.equals(true));
        System.out.println(linkProject.toString());
    }
}
