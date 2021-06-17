package resources;
import co.edu.unbosque.Final_proyect_prog.services.PetService;
import co.edu.unbosque.Final_proyect_prog.services.PictureService;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import resources.Pojos.PicturePojo;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Path("/userApp/owners/pets/pictures")
public class PictureResource {
    private final String UPLOAD_DIRECTORY = "/images/";
    private String path;
    private String fileNameFinal;

    @POST
    @Path("/upload/{microship}/{name}/{specie}/{race}/{size}/{sex}/{pictureName}/{ownerUser}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response uploadPicture(@Context ServletContext servletContext, MultipartFormDataInput input,
                                  @PathParam("name") String name,
                                  @PathParam("microship") long microship,
                                  @PathParam("specie") String specie,
                                  @PathParam("race") String race,
                                  @PathParam("size") String size,
                                  @PathParam("sex") String sex,
                                  @PathParam("pictureName") String pictureName,
                                  @PathParam("ownerUser") String username){

        String filename = "";
        Map<String, List<InputPart>> formParts = input.getFormDataMap();
        List<InputPart>inputParts = formParts.get("file");

        for(InputPart inputPart:inputParts){
            try{
                MultivaluedMap<String,String> headers =inputPart.getHeaders();
                filename = parseFileName(headers,username);

                InputStream stream = inputPart.getBody(InputStream.class,null);
                saveFile2(stream,filename,servletContext);
                saveFile(stream,filename,servletContext);


            } catch (IOException e) {
                e.printStackTrace();
                return Response.status(400).build();
            }
        }

        Date date = new Date();
        String dataRegister = date.toString();
        String pictureNameFinal = username+pictureName;
        String pDescription = "Pet name: " + name + "\nRegistred at " + date;
        PicturePojo picturePojo = new PicturePojo(pDescription, fileNameFinal, dataRegister);
        PetService petService = new PetService();
        if (petService.createPet(picturePojo,name,microship,specie,race,size,sex,username)) {
            return Response.status(Response.Status.CREATED).build(); //201
        } else {
            return Response.status(400).build(); //buscar el codigo
        }

       // return Response.status(201).build();
    }

    private String parseFileName(MultivaluedMap<String,String> headers, String username){
        String[] contentHeaders = headers.getFirst("Content-Disposition").split(";");
        for(String s: contentHeaders){
            System.out.println(s);
        }
        for(String name: contentHeaders){
            if((name.trim().startsWith("filename"))){
                String temp[] = name.split("=");
                String filename = (username+temp[1].trim()).replaceAll("\"","" );
                return filename;
            }
        }
        return "notFound";
    }

    private void saveFile(InputStream uploadInputStream, String filename, ServletContext servletContext){
        int read = 0;
        byte[] bytes = new byte[1024];

        try{
            String uploadPath = servletContext.getRealPath("");
                uploadPath = uploadPath.substring(0,uploadPath.length()-38)+"src/main/webapp/Js/images";
                path = uploadPath+File.separator+filename;
                fileNameFinal = filename;


            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()) uploadDir.mkdir();

            OutputStream outputStream = new FileOutputStream(uploadPath+File.separator+filename);
            while((read = uploadInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,read);

            }

            outputStream.flush();
            outputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile2(InputStream uploadInputStream, String filename, ServletContext servletContext){
        int read = 0;
        byte[] bytes = new byte[1024];
        try{
            String uploadPath = servletContext.getRealPath("") + UPLOAD_DIRECTORY;
            System.out.println("EL path es "+(uploadPath+filename));
            path = uploadPath+filename;
            fileNameFinal = filename;
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()) uploadDir.mkdir();

            OutputStream outputStream = new FileOutputStream(uploadPath+filename);
            while((read = uploadInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,read);
            }
            outputStream.flush();
            outputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
