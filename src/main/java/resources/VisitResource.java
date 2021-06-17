package resources;

import co.edu.unbosque.Final_proyect_prog.services.VisitService;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("userApp/vet/visit")
public class VisitResource {

    @POST
    @Path("{pet_id}/{vet_id}/{type}/{createAt}/{description}")
    public Response createVisit(@PathParam("pet_id") int pet_id,
                                @PathParam("vet_id") String vet_id,
                                @PathParam("type") String type,
                                @PathParam("createAt") String createAt,
                                @PathParam("description") String description) {
        VisitService visitService = new VisitService();
        if (visitService.createVisit(vet_id, pet_id, description, type, createAt)) {

            return Response.status(Response.Status.CREATED).build();

        } else {

            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
