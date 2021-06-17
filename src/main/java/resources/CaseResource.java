package resources;

import co.edu.unbosque.Final_proyect_prog.entities.PetCase;
import co.edu.unbosque.Final_proyect_prog.services.CaseService;
import resources.Pojos.CasePOJO;
import resources.Pojos.PetCasePOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/userApp/owners/pets/cases")
public class CaseResource {
    @POST
    @Path("/{type}/{description}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response created(@PathParam("type") String type,
                            @PathParam("description") String description,
                            @PathParam("id") Integer id){
        Date data= new Date();
        CasePOJO casePOJO = new CasePOJO(data.toString(), type,description,id);
        CaseService caseService = new CaseService();
        if(caseService.create(casePOJO)){
            return Response.status(Response.Status.CREATED).build(); //201
        }else{
            return Response.status(Response.Status.NOT_ACCEPTABLE).build(); //buscar el codigo
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response listCases(){
        CaseService caseService = new CaseService();
        List<PetCase> petCases = caseService.listCases();
        if(petCases==null){
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(null).build();
        }else{
            List<PetCasePOJO> pojos = new ArrayList<>();
            for(PetCase p: petCases){
                pojos.add(new PetCasePOJO(p.getCreated_at(),p.getType(),p.getDescription(),p.getCase_id()));
            }
            return Response.ok().entity(pojos).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list/{param}")
    public Response listCasesByParam(@PathParam("param")String param){
        CaseService caseService = new CaseService();
        List<PetCasePOJO> pojos = caseService.listCasesByParam(param);
        if(pojos==null){
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(null).build();
        }else{
            return Response.ok().entity(pojos).build();
        }
    }
}
