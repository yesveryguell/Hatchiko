package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.resource.pojos.PetPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.PetTotalPojo;
import co.edu.unbosque.Hatchiko.services.PetService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/pets")
public class PetResource {
    @GET
    @Path("/species")

    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows you to list all the pets by species
     */
    public Response listSpecies() {

        List<PetPojo> pets = new PetService().listPet();
        List<PetTotalPojo> totalPets = new ArrayList<>();

        String[] species = {"Canino", "Felino"};

        for (int i = 0; i < species.length; i++) {
            List<PetPojo> pets1 = new ArrayList<PetPojo>();
            for (int j = 0; j < pets.size(); j++) {
                if (species[i].equals(pets.get(j).getSpecies())) {
                    pets1.add(pets.get(j));
                }
            }

            totalPets.add(new PetTotalPojo("Total mascotas por la especie de " + species[i] + " es de " + (pets1.size()) + ":", pets1));
        }


        return Response.ok()
                .entity(totalPets)
                .build();
    }

    @GET
    @Path("/race")
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows you to list all the pets by race
     */
    public Response listRace() {

        List<PetPojo> pets = new PetService().listPet();
        List<PetTotalPojo> totalPets = new ArrayList<>();

        String[] race = {"Emperador", "Aleman", "Labrador"};

        for (int i = 0; i < race.length; i++) {
            List<PetPojo> pets1 = new ArrayList<PetPojo>();
            for (int j = 0; j < pets.size(); j++) {
                if (race[i].equals(pets.get(j).getRace())) {
                    pets1.add(pets.get(j));
                }
            }

            totalPets.add(new PetTotalPojo("Total mascotas por raza   " + race[i] + " es de " + (pets1.size()) + ":", pets1));
        }


        return Response.ok()
                .entity(totalPets)
                .build();
    }

    @GET
    @Path("/microchip")
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows you to list all the pets by microchip
     */
    public Response listRMicrochip() {

        List<PetPojo> pets = new PetService().listPet();
        List<PetTotalPojo> totalPets = new ArrayList<>();

            List<PetPojo> pets1 = new ArrayList<PetPojo>();
            for (int j = 0; j < pets.size(); j++) {
                if (pets.get(j).getMicrochip() != null) {
                    pets1.add(pets.get(j));
                }
            }
            totalPets.add(new PetTotalPojo("Total mascotas con microchip es de " + (pets1.size()) + ":", pets1));

            List<PetPojo> pets2 = new ArrayList<PetPojo>();
            for (int j = 0; j < pets.size(); j++) {
                if (pets.get(j).getMicrochip() == null) {
                    pets2.add(pets.get(j));
                }
            }
            totalPets.add(new PetTotalPojo("Total mascotas sin microchip es de " + (pets2.size()) + ":", pets2));

        return Response.ok()
                .entity(totalPets)
                .build();
    }

    @GET
    @Path("/size")
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows you to list all the pets by race
     */
    public Response listSize() {

        List<PetPojo> pets = new PetService().listPet();
        List<PetTotalPojo> totalPets = new ArrayList<>();

        String[] size = {"Grande", "Mediano", "Pequeño"};

        for (int i = 0; i < size.length; i++) {
            List<PetPojo> pets1 = new ArrayList<PetPojo>();
            for (int j = 0; j < pets.size(); j++) {
                if (size[i].equals(pets.get(j).getSize())) {
                    pets1.add(pets.get(j));
                }
            }

            totalPets.add(new PetTotalPojo("Total mascotas por tamaño " + size[i] + " es de " + (pets1.size()) + ":", pets1));
        }


        return Response.ok()
                .entity(totalPets)
                .build();
    }

    @GET
    @Path("/sex")
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows you to list all the pets by race
     */
    public Response listSex() {

        List<PetPojo> pets = new PetService().listPet();
        List<PetTotalPojo> totalPets = new ArrayList<>();

        String[] sex = {"Macho", "Hembra"};

        for (int i = 0; i < sex.length; i++) {
            List<PetPojo> pets1 = new ArrayList<PetPojo>();
            for (int j = 0; j < pets.size(); j++) {
                if (sex[i].equals(pets.get(j).getSex())) {
                    pets1.add(pets.get(j));
                }
            }

            totalPets.add(new PetTotalPojo("Total mascotas por sexo " + sex[i] + " es de " + (pets1.size()) + ":", pets1));
        }


        return Response.ok()
                .entity(totalPets)
                .build();
    }
}
