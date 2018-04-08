package coloca.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import coloca.user.adapters.RouteAdapter;
import coloca.user.models.route.RouteModel;
import coloca.user.models.route.RouteResult;
import coloca.user.services.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RouteActivity extends AppCompatActivity {

    @BindView(R.id.rv_route) RecyclerView rvRoute;

    List<RouteResult> listRoute;
    RouteAdapter routeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        ButterKnife.bind(this);

        setDataRoute();
        callDataRoute();
    }

    private void callDataRoute() {
        listRoute = new ArrayList<>();
        Call<RouteModel> call = RetrofitServices.sendRouteRequest().callRoute("apa aja","apa aja");
        call.enqueue(new Callback<RouteModel>() {
            @Override
            public void onResponse(Call<RouteModel> call, Response<RouteModel> response) {
                if (response.body() != null){
                    if (response.body().getError() == null){
                        if (routeAdapter != null) routeAdapter.refreshData(response.body().getList());
                    }
                }
            }

            @Override
            public void onFailure(Call<RouteModel> call, Throwable t) {

            }
        });
    }

    private void setDataRoute() {
        listRoute = new ArrayList<>();
        rvRoute.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvRoute.setLayoutManager(llm);

        routeAdapter = new RouteAdapter(listRoute, getApplicationContext());
        rvRoute.setAdapter(routeAdapter);
    }
}
