package trackify.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import trackify.core.Album;

import java.util.List;

public class AlbumDAO extends AbstractDAO<Album> {

    public AlbumDAO(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public List<Album> findByUserId(int userId){
        return list(namedQuery("Album.findByUserId")
                    .setParameter("userId", userId));
    }
}

