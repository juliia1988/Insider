package api.tests;

import api.models.args.pet.PetId;
import api.steps.BaseApiStep;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeletePetById extends BaseApiStep {

    private int pet_id;

    @Test
    @Description("Check that Pet can be deleted by ID")

    public void deletePetById() {

        // Create a pet and get an id

        PetId petId = new PetId();
        petId.createPetAndGetId();
        pet_id = petId.getPet_id();


        // Perform DELETE request to delete a pet
        Response response = given()
                .contentType("application/json")
                .header("api_key", "special-key")
                .when()
                .delete("/pet/" + pet_id);

        // Assertion
        response.then()
                .statusCode(200);
        System.out.println("Pet was deleted successfuly with id: " + response.path("id") + " and name: " + response.path("name"));
    }

    // We could add more tests here to check validation (wrong id, no api_key) But this test failed because any validation was implemented ot this pet resourse.
    @Test
    @Description("Check error appeared if try to delete with wrong ID")

    public void deletePetByWrongId() {

        // Create a pet and get an id

        PetId petId = new PetId();
        petId.createPetAndGetId();
        pet_id = petId.getPet_id();


        // Perform DELETE request to delete a pet
        Response response = given()
                .contentType("application/json")
                .header("api_key", "special-key")
                .when()
                .delete("/pet/09");

        // Assertion
        response.then()
                .statusCode(400);
        System.out.println("Invalid id: " + response.path("message") + " and code: " + response.path("code"));
    }

}
