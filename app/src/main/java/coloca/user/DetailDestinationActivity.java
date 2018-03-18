package coloca.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailDestinationActivity extends AppCompatActivity {

    @BindView(R.id.img_destination) ImageView imgDestination;
    @BindView(R.id.txt_destination) TextView txtDestination;
    @BindView(R.id.txt_country_destination) TextView txtCountry;
    @BindView(R.id.txt_province_destination) TextView txtProvince;
    @BindView(R.id.txt_timezone_destination) TextView txtTimezone;
    @BindView(R.id.txt_estimated_cost_destination) TextView txtEstimatedCost;
    @BindView(R.id.btn_route) Button btnRoute;
    @BindView(R.id.btn_tour_guide) Button btnTourGuide;
    @BindView(R.id.rv_review) RecyclerView rvReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_destination);
        ButterKnife.bind(this);
    }
}
