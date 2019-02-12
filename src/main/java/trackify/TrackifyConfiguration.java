package trackify;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TrackifyConfiguration extends Configuration {
private static final String CONFIG = "config";

@Valid
@NotNull
private DataSourceFactory dataSourceFactory = new DataSourceFactory();

@JsonProperty(CONFIG)
public DataSourceFactory getDataSourceFactory(){
        return dataSourceFactory;
        }

@JsonProperty(CONFIG)
public void setDataSourceFactory(DataSourceFactory dataSourceFactory){
        this.dataSourceFactory = dataSourceFactory;
        }
        }