package noel.example.com.covid19;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidInterface {

    String JSONURL = "https://corona.lmao.ninja/v2/";
    @GET("all")
    Call<String> getCovidList();
}
