package resources;

import co.edu.unbosque.Final_proyect_prog.services.UserAppService;

import javax.servlet.http.Cookie;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/userApp")
public class UserAppResoruce {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@FormParam("name") String name,
                           @FormParam("email") String email,
                           @FormParam("role") int role,
                           @FormParam("password") String password) {

        String[] roles ={"oficial","vet","owner"};
        UserAppService userAppService = new UserAppService();
        userAppService.createUser(name, password, roles[role], email);
        NewCookie cookie = new NewCookie("username",name);
        return Response.ok("OK").cookie(cookie).build();
    }
}
