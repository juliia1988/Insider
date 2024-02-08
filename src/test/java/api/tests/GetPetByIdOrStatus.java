package api.tests;

import api.models.args.pet.PetId;
import api.steps.BaseApiStep;
import io.qameta.allure.Description;
import org.junit.Test;


public class GetPetByIdOrStatus extends BaseApiStep {

    private int pet_id;

    @Test
    @Description("Check that Pet can found by id")
    public void getPetById() {
        // Create a pet and get an id
        PetId petId = new PetId();
        petId.createPetAndGetId();
        pet_id = petId.getPet_id();
        // Perform GET request to get a pet by id
        petId.getPetById(pet_id);
    }

    @Test
    @Description("Check that Pet can found by Status")
    public void getPetByStatus() {
        // Create a pet and get an id
        PetId petId = new PetId();
        petId.createPetAndGetId();
        pet_id = petId.getPet_id();
        // Perform GET request to get a pet by status
        petId.getPetByStatus("available");
    }


}
