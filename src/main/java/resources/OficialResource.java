package resources;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.services.OficialService;
import co.edu.unbosque.Final_proyect_prog.services.OwnerService;
import resources.Pojos.OwnerPOJO;
import resources.Pojos.UserAppPOJO;
import resources.filters.Logged;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/userApp/oficial")
public class OficialResource {

    @POST
    @Path("/{userName}/{password}/{email}/{name}")
    public Response create(@PathParam("userName") String userName,
                           @PathParam("password") String password,
                           @PathParam("email") String email,
                           @PathParam("name") String name) {

        UserAppPOJO user = new UserAppPOJO(userName, email, password, "oficial");
        OficialService oficialService = new OficialService();

        if (oficialService.createOficial(user, name)) {

            return Response.status(Response.Status.CREATED).build(); //201
        } else {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build(); //buscar el codigo
        }
    }

    @GET
    @Path("/{neight}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listOwnerByNeight(@PathParam("neight") String neight){
        OwnerService ownerService = new OwnerService();
        if(ownerService.listByNeigth(neight)==null){
            return Response.ok().entity(null).build();
        }else{
            List<OwnerPOJO> owners = ownerService.listByNeigth(neight);

            return Response.ok().entity(owners).build();
        }

    }

    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role, @HeaderParam("userName") String userName) {

        // If role doesn't match

        if (!"oficial".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();
        
        return Response.ok()
                .entity(role + ":" + userName).build();

    }



}
