package trackify.db;

import org.hibernate.SessionFactory;
import trackify.core.Album;
import io.dropwizard.hibernate.AbstractDAO;

public class AlbumDAO extends AbstractDAO<Album> {
    public AlbumDAO(SessionFactory sessionFactory){
        super(sessionFactory);
    }

}
