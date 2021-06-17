package resources;

import co.edu.unbosque.Final_proyect_prog.services.VisitService;
import resources.Pojos.VisitPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("userApp/vet/visit")
public class VisitResource {

    @POST
    @Path("{pet_id}/{vet_id}/{type}/{description}")
    public Response createVisit(@PathParam("pet_id") int pet_id,
                                @PathParam("vet_id") String vet_id,
                                @PathParam("type") String type,
                                @PathParam("description") String description) {
        VisitService visitService = new VisitService();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yy");
        Date date = new Date();
        if (visitService.createVisit(vet_id, pet_id, description, type, d.format(date))) {

            return Response.status(Response.Status.CREATED).build();

        } else {

            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @POST
    @Path("{pet_id}/{vet_id}/{type}/{description}/{microchip}")
    public Response createVisitWithMicro(@PathParam("pet_id") int pet_id,
                                         @PathParam("vet_id") String vet_id,
                                         @PathParam("type") String type,
                                         @PathParam("description") String description,
                                         @PathParam("microchip") long microchip) {
        VisitService visitService = new VisitService();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yy");
        Date date = new Date();
        if (visitService.createVisitMicro(vet_id, pet_id, description, type, d.format(date), microchip)) {
            return Response.status(Response.Status.CREATED).build();

        } else {

            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @GET
    @Path("{pet_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listVistOfPet(@PathParam("pet_id") int pet_id) {
        VisitService visitService = new VisitService();
        List<VisitPOJO> visitPOJOS = visitService.visitsPet(pet_id);
        if (visitPOJOS != null) {
            return Response.ok().entity(visitPOJOS).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("{pet_id}/{first_date}/{second_date}")
    public Response listOfPetWithDate() {

    }

}
