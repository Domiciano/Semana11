package services;

import dto.Response;
import model.dto.ProfesorDTO;
import model.provider.ProfesorProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;

@Path("profesores")
@Stateless
public class ProfesorServices {

    @POST
    @Consumes("application/json")
    @Path("create")
    public dto.Response createProfesor(ProfesorDTO profesorDTO){
        ProfesorProvider profesorProvider = new ProfesorProvider();
        profesorProvider.insertProfesor( profesorProvider.mapFromDTO(profesorDTO) );
        return new Response("Operación exitosa");
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("{id}")
    public ProfesorDTO getProfesor(@PathParam("id") String id){
        ProfesorProvider provider = new ProfesorProvider();
        ProfesorDTO profesorDTO = provider.getCompleteProfesorById(Integer.parseInt(id));
        return profesorDTO;
    }

}
