package trackify;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TrackifyConfiguration extends Configuration {
        private static final String DB = "database";

        @Valid
        @NotNull
        private DataSourceFactory dataSourceFactory = new DataSourceFactory();

        @JsonProperty(DB)
        public DataSourceFactory getDataSourceFactory() {
                return dataSourceFactory;
        }
}
