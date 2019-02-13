package trackify;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import trackify.core.Album;
import trackify.db.AlbumDAO;
import trackify.resources.TrackifyResource;

public class TrackifyApplication extends Application<TrackifyConfiguration> {

    private final HibernateBundle<TrackifyConfiguration> hibernateBundle
            = new HibernateBundle<TrackifyConfiguration>(Album.class)
                {
                @Override
                public DataSourceFactory getDataSourceFactory(
                        TrackifyConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
    };


    public static void main(String[] args) throws Exception {
        new TrackifyApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<TrackifyConfiguration> bootstrap){
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(TrackifyConfiguration configuration, Environment environment) {
        final AlbumDAO albumDAO = new AlbumDAO(hibernateBundle.getSessionFactory());

        environment.jersey().register(new TrackifyResource(albumDAO));
    }
}