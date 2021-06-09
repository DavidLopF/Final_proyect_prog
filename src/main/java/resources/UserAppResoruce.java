package resources;

import co.edu.unbosque.Final_proyect_prog.services.UserAppService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/userApp")
public class UserAppResoruce {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void create(@FormParam("name") String name,
                       @FormParam("email") String email,
                       @FormParam("role") int role,
                       @FormParam("password") String password) {

        String[] roles ={"oficial","vet","owner"};
        UserAppService userAppService = new UserAppService();
        userAppService.createUser(name, password, roles[role], email);
    }
}
