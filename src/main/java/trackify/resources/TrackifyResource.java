package trackify.resources;

import trackify.core.Album;
import trackify.db.AlbumDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/trackify")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TrackifyResource {
    private final AlbumDAO albumDAO;

    public TrackifyResource(AlbumDAO albumDAO){
        this.albumDAO = albumDAO;
    }

    @GET
    @Path("/history/{id}")
    public List<Album> getHistory(@PathParam("id") int id){
        List<Album> albums = getExistingHistory(id);
        if(albums.isEmpty()){
            //hit spotify api
        }
        return albums;
    }

    public List<Album> getExistingHistory(int id){

        List<Album> albums =  albumDAO.findByUserId(id);


        //check info table if user already has one
        //else must his spotify api

        return albums;
    }
}
