package services;

import access.cAdUser;
import classes.cUser;
import java.util.*;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("user")
public class restUser {

    public static class Model {

        public String message;
        public String type;
        public String date;
        public Integer userId;
    }
    cUser objUser = new cUser();
    cAdUser objFuntionUser = new cAdUser();

    @Context
    private UriInfo context;

    public restUser() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hola";
    }

    @POST
    @Path("managementUser")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementUser(@FormDataParam("userMType") Integer userMType, //recivimos los datos desde la ventana modal del cliente
            @FormDataParam("userName") String userName, 
            @FormDataParam("userCI") String userCI, 
            @FormDataParam("userNameUser") String userNameUser, 
            @FormDataParam("userPass") String userPass, 
            @FormDataParam("userRol") Integer userRol,
            @FormDataParam("userId") Integer userId) {
        Model model = new Model();
        try {
            objUser.setUserMType(userMType);
            objUser.setUserName(userName);
            objUser.setUserCI(userCI);
            objUser.setUserNameUser(userNameUser);
            objUser.setUserPass(userPass);
            objUser.setUserRol(userRol);
            objUser.setUserId(userId);

            String rs = objFuntionUser.managementUser(objUser);
            String message = "Sin Respuesta";
            model.message = message;
            model.date = new Date().toString();
            if (rs.equals("Successful")) {
                message = "Exito";
                model.message = message;
                model.date = new Date().toString();
            }
            if (rs.equals("There isn't connection with DB")) {
                message = "Problemas con la conexion";
                model.message = message;
                model.date = new Date().toString();
            }
            if (rs.equals("Error!! Add User")) {
                message = "Error";
                model.message = message;
                model.date = new Date().toString();
            }

        } catch (Exception e) {
            String message = "error";
            model.message = message;
            model.date = new Date().toString();
        }
        return model;
    }

    @GET
    @Path("/listUser")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cUser> listUser() {
        List<cUser> result = new ArrayList<cUser>();
        result = objFuntionUser.listUser();
        return result;
    }

//    @PUT
//    @Path("/deleteUser/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Model deleteUser(@PathParam("id") Integer id) {
//
//        Model model = new Model();
//        try {
//            objUser.setId(id);
//
//            String rs = objFuntionUser.deleteUser(objUser);
//            String message = "Sin Respuesta";
//            model.message = message;
//            model.date = new Date().toString();
//
//            if (rs.equals("Successful")) {
//                message = "Exito";
//                model.message = message;
//                model.date = new Date().toString();
//            }
//            if (rs.equals("There isn't connection with DB")) {
//                message = "Problemas con la conexion";
//                model.message = message;
//                model.date = new Date().toString();
//            }
//            if (rs.equals("The user already is registered")) {
//                message = "El usuario no puede ser eliminado, actualmente esta asignado a una unidad";
//                model.message = message;
//                model.date = new Date().toString();
//            }
//            if (rs.equals("Error!! Add User")) {
//                message = "Error";
//                model.message = message;
//                model.date = new Date().toString();
//            }
//
//        } catch (Exception e) {
//            String message = "error";
//            model.message = message;
//            model.date = new Date().toString();
//        }
//        return model;
//    }

//    @PUT
//    @Path("/updateUser")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Model updateUser(@FormDataParam("id") Integer id, @FormDataParam("name") String name, @FormDataParam("identityCard") String identityCard,
//            @FormDataParam("passport") String passport, @FormDataParam("type") Integer type, @FormDataParam("fileName") String fileName, @FormDataParam("email") String email,
//            @FormDataParam("password") String password,
//            @FormDataParam("file") InputStream in, @FormDataParam("file") FormDataContentDisposition info) {
//
//        Model model = new Model();
//        try {
//            Boolean rs = false;
//            if (info.getFileName() == null) {
//                objUser.setId(id);
//                objUser.setName(name);
//                objUser.setIdentityCard(identityCard);
//                objUser.setPassword(password);
//                objUser.setPassport(passport);
//                objUser.setEmail(email);
//                objUser.setPhoto(fileName);
//                objUser.setType(type);
//                rs = objFuntionUser.updateUser(objUser);
//            } else {
//                objUser.setId(id);
//                objUser.setName(name);
//                objUser.setIdentityCard(identityCard);
//                objUser.setPassword(password);
//                objUser.setPassport(passport);
//                objUser.setEmail(email);
//                objUser.setType(type);
//                objUser.setPhoto(info.getFileName());
//
//                String path = Configuration.path_user;
//                File upload = new File(info.getFileName());
//
//                File uploads = new File(path);
//                uploads.mkdirs();
//
//                File file = new File(uploads, info.getFileName());
//                Files.copy(in, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
//                rs = objFuntionUser.updateUser(objUser);
//            }
//
//            String message = "Sin conexión";
//            model.message = message;
//            model.date = new Date().toString();
//
//            if (rs == true) {
//                message = "Exito";
//                model.message = message;
//                model.date = new Date().toString();
//            }
//        } catch (Exception e) {
//            String message = "error";
//            model.message = message;
//            model.date = new Date().toString();
//        }
//        return model;
//    }

}
