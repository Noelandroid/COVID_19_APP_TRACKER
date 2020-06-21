package noel.example.com.covid19;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryInterface {
    String JSONURL = "https://corona.lmao.ninja/v2/";
    @GET("countries")
    Call<String> getCountryList();
}
