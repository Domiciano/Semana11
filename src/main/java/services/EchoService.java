package services;

import db.MySQLConnection;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("echo")
public class EchoService {

    @GET
    @Path("index")
    public String index(){
        return "echo get";
    }

    @POST
    @Path("index")
    public String indexPost(){
        return "echo post";
    }

}
