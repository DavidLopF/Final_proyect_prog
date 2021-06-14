package resources;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.services.PetService;
import resources.Pojos.PetPOJO;
import resources.Pojos.PicturePojo;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.Data;
import java.util.Date;

@Path("/userApp/owners/pets")
public class PetResource {
    @POST
    @Path("/{microship}/{name}/{specie}/{race}/{size}/{sex}/{pictureName}/{ownerUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("name") String name,
                           @PathParam("microship") long microship,
                           @PathParam("specie") String specie,
                           @PathParam("race") String race,
                           @PathParam("size") String size,
                           @PathParam("sex") String sex,
                           @PathParam("pictureName") String pictureName,
                           @PathParam("ownerUser") String ownerUser) {
        Date date = new Date();
        String dataRegister = date.toString();
        String pDescription = "Pet name: " + name + "\nRegistred at " + date;
        PicturePojo picturePojo = new PicturePojo(pDescription, pictureName, dataRegister);
        PetService petService = new PetService();
        if (petService.createPet(picturePojo,name,microship,specie,race,size,sex,ownerUser)) {
            return Response.status(Response.Status.CREATED).build(); //201
        } else {
            return Response.status(400).build(); //buscar el codigo
        }

    }

}
