package api.models.args.pet;

import api.models.args.pet.AddPetToStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddPetStoreBuilder {

    public AddPetToStore buildPet(String name, long id) {
        // Create Category object
        AddPetToStore.Category category = AddPetToStore.Category.builder()
                .id(1)
                .name("category_name")
                .build();

        // Create Tag objects
        AddPetToStore.Tag tag1 = AddPetToStore.Tag.builder()
                .id(1)
                .name("tag_name_1")
                .build();
        AddPetToStore.Tag tag2 = AddPetToStore.Tag.builder()
                .id(2)
                .name("tag_name_2")
                .build();

        // Create photoUrls list
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("url_1");
        photoUrls.add("url_2");

        // Create AddPetStore object using builder
        return AddPetToStore.builder()
                .id(123)
                .category(category)
                .name(name)
                .photoUrls(photoUrls)
                .tags(Arrays.asList(tag1, tag2))
                .status("available")
                .build();
    }
}