package trackify.http;

import com.sun.deploy.net.HttpRequest;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class SpotifyCommunicator {
    private static final String AUTH_URL = "https://accounts.spotify.com/authorize";
    private static final String CLIENT_ID = "ce19b48b911b4922bde3bfcb431941bd";
    private static final String RESPONSE_TYPE = "code";
    private static final String REDIRECT_URI = "https://www.google.com";

    private OkHttpClient okHttpClient;


    public SpotifyCommunicator(){
        this.okHttpClient = new OkHttpClient();
    }

    public void authorize() throws IOException{
        HttpUrl.Builder urlBuilder = HttpUrl.parse(AUTH_URL).newBuilder();

        urlBuilder.addQueryParameter("client_id", CLIENT_ID);
        urlBuilder.addQueryParameter("response_type", RESPONSE_TYPE);
        urlBuilder.addQueryParameter("redirect_uri",REDIRECT_URI);

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = okHttpClient.newCall(request).execute();
        }
        catch(IOException e){
            throw e;
        }
        
    }
}
