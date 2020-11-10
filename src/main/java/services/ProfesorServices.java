package services;

import dto.Response;
import model.dto.ProfesorDTO;
import model.provider.ProfesorProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;

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
    @Produces("application/json")
    @Path("all")
    public ArrayList<ProfesorDTO> getAllProfesores(){
        ProfesorProvider provider = new ProfesorProvider();
        ArrayList<ProfesorDTO> profesores = provider.getAllProfesores();
        return profesores;
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

    @DELETE
    @Produces("application/json")
    @Path("delete/{id}")
    public dto.Response deleteProfesorById(@PathParam("id") String id){
        ProfesorProvider provider = new ProfesorProvider();
        boolean success = provider.deleteProfesor(id);
        if(success) return new Response("Operacion exitosa");
        else return new Response("Operacion fallida");
    }

}
