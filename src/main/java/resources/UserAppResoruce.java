package resources;

import co.edu.unbosque.Final_proyect_prog.services.UserAppService;
import org.postgresql.util.ReaderInputStream;
import resources.Pojos.UserAppPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/userApp")
public class UserAppResoruce {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void create(@FormParam("name") String name,
                       @FormParam("email") String email,
                       @FormParam("role") String role,
                       @FormParam("password") String password) {
        UserAppPOJO userAppPOJO = new UserAppPOJO(name, email, password, role);
        UserAppService userAppService = new UserAppService();
        userAppService.createUser(name, password, role, email);
    }
}
