package noel.example.com.covid19;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> implements Filterable {

    Context context;
    List<CovidModel> countrylist;
    List<CovidModel> filteredcovidList;
    private CovidAdapterListener listener;

    public CountryAdapter(Context context, List countrylist, CovidAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.countrylist = countrylist;
        this.filteredcovidList = countrylist;

    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view1 = inflater.inflate(R.layout.list_country_name,null);
        return new CountryViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        CovidModel covid = filteredcovidList.get(position);
        holder.cName.setText(covid.getCountry());


        Glide.with(context)
                .load(covid.getFlag())
                .into(holder.cImage);
    }
    @Override
    public int getItemCount() {
        return filteredcovidList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredcovidList = countrylist;

                } else {
                    List filteredList = new ArrayList<>();
                    for (CovidModel row : countrylist) {


                        if (row.getCountry().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    filteredcovidList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredcovidList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredcovidList = (ArrayList) filterResults.values;
                notifyDataSetChanged();

            }
        };

    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView cName;
        ImageView cImage;


        public CountryViewHolder(final View itemView) {
            super(itemView);
            cName = itemView.findViewById(R.id.tvCountryName);
            cImage = itemView.findViewById(R.id.imageFlag);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onCountrySelected(filteredcovidList.get(getAdapterPosition()));
                    Intent intent = new Intent(context,CovidDetailActivity.class);
                    intent.putExtra("country",filteredcovidList.get(getAdapterPosition()).getCountry());
                    intent.putExtra("cases",filteredcovidList.get(getAdapterPosition()).getCases());
                    intent.putExtra("todaycases",filteredcovidList.get(getAdapterPosition()).getTodayCases());
                    intent.putExtra("totaldeaths",filteredcovidList.get(getAdapterPosition()).getDeaths());
                    intent.putExtra("todaydeath",filteredcovidList.get(getAdapterPosition()).getTodayDeaths());
                    intent.putExtra("recovered",filteredcovidList.get(getAdapterPosition()).getRecovered());
                    intent.putExtra("activecases",filteredcovidList.get(getAdapterPosition()).getActive());
                    intent.putExtra("criticalcases",filteredcovidList.get(getAdapterPosition()).getCritical());

                    intent.putExtra("Casesperonemillion",filteredcovidList.get(getAdapterPosition()).getCasesperonemillion());
                    intent.putExtra("Deathsperonemillion",filteredcovidList.get(getAdapterPosition()).getDeathsperonemillion());
                    intent.putExtra("tests",filteredcovidList.get(getAdapterPosition()).getTests());
                    intent.putExtra("Testsperonemillion",filteredcovidList.get(getAdapterPosition()).getTestsperonemillion());
                    intent.putExtra("population",filteredcovidList.get(getAdapterPosition()).getPopulation());
                    intent.putExtra("Onecaseperpeople",filteredcovidList.get(getAdapterPosition()).getOnecaseperpeople());
                    intent.putExtra("Onedeathperpeople",filteredcovidList.get(getAdapterPosition()).getOnedeathperpeople());
                    intent.putExtra("Onetestperpeople",filteredcovidList.get(getAdapterPosition()).getOnetestperpeople());
                    intent.putExtra("Activepermillion",filteredcovidList.get(getAdapterPosition()).getActivepermillion());
                    intent.putExtra("Recoveredpermillion",filteredcovidList.get(getAdapterPosition()).getRecoveredpermillion());
                    intent.putExtra("Criticalpermillion",filteredcovidList.get(getAdapterPosition()).getCriticalpermillion());






















                    itemView.getContext().startActivity(intent);
                }
            });


        }
    }

    public interface CovidAdapterListener {
        void onCountrySelected(CovidModel countries);

    }
}
