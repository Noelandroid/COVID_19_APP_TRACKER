package noel.example.com.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CovidDetailActivity extends AppCompatActivity {


    TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths,tvcasesperonemillion,
            tvdeathsperonemillion,tvpopulation,tvtests,tvtestsperonemillion,tvonecaseperpeople,tvonedeathperpeople,tvonetestperpeople,
            tvactivepermillion,tvrecoveredpermillion,tvcriticalpermillion;


    private String tdeaths;
    private String tcountry;
    private String tcases;
    private String trecovered;
    private String tcritical;
    private String tactive;
    private String ttodaycases;
    private String ttotaldeaths;

    private String tcasesperonemillion;
    private String tdeathsperonemillion;
    private String tpopulation;
    private String ttests;
    private String ttestsperonemillion;
    private String tonecaseperpeople;
    private String tonedeathperpeople;
    private String tonetestperpeople;

    private String tactivepermillion;
    private String trecoveredpermillion;
    private String tcriticalpermillion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_detail);

        Intent i = getIntent();




        tcasesperonemillion=i.getStringExtra("Casesperonemillion");
        tvcasesperonemillion=findViewById(R.id.tvCasesperonemillion);
        tvcasesperonemillion.setText(String.valueOf(tcasesperonemillion));

        tdeathsperonemillion=i.getStringExtra("Deathsperonemillion");
        tvdeathsperonemillion=findViewById(R.id.tvDeathsperonemillion);
        tvdeathsperonemillion.setText(String.valueOf(tdeathsperonemillion));

        tpopulation=i.getStringExtra("population");
        tvpopulation=findViewById(R.id.tvpopulation);
        tvpopulation.setText(String.valueOf(tpopulation));

        ttests=i.getStringExtra("tests");
        tvtests=findViewById(R.id.tvTests);
        tvtests.setText(String.valueOf(ttests));

        ttestsperonemillion=i.getStringExtra("Testsperonemillion");
        tvtestsperonemillion=findViewById(R.id.tvTestsperonemillion);
        tvtestsperonemillion.setText(String.valueOf(ttestsperonemillion));

        tonecaseperpeople=i.getStringExtra("Onecaseperpeople");
        tvonecaseperpeople=findViewById(R.id.tvonecaseperpeople);
        tvonecaseperpeople.setText(String.valueOf(tonecaseperpeople));

        tonedeathperpeople=i.getStringExtra("Onedeathperpeople");
        tvonedeathperpeople=findViewById(R.id.tvonedeathperpeople);
        tvonedeathperpeople.setText(String.valueOf(tonedeathperpeople));

        tonetestperpeople=i.getStringExtra("Onetestperpeople");
        tvonetestperpeople=findViewById(R.id.tvonetestperpeople);
        tvonetestperpeople.setText(String.valueOf(tonetestperpeople));

        tactivepermillion=i.getStringExtra("Activepermillion");
        tvactivepermillion=findViewById(R.id.tvactivepermillion);
        tvactivepermillion.setText(String.valueOf(tactivepermillion));

        trecoveredpermillion=i.getStringExtra("Recoveredpermillion");
        tvrecoveredpermillion=findViewById(R.id.tvrecoveredpermillion);
        tvrecoveredpermillion.setText(String.valueOf(trecoveredpermillion));

        tcriticalpermillion=i.getStringExtra("Criticalpermillion");
        tvcriticalpermillion=findViewById(R.id.tvcriticalpermillion);
        tvcriticalpermillion.setText(String.valueOf(tcriticalpermillion));







        tcountry=i.getStringExtra("country");
        tvCountry = findViewById(R.id.tvCountry);
        tvCountry.setText(String.valueOf(tcountry));

        tcases=i.getStringExtra("cases");
        tvCases = findViewById(R.id.tvCases);
        tvCases.setText(String.valueOf(tcases));

        trecovered=i.getStringExtra("recovered");
        tvRecovered = findViewById(R.id.tvRecovered);
        tvRecovered.setText(String.valueOf(trecovered));

        tcritical=i.getStringExtra("criticalcases");
        tvCritical = findViewById(R.id.tvCritical);
        tvCritical.setText(String.valueOf(tcritical));

        tactive=i.getStringExtra("activecases");
        tvActive = findViewById(R.id.tvActive);
        tvActive.setText(String.valueOf(tactive));

        ttodaycases=i.getStringExtra("todaycases");
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTodayCases.setText(String.valueOf(ttodaycases));


        ttotaldeaths=i.getStringExtra("totaldeaths");
        tvTotalDeaths = findViewById(R.id.tvDeaths);
        tvTotalDeaths.setText(String.valueOf(ttotaldeaths));


        tdeaths=i.getStringExtra("todaydeath");
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvTodayDeaths.setText(String.valueOf(tdeaths));














    }
}
