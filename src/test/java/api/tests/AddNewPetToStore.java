package api.tests;

import api.models.args.pet.AddPetToStore;
import api.models.args.pet.AddPetStoreBuilder;
import api.steps.BaseApiStep;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddNewPetToStore extends BaseApiStep {

    @Test
    @Description("Check Pet can be created with valid mandatory data (name)")
    public void testCreatePetWithValidData() {
        // Create Pet object
        AddPetStoreBuilder addPetStoreBuilder = new AddPetStoreBuilder();
        AddPetToStore pet = addPetStoreBuilder.buildPet("kitty", 123);

        // Convert AddPetStore object to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody;
        try {
            requestBody = objectMapper.writeValueAsString(pet);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Perform POST request to create a new pet
        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/pet");

        // Assertion
        response.then()
                .statusCode(200)
                .body("name", equalTo("kitty"))
                .body("status", equalTo("available"));
        System.out.println("Pet was created successfuly with id: " + response.path("id") + " and name: " + response.path("name"));
    }

    @Test
    @Description("Check HTTP response status code 405 appeared if user try to send DELETE Method that is Not Allowed for the requested resource")
    public void testStatusCodeForNotAllowedMethod() {
        // Create Pet object
        AddPetStoreBuilder addPetStoreBuilder = new AddPetStoreBuilder();
        AddPetToStore pet = addPetStoreBuilder.buildPet("kitty", 123);

        // Convert AddPetStore object to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody;
        try {
            requestBody = objectMapper.writeValueAsString(pet);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Perform POST request to create a new pet
        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .delete("/pet");

        // Assertion
        response.then()
                .statusCode(405);
        System.out.println("405 means Method Not Allowed. Server has rejected the DELETE method for the requested resource.");
    }

    // We could add more tests here to check validation of other fields like namwe, photoUrls, tags, category, etc. But I don't see any validation on the server side for these fields.

}
