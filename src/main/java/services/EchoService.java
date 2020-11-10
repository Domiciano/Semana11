package services;

import db.MySQLConnection;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
    @Path("filetest")
    public String indexPost(@HeaderParam("Content-Type") String content, @HeaderParam("Authorization") String auth, String request){
        String alfa = "";
        alfa+="<p>"+content+"</p>";
        alfa+="<p>"+auth+"</p>";
        alfa+="<p>"+request+"</p>";
        return alfa;
    }

}
