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
        for (int i = 0; i < 10; i++) listTweet.add(new TweetResult(i,"@faizzuns","27 Jan 2018, 13:00","ea eae ea ea ea e f d dj dn ja k  dn jdnsdnsdsd j dndfjfa nsfvsfksk n nvskvbjvsfmvs dfnfdfdf knvksjknvkdgkkdbfdnfdgfdgf"));
        adapter.refreshData(listTweet);
    }

    private void goToListTourGuide(){
        Intent intent = new Intent(getApplicationContext(), ListTourGuideActivity.class);
        startActivity(intent);
    }
}
