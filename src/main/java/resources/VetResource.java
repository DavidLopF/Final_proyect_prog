package resources;

import co.edu.unbosque.Final_proyect_prog.services.VetService;
import resources.Pojos.UserAppPOJO;
import resources.filters.Logged;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("userApp/vet/")
public class VetResource {

    @POST
    @Path("/{userName}/{password}/{email}/{name}/{address}/{neighborhood}")
    public Response create(@PathParam("userName") String userName,
                           @PathParam("password") String password,
                           @PathParam("email") String email,
                           @PathParam("name") String name, @PathParam("address") String address,
                           @PathParam("neighborhood") String neighborhood) {

        UserAppPOJO user = new UserAppPOJO(userName, email, password, "vet");
        VetService vetService = new VetService();

        if (vetService.createVet(user, name, address, neighborhood)) {

            return Response.status(Response.Status.CREATED).build(); //201
        } else {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build(); //406
        }

    }

    @PUT
    @Path("/{userName}/{address}/{neighborhood}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response update(@PathParam("userName") String userName,
                           @PathParam("address") String address,
                           @PathParam("neighborhood") String neighborhood) {
        VetService vetService = new VetService();
        if (vetService.updateVet(userName, address, neighborhood)) {
            return Response.ok().entity("melo mi perro").build();
        } else {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

    }

    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role, @HeaderParam("userName") String userName) {

        // If role doesn't match
        if (!"vet".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity(role + ":" + userName).build();
    }
}
