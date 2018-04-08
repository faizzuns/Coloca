package coloca.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import coloca.user.adapters.DetailDestinationAdapter;
import coloca.user.listeners.Destination;
import coloca.user.models.destination.DestinationModel;
import coloca.user.models.destination.DestinationResult;
import coloca.user.models.destination.Review;
import coloca.user.models.tweet.TweetResult;
import coloca.user.services.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailDestinationActivity extends AppCompatActivity {

    @BindView(R.id.img_destination) ImageView imgDestination;
    @BindView(R.id.txt_destination) TextView txtDestination;
    @BindView(R.id.txt_city_destination) TextView txtCity;
    @BindView(R.id.txt_country_destination) TextView txtCountry;
    @BindView(R.id.txt_province_destination) TextView txtProvince;
    @BindView(R.id.txt_timezone_destination) TextView txtTimezone;
    @BindView(R.id.txt_rating_destination) TextView txtRating;
    @BindView(R.id.txt_estimated_cost_destination) TextView txtEstimatedCost;
    @BindView(R.id.btn_route) Button btnRoute;
    @BindView(R.id.btn_review) Button btnReview;
    @BindView(R.id.btn_tour_guide) Button btnTourGuide;
    @BindView(R.id.rv_review) RecyclerView rvReview;

    List<Review> listTweet;
    DestinationResult destinationResult;
    DetailDestinationAdapter adapter;

    int idDest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_destination);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        idDest = getIntent().getIntExtra("id_dest",0);

        callDataDestination();

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvReview.setVisibility(View.VISIBLE);
            }
        });

        btnTourGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvReview.setVisibility(View.GONE);
                goToListTourGuide();
            }
        });

        btnRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvReview.setVisibility(View.GONE);
                goToDetailRoute();
            }
        });

    }

    private void callDataDestination() {
        Call<DestinationModel> call = RetrofitServices.sendDestinationRequest().callDestination(idDest);
        call.enqueue(new Callback<DestinationModel>() {
            @Override
            public void onResponse(Call<DestinationModel> call, Response<DestinationModel> response) {
                if (response.body() != null){
                    if (response.body().getError() == null){

                        destinationResult =response.body().getList().get(0);

                        Picasso.with(getApplicationContext()).load(destinationResult.getImgUrl()).into(imgDestination);
                        txtCity.setText("City : " + destinationResult.getCity());
                        txtDestination.setText(destinationResult.getName());
                        txtProvince.setText("Province : " + destinationResult.getProvince());
                        txtCountry.setText("Country : " + destinationResult.getCountry());
                        txtTimezone.setText("Timezone : GMT " + destinationResult.getTimezone());
                        txtRating.setText("Rating : " + destinationResult.getRating());
                        txtEstimatedCost.setText("Estimated Cost : Rp. " + destinationResult.getCost());

                        setDataTweet();
                        callData();

                        LinearLayout ll = (LinearLayout) findViewById(R.id.root);
                        ll.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<DestinationModel> call, Throwable t) {

            }
        });
    }

    private void goToDetailRoute() {
        Intent intent = new Intent(getApplicationContext(), RouteActivity.class);
        intent.putExtra("id_place_route", idDest);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    private void setDataTweet() {
        listTweet = new ArrayList<>();

        rvReview.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rvReview.setLayoutManager(llm);

        adapter = new DetailDestinationAdapter(new Destination.OnReviewClicked() {
            @Override
            public void onClick(Review tweetResult) {

            }
        }, listTweet, getApplicationContext());

        rvReview.setAdapter(adapter);
    }

    private void callData(){
        listTweet = destinationResult.getReview();
        adapter.refreshData(listTweet);
    }

    private void goToListTourGuide(){
        Intent intent = new Intent(getApplicationContext(), ListTourGuideActivity.class);
        intent.putExtra("id_city",destinationResult.getCity());
        startActivity(intent);
    }
}
