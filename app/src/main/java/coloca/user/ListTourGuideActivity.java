package coloca.user;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import coloca.user.adapters.TourGuideAdapter;
import coloca.user.listeners.Main;
import coloca.user.models.guide.TourGuideResult;

public class ListTourGuideActivity extends AppCompatActivity {

    @BindView(R.id.rv_tour_guide)
    RecyclerView rvTourGuide;

    TourGuideAdapter adapter;
    List<TourGuideResult> listTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tour_guide);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pantai Tanjung Lesung");
        
        setDataTourGuide();
        callTourGuideData();
    }

    private void setDataTourGuide() {
        listTour = new ArrayList<>();
        rvTourGuide.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvTourGuide.setLayoutManager(llm);

        adapter = new TourGuideAdapter(new Main.OnTourGuideClicked() {
            @Override
            public void onClick(TourGuideResult tourGuideResult) {
                //Toast.makeText(ListTourGuideActivity.this, tourGuideResult.getName(), Toast.LENGTH_SHORT).show();
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                goToDetailTourGuide();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(ListTourGuideActivity.this);
                builder.setMessage("Are you want book this guide for your local trip?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        }, listTour, getApplicationContext());

        rvTourGuide.setAdapter(adapter);
    }

    private void callTourGuideData(){
        listTour = new ArrayList<>();
        listTour.add(new TourGuideResult(1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5kh2SfoLiz8Q4GkyXZM0N-pWg5EYj3WVm-CN51oWy70mETRl5", "Putri Charity", "Location : Banten", "Language : English"));
        listTour.add(new TourGuideResult(1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0SNB_ZVcARJpr_j8zd2q0aw8n0jAjYaQBnN7YBuaMijfJCSWy", "Liam Chandra", "Location : Banten", "Language : English"));
        listTour.add(new TourGuideResult(1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGIeez53rOV2I2E5n3LZPKYAG-P4SUUoaKW1FDHIyTqJqarz5a", "Joko Susilo", "Location : Banten", "Language : English"));
        listTour.add(new TourGuideResult(1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQ3H-UkGKMNZQa3eUq4sbGfcSaDZTnFf3xJ40W7T__kNZuR6hW", "Fatimah", "Location : Banten", "Language : English"));
        listTour.add(new TourGuideResult(1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFgYKGsXpzM8dMav_9JM4F9mNxDDTTLgIPOf4EaOh9YVu0Cr3t", "Peter Basambuhan", "Location : Banten", "Language : English"));
        listTour.add(new TourGuideResult(1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBRjyFVt96v63XVx3amRtaqoaW26A7AhuA3505FwOsGmLuJAc9", "Olivia Sandro", "Location : Banten", "Language : English"));
        adapter.refreshData(listTour);
    }

    private void goToDetailTourGuide(){
        Intent intent = new Intent(getApplicationContext(), DetailTourGuideActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
}
