package resources;

import resources.Pojos.OwnerPOJO;
import co.edu.unbosque.Final_proyect_prog.services.UserAppService;
import resources.Pojos.UserAppPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/userApp")
public class UserAppResoruce {


    @POST
    @Path("{userName}/{password}/{email}/{role}/{name}/{address}/{neighboorhod}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOwner(@PathParam("userName") String userName,
                                @PathParam("password") String password,
                                @PathParam("email") String email,
                                @PathParam("role") String role,
                                @PathParam("name") String name,
                                @PathParam("address") String address,
                                @PathParam("neighboorhod") String barrio) {

        OwnerPOJO ownerPOJO = new OwnerPOJO(name, 200, address, barrio);
        return Response.status(Response.Status.CREATED).entity(ownerPOJO).build();
    }


}
