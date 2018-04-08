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
import coloca.user.models.destination.AllPlaceModel;
import coloca.user.models.destination.DestinationResult;
import coloca.user.services.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultDestinationActivity extends AppCompatActivity {

    @BindView(R.id.rv_result_destination)
    RecyclerView rvResult;

    List<AllPlaceModel.PlaceData> listDestination;
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
            public void onClick(AllPlaceModel.PlaceData destinationResult) {
                //Toast.makeText(MainActivity.this, destinationResult.getDestinationName(), Toast.LENGTH_SHORT).show();
                goToDetailDestination(destinationResult.getId());
            }
        }, listDestination, getApplicationContext());
        rvResult.setAdapter(destinationAdapter);
    }

    private void callDestinationData() {
        listDestination = new ArrayList<>();
        Call<AllPlaceModel> call = RetrofitServices.sendPlaceRequest().callPlace(getIntent().getStringExtra("search"),20,0);
        call.enqueue(new Callback<AllPlaceModel>() {
            @Override
            public void onResponse(Call<AllPlaceModel> call, Response<AllPlaceModel> response) {
                if (response.body() != null){
                    if (response.body().getError() == null){
                        if (destinationAdapter != null) destinationAdapter.refreshData(response.body().getList());
                    }
                }
            }
            @Override
            public void onFailure(Call<AllPlaceModel> call, Throwable t) {

            }
        });
    }

    private void goToDetailDestination(int id){
        Intent intent = new Intent(getApplicationContext(), DetailDestinationActivity.class);
        intent.putExtra("id_dest",id);
        startActivity(intent);
    }
}
