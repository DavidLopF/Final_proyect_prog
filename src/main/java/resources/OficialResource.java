package resources;

import co.edu.unbosque.Final_proyect_prog.services.OficialService;
import resources.Pojos.UserAppPOJO;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/userApp/oficial")
public class OficialResource {

    @POST
    @Path("{userName}/{password}/{email}/{role}/{name}")
    public Response create(@PathParam("userName") String userName,
                           @PathParam("email") String email,
                           @PathParam("password") String password,
                           @PathParam("role") String role,
                           @PathParam("name") String name) {

        UserAppPOJO user = new UserAppPOJO(userName, email, password, role);
        OficialService oficialService = new OficialService();

        if (oficialService.createOficial(user, name)) {

            return Response.status(Response.Status.CREATED).build(); //201
        } else {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build(); //buscar el codigo  
        }
    }
}
