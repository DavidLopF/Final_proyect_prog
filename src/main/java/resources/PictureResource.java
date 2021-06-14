package resources;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.List;
import java.util.Map;

@Path("/userApp/owners/pets/pictures")
public class PictureResource {
    private final String UPLOAD_DIRECTORY = "/images/";

    @POST
    @Path("/upload/{username}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadPicture(@Context ServletContext servletContext, MultipartFormDataInput input,
                                  @PathParam("username") String username){

        String filename = "";
        Map<String, List<InputPart>> formParts = input.getFormDataMap();
        List<InputPart>inputParts = formParts.get("file");

        for(InputPart inputPart:inputParts){
            try{
                MultivaluedMap<String,String> headers =inputPart.getHeaders();
                filename = parseFileName(headers,username);

                InputStream stream = inputPart.getBody(InputStream.class,null);

                saveFile(stream,filename,servletContext);

            } catch (IOException e) {
                e.printStackTrace();
                return Response.status(400).build();
            }
        }
        String out = "file saved at "+filename;
        return Response.status(201).build();
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
            String uploadPath = servletContext.getRealPath("") + UPLOAD_DIRECTORY;

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
