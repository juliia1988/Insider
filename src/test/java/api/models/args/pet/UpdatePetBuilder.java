package api.models.args.pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdatePetBuilder {

    public UpdatePetById updatePet(String name, String status, long id) {

        return UpdatePetById.builder()
                .id(id)
                .name(name)
                .status(status)
                .build();
    }

}
