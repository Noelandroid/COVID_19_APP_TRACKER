package noel.example.com.covid19;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.katso.livebutton.LiveButton;

import android.content.Intent;
import android.graphics.Color;
import android.net.DnsResolver;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.leo.simplearcloader.SimpleArcLoader;

import net.bohush.geometricprogressview.GeometricProgressView;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths,tvAffectedCountries;
    ScrollView scrollView;
    private GeometricProgressView progressView;
    BarChart barChart;
    LiveButton btnTrack;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvAffectedCountries = findViewById(R.id.tvAffectedCountries);

        progressView = findViewById(R.id.progressView);
        scrollView = findViewById(R.id.scrollStats);
        barChart = findViewById(R.id.barchart);
        btnTrack=findViewById(R.id.btntrack);

        btnTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CovidCountries.class);
                startActivity(intent);
            }
        });

        retrieveData();




    }


    private void retrieveData() {
        progressView.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CovidInterface.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        CovidInterface api = retrofit.create(CovidInterface.class);

        Call<String> call = api.getCovidList();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        covid(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                //progressView.stop();
                progressView.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Something went Wrong!", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void covid(String jsonresponse) {

        try {
            JSONObject jsonObject = new JSONObject(jsonresponse.toString());

            tvCases.setText(jsonObject.getString("cases"));
            tvRecovered.setText(jsonObject.getString("recovered"));
            tvCritical.setText(jsonObject.getString("critical"));
            tvActive.setText(jsonObject.getString("active"));
            tvTodayCases.setText(jsonObject.getString("todayCases"));
            tvTotalDeaths.setText(jsonObject.getString("deaths"));
            tvTodayDeaths.setText(jsonObject.getString("todayDeaths"));
            tvAffectedCountries.setText(jsonObject.getString("affectedCountries"));


            barChart.addBar(new BarModel("Cases",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFFF00")));
            barChart.addBar(new BarModel("Recoverd",Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#00FF00")));
            barChart.addBar(new BarModel("Deaths",Integer.parseInt(tvTotalDeaths.getText().toString()), Color.parseColor("#DC143C")));
            barChart.addBar(new BarModel("Active",Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#FF4500")));
            barChart.startAnimation();


            progressView.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);




        } catch (JSONException e) {
            e.printStackTrace();
            progressView.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }

    }

}
