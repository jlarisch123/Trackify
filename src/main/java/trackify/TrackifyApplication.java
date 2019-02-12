package trackify;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;

public class TrackifyApplication extends Application<TrackifyConfiguration> {
    private static final String SQL = "sql";

    public static void main(String[] args) throws Exception {
        new TrackifyApplication().run(args);
    }

    @Override
    public void run(TrackifyConfiguration configuration, Environment environment) {
        // Datasource configuration
        final DataSource dataSource =
                configuration.getDataSourceFactory().build(environment.metrics(), SQL);
        DBI dbi = new DBI(dataSource);

    }
}