package noel.example.com.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CovidCountries extends AppCompatActivity implements CountryAdapter.CovidAdapterListener {
    RecyclerView recyclerView;
    List countrylist;
    SimpleArcLoader simpleArcLoader;
    CountryAdapter adapter;
    SearchView searchView;
    CovidModel countryModel;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_countries);


        recyclerView = findViewById(R.id.recycle);
        simpleArcLoader = findViewById(R.id.loader);

        getSupportActionBar().setTitle("Affected Countries");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        countrylist=new ArrayList<>();


        adapter = new CountryAdapter(this,countrylist, this);

        retrieveData();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);


        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }
    @Override
    public void onBackPressed() {

        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    private void retrieveData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CountryInterface.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        CountryInterface api = retrofit.create(CountryInterface.class);

        Call<String> call = api.getCountryList();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();


                        country(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);

                Toast.makeText(CovidCountries.this, "Something went Wrong!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void country(String jsonresponse) {

        countrylist.clear();

        try {
            JSONArray jsonArray = new JSONArray(jsonresponse);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String countryName = jsonObject.getString("country");
                String cases = jsonObject.getString("cases");
                String todayCases = jsonObject.getString("todayCases");
                String deaths = jsonObject.getString("deaths");
                String todayDeaths = jsonObject.getString("todayDeaths");
                String recovered = jsonObject.getString("recovered");
                String active = jsonObject.getString("active");
                String critical = jsonObject.getString("critical");

                String casesPerOneMillion = jsonObject.getString("casesPerOneMillion");
                String deathsPerOneMillion = jsonObject.getString("deathsPerOneMillion");
                String testsPerOneMillion = jsonObject.getString("testsPerOneMillion");
                String tests = jsonObject.getString("tests");
                String population = jsonObject.getString("population");
                String oneCasePerPeople = jsonObject.getString("oneCasePerPeople");
                String oneDeathPerPeople = jsonObject.getString("oneDeathPerPeople");
                String oneTestPerPeople = jsonObject.getString("oneTestPerPeople");
                String activePerOneMillion = jsonObject.getString("activePerOneMillion");
                String recoveredPerOneMillion = jsonObject.getString("recoveredPerOneMillion");
                String criticalPerOneMillion = jsonObject.getString("criticalPerOneMillion");


                JSONObject object = jsonObject.getJSONObject("countryInfo");
                String flagUrl = object.getString("flag");

                countryModel = new CovidModel(flagUrl,countryName,cases,todayCases,deaths,todayDeaths,recovered,active,critical,casesPerOneMillion,
                        deathsPerOneMillion,testsPerOneMillion,tests, population,oneCasePerPeople,oneDeathPerPeople,
                        oneTestPerPeople,activePerOneMillion,recoveredPerOneMillion,criticalPerOneMillion);
                countrylist.add(countryModel);


            }




            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
            simpleArcLoader.stop();
            simpleArcLoader.setVisibility(View.GONE);






        } catch (JSONException e) {
            e.printStackTrace();
            simpleArcLoader.stop();
            simpleArcLoader.setVisibility(View.GONE);
        }
    }


    @Override
    public void onCountrySelected(CovidModel countries) {
        Toast.makeText(this, "Selected:  "+countries.getCountry(), Toast.LENGTH_SHORT).show();

    }
}
