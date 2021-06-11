package resources;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.services.OwnerService;
import co.edu.unbosque.Final_proyect_prog.services.UserAppService;

import javax.jms.Session;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;

@Path("/owners")
public class OwnersResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@FormParam("username")String username,
                           @FormParam("password")String password,
                           @FormParam("email") String email,
                           @FormParam("name") String name,
                           @FormParam("address") String address,
                           @FormParam("neight") String neigth){


        OwnerService ownerService = new OwnerService();
        Owner aux = new Owner(username,name,neigth,address);
        ownerService.createOwner(username,name,neigth,address,password,email);
        NewCookie cookie = new NewCookie("username",name);

        return Response.ok("OK").cookie(cookie).build();
    }

}
