package resources;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.Pet;
import co.edu.unbosque.Final_proyect_prog.services.PetService;
import resources.Pojos.PetPOJO;
import resources.Pojos.PicturePojo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        String pictureNameFinal = ownerUser + pictureName;
        String pDescription = "Pet name: " + name + "\nRegistred at " + date;
        PicturePojo picturePojo = new PicturePojo(pDescription, pictureNameFinal, dataRegister);
        PetService petService = new PetService();
        if (petService.createPet(picturePojo, name, microship, specie, race, size, sex, ownerUser)) {
            return Response.status(Response.Status.CREATED).build(); //201
        } else {
            return Response.status(400).build(); //buscar el codigo
        }

    }

    @PUT
    @Path("/{microship}/{name}/{specie}/{race}/{size}/{sex}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("name") String name,
                           @PathParam("microship") long microship,
                           @PathParam("specie") String specie,
                           @PathParam("race") String race,
                           @PathParam("size") String size,
                           @PathParam("sex") String sex,
                           @PathParam("id")Integer id){
        PetService petService = new PetService();
        if(petService.modify(name,microship,size,specie,race,sex,id)){
            return Response.status(Response.Status.ACCEPTED).build();
        }else{
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Response listAllPetsByUsername(@PathParam("username") String username){
        PetService petService = new PetService();
        List<PetPOJO> pets = petService.listPetsByUsername(username);

        return Response.ok().entity(pets).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{param}/{value}")
    public Response listPetsByParameter(@PathParam("param") String param,
                                        @PathParam("value") String value){
        System.out.println("Entra al metodo");
        PetService petService = new PetService();
        if(petService.listPetsByParameter(param,value)==null){
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(null).build();
        }else{
            List<PetPOJO> pojos = petService.listPetsByParameter(param,value);
            return Response.status(201).entity(pojos).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{param}")
    public Response getByParameter(@PathParam("param") String param){
        return null;
    }

 

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response listAllPets(){
        PetService petService = new PetService();
        List<PetPOJO> pets = petService.listAllPets();
        return Response.ok().entity(pets).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/filter/{param}")
    public Response filterByParam(@PathParam("param")String param){
        PetService petService = new PetService();
        List<PetPOJO> pets = petService.filterByParam(param);
        return Response.ok().entity(pets).build();
    }




}
