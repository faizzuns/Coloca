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
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import coloca.user.adapters.DetailDestinationAdapter;
import coloca.user.listeners.Destination;
import coloca.user.models.tweet.TweetResult;

public class DetailDestinationActivity extends AppCompatActivity {

    @BindView(R.id.img_destination) ImageView imgDestination;
    @BindView(R.id.txt_destination) TextView txtDestination;
    @BindView(R.id.txt_country_destination) TextView txtCountry;
    @BindView(R.id.txt_province_destination) TextView txtProvince;
    @BindView(R.id.txt_timezone_destination) TextView txtTimezone;
    @BindView(R.id.txt_rating_destination) TextView txtRating;
    @BindView(R.id.txt_estimated_cost_destination) TextView txtEstimatedCost;
    @BindView(R.id.btn_route) Button btnRoute;
    @BindView(R.id.btn_review) Button btnReview;
    @BindView(R.id.btn_tour_guide) Button btnTourGuide;
    @BindView(R.id.rv_review) RecyclerView rvReview;

    List<TweetResult> listTweet;
    DetailDestinationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_destination);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setDataTweet();
        callData();

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvReview.setVisibility(View.VISIBLE);
            }
        });

        btnTourGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToListTourGuide();
            }
        });

        btnRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDetailRoute();
            }
        });

        Picasso.with(getApplicationContext()).load("https://blog.traveloka.com/wp-content/uploads/2017/08/DSC_0409.jpg").into(imgDestination);


    }

    private void goToDetailRoute() {
        Intent intent = new Intent(getApplicationContext(), RouteActivity.class);
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
            public void onClick(TweetResult tweetResult) {

            }
        }, listTweet, getApplicationContext());

        rvReview.setAdapter(adapter);
    }

    private void callData(){
        listTweet = new ArrayList<>();
        listTweet.add(new TweetResult(1,"@faizzuns","27 Jan 2018, 13:00","Pantai Tanjung Lesung is very beautiful!! i want go there again :("));
        listTweet.add(new TweetResult(2, "@KingJames", "27 Jan 2018 15:00", "I'm very happy that i can go to Pantai Tanjung Lesung! There is a baby shark swim with me."));
        listTweet.add(new TweetResult(3, "@sodikooo", "28 Jan 2018 10:00", "Pantai Tanjung Lesung has a good scenery! very love this view <3 <3"));
        listTweet.add(new TweetResult(4, "@denailry", "29 Jan 2018 18:00", "heaven in Indonesia! (Pantai Tanjung Lesung)"));
        listTweet.add(new TweetResult(5, "@ilhamfp", "30 Jan 2018 13:32", "Why i just come here 3 days?!??!?! i want to stay in here more!!in Pantai Tanjung Lesung dude!"));
        adapter.refreshData(listTweet);
    }

    private void goToListTourGuide(){
        Intent intent = new Intent(getApplicationContext(), ListTourGuideActivity.class);
        startActivity(intent);
    }
}
