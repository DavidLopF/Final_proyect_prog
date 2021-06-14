package resources;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.services.OwnerService;
import resources.Pojos.UserAppPOJO;
import resources.filters.Logged;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.logging.Logger;


@Path("/userApp/owners")
public class OwnersResource {


    @POST
    @Path("/{username}/{name}/{email}/{address}/{neighborhood}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("name") String name,
                           @PathParam("email") String email,
                           @PathParam("address") String address,
                           @PathParam("neighborhood") String neighborhood,
                           @PathParam("password") String password,
                           @PathParam("username") String username) {
        UserAppPOJO user = new UserAppPOJO(username, email, password, "Owner");
        OwnerService ownerService = new OwnerService();
        if (ownerService.createOwner(user, name, address, neighborhood)) {
            return Response.status(Response.Status.CREATED).build(); //201
        } else {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build(); //buscar el codigo
        }
    }


    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role, @HeaderParam("userName") String userName) {

        // If role doesn't match
        if (!"Owner".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return  Response.ok()
                .entity(role + ":" + userName).build();
    }


}




