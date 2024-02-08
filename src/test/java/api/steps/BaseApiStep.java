package api.steps;

import io.restassured.RestAssured;
import org.junit.Before;

public class BaseApiStep {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}
