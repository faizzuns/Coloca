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
import coloca.user.models.route.RouteResult;

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
        listRoute.add(new RouteResult("http://1.bp.blogspot.com/-s0M7sTp5Ilo/U2YhWZ9qLjI/AAAAAAAAA2s/h6yqW10rGdA/s1600/Trayek+06+angkot+bogor.png","http://1.bp.blogspot.com/-s0M7sTp5Ilo/U2YhWZ9qLjI/AAAAAAAAA2s/h6yqW10rGdA/s1600/Trayek+06+angkot+bogor.png","Stasiun Karang Bunga", "Stasiun BUnga Ayam"));
        listRoute.add(new RouteResult("http://1.bp.blogspot.com/-s0M7sTp5Ilo/U2YhWZ9qLjI/AAAAAAAAA2s/h6yqW10rGdA/s1600/Trayek+06+angkot+bogor.png","http://1.bp.blogspot.com/-s0M7sTp5Ilo/U2YhWZ9qLjI/AAAAAAAAA2s/h6yqW10rGdA/s1600/Trayek+06+angkot+bogor.png","Stasiun Bunga Ayam", "Hotel Horison"));
        routeAdapter.refreshData(listRoute);
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
