package coloca.user;

import android.content.DialogInterface;
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
        for (int i = 0; i < 8; i++) listTour.add(new TourGuideResult(i, R.mipmap.ic_launcher, "Joko Susili", "Location : Bandung, Bali", "Language : Japanese"));
        adapter.refreshData(listTour);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
}
