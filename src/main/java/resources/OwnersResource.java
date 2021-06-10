package resources;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/userApp/{username}/owners")
public class OwnersResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Owner owner) {
        return Response.status(Response.Status.CREATED)
                .entity(owner)
                .build();
    }



}
