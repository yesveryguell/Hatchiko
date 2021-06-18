/**
 * Package connecting co.edu.unbosque with resources
 */
package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.PetCase;
import co.edu.unbosque.Hatchiko.jpa.entities.Visit;
import co.edu.unbosque.Hatchiko.resource.pojos.*;
import co.edu.unbosque.Hatchiko.services.PetCaseService;
import co.edu.unbosque.Hatchiko.services.PetService;
import co.edu.unbosque.Hatchiko.services.VisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * The resource package allows us to save, create, modify and list through the rest services
 */
/**
 * allows you to define complex expressions, thus converting certain sections of the URL into parameters that can be
 * used by the methods to know how to process the request.
 */
@Path("/petCases")
/**
 * The class is initialized PetCaseResource
 */
public class PetCaseResource {

    @GET
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows you to list all cases by type
     */
    public Response listCase() {

        List<PetCasePojo> cases = new PetCaseService().listCase();
        List<CaseTotalPojo> totalCases = new ArrayList<>();

        String[] casesS = {"Perdida", "Robo", "Fallecimiento"};

        for (int i = 0; i < casesS.length; i++) {
            List<PetCasePojo> case1 = new ArrayList<PetCasePojo>();
            for (int j = 0; j < cases.size(); j++) {
                if (casesS[i].equals(cases.get(j).getType())) {
                    case1.add(cases.get(j));
                }
            }

            totalCases.add(new CaseTotalPojo("Total casos por tipo " + casesS[i] + " es de " + (case1.size()) + ":", case1));
        }


        return Response.ok()
                .entity(totalCases)
                .build();
    }
}
