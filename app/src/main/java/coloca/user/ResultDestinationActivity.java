package coloca.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import coloca.user.adapters.DestinationAdapter;
import coloca.user.listeners.Main;
import coloca.user.models.destination.DestinationResult;

public class ResultDestinationActivity extends AppCompatActivity {

    @BindView(R.id.rv_result_destination)
    RecyclerView rvResult;

    List<DestinationResult> listDestination;
    DestinationAdapter destinationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_destination);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setDestinationData();
        callDestinationData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }


    private void setDestinationData() {
        listDestination = new ArrayList<>();
        rvResult.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        destinationAdapter = new DestinationAdapter(new Main.OnDestinationClicked() {
            @Override
            public void onClick(DestinationResult destinationResult) {
                //Toast.makeText(MainActivity.this, destinationResult.getDestinationName(), Toast.LENGTH_SHORT).show();
                goToDetailDestination();
            }
        }, listDestination, getApplicationContext());
        rvResult.setAdapter(destinationAdapter);
    }

    private void callDestinationData() {
        listDestination = new ArrayList<>();
        listDestination.add(new DestinationResult(1, "https://blog.traveloka.com/wp-content/uploads/2017/08/ALDO1553_edit.jpg", "Danau Toba"));
        listDestination.add(new DestinationResult(1, "https://blog.traveloka.com/wp-content/uploads/2017/08/DSC00368.jpg", "Pantai Tanjung Kelayang"));
        listDestination.add(new DestinationResult(1, "https://blog.traveloka.com/wp-content/uploads/2017/08/DSC_0409.jpg", "Pantai Tanjung Lesung"));
        listDestination.add(new DestinationResult(1, "https://blog.traveloka.com/wp-content/uploads/2017/08/pulau-ayer-2-kep-seribu.jpg", "Kepulauan Seribu"));
        listDestination.add(new DestinationResult(1, "https://blog.traveloka.com/wp-content/uploads/2017/08/DIY-BOROBUDUR-SUNSET-1.jpg", "Candi Borobudur"));
        listDestination.add(new DestinationResult(1, "https://blog.traveloka.com/wp-content/uploads/2017/08/bromo_20140505232301-d7ff595f.jpg", "Gunung Bromo"));
        destinationAdapter.refreshData(listDestination);
    }

    private void goToDetailDestination(){
        Intent intent = new Intent(getApplicationContext(), DetailDestinationActivity.class);
        startActivity(intent);
    }
}
