package api.models.args.pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetId {
    private Integer pet_id;

    public void createPetAndGetId() {

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

        // Perform PUT request to update a pet
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
        pet_id = response.path("id");
        System.out.println("Pet id: " + pet_id);
    }

    public void getPetById(int petId) {
        Response response = given()
                .contentType("application/json")
                .when()
                .get("/pet/" + petId);
        response.then()
                .statusCode(200);
        System.out.println("Pet was found by id: " + response.path("id") + " and name: " + response.path("name"));
    }

    public void getPetByStatus(String available) {
        Response response = given()
                .contentType("application/json")
                .when()
                .get("/pet/findByStatus?status=" + available);
        response.then()
                .statusCode(200);
        System.out.println("Pet was found by status: " + response.path("id") + " and name: " + response.path("name"));
    }
}
