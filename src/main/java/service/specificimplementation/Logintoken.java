package service.specificimplementation;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import dao.specificimplementation.UsuarioSpecificDaoImplementation;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.POST;

@Path("auth")
public class Logintoken {
// login jwt
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validacion(UsuarioSpecificBeanImplementation oUsuarioBean) {

        boolean status = UsuarioSpecificDaoImplementation.validacion(oUsuarioBean.getNombre(), oUsuarioBean.getPassword());
        if (status) {
            String clave = oUsuarioBean.getPassword();
            long tiempo = System.currentTimeMillis();
            String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, clave)
                                      .setSubject(oUsuarioBean.getNombre())
                                      .setIssuedAt(new Date(tiempo) )
                                      .setExpiration(new Date(tiempo+900000))
                                      .claim("email", oUsuarioBean.getEmail())
                                      .compact();
            JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
            
            return Response.status(Response.Status.CREATED).entity(json).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

}
