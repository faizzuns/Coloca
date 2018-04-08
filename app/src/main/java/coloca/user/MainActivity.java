package coloca.user;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import coloca.user.adapters.DestinationAdapter;
import coloca.user.adapters.TopTourGuideAdapter;
import coloca.user.fragments.IklanFragment;
import coloca.user.listeners.Main;
import coloca.user.models.destination.AllPlaceModel;
import coloca.user.models.destination.DestinationResult;
import coloca.user.models.guide.AllTourGuideModel;
import coloca.user.models.guide.TourGuideResult;
import coloca.user.services.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "cekMain";
    @BindView(R.id.pager_iklan) ViewPager pagerIklan;
    @BindView(R.id.tabs_dot) TabLayout tabsDot;
    @BindView(R.id.edt_search) EditText edtSearch;
    @BindView(R.id.rv_top_destination) RecyclerView rvTopDestination;
    @BindView(R.id.rv_top_tour_guide) RecyclerView rvTopTourGuide;
    @BindView(R.id.btn_go)
    Button btnGo;

    List<String> listIklan;
    ViewPagerAdapter adapter;
    private Handler handler;
    private Runnable runnable;
    private int idxIklan;

    List<AllPlaceModel.PlaceData> listDestination;
    DestinationAdapter destinationAdapter;

    List<AllTourGuideModel.TourGuideData> listTopTourGuide;
    TopTourGuideAdapter topTourGuideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        callIklanData();
        setUpViewPager();

        setDestinationData();
        setTopTourGuideData();

        callDestinationData();
        callTopTourGuideData();

        edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtSearch.setCursorVisible(true);
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToResultDestination(edtSearch.getText().toString());
            }
        });
    }

    private void goToDetailDestination(int id){
        Intent intent = new Intent(getApplicationContext(), DetailDestinationActivity.class);
        intent.putExtra("id_dest",id);
        startActivity(intent);
    }

    private void goToResultDestination(String keyword){
        Intent intent = new Intent(getApplicationContext(), ResultDestinationActivity.class);
        intent.putExtra("search",keyword);
        startActivity(intent);
    }

    private void goToDetailTourGuide(int id){
        Intent intent = new Intent(getApplicationContext(), DetailTourGuideActivity.class);
        intent.putExtra("id_guide",id);
        startActivity(intent);
    }

    private void callTopTourGuideData() {
        listTopTourGuide = new ArrayList<>();
        Call<AllTourGuideModel> call = RetrofitServices.sendAllGuideRequest().callAllGuide(null, null, 10, 0);
        call.enqueue(new Callback<AllTourGuideModel>() {
            @Override
            public void onResponse(Call<AllTourGuideModel> call, Response<AllTourGuideModel> response) {
                if (response.body() != null){
                    if (response.body().getError() == null){
                        if (topTourGuideAdapter != null) topTourGuideAdapter.refreshData(response.body().getList());
                    }
                }
            }

            @Override
            public void onFailure(Call<AllTourGuideModel> call, Throwable t) {

            }
        });
    }

    private void callDestinationData() {
        listDestination = new ArrayList<>();
        Call<AllPlaceModel> call = RetrofitServices.sendTopTenRequest().callTopTen();
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

    private void setTopTourGuideData() {
        listTopTourGuide = new ArrayList<>();
        final LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvTopTourGuide.setLayoutManager(llm);

        topTourGuideAdapter = new TopTourGuideAdapter(new Main.OnTourGuideClicked() {
            @Override
            public void onClick(AllTourGuideModel.TourGuideData tourGuideResult) {
                //Toast.makeText(MainActivity.this, tourGuideResult.getName(), Toast.LENGTH_SHORT).show();
                goToDetailTourGuide(tourGuideResult.getIdGuide());
            }
        }, listTopTourGuide, getApplicationContext());
        rvTopTourGuide.setAdapter(topTourGuideAdapter);
    }

    private void setDestinationData() {
        listDestination = new ArrayList<>();
        final LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvTopDestination.setLayoutManager(llm);

        destinationAdapter = new DestinationAdapter(new Main.OnDestinationClicked() {
            @Override
            public void onClick(AllPlaceModel.PlaceData destinationResult) {
                //Toast.makeText(MainActivity.this, destinationResult.getDestinationName(), Toast.LENGTH_SHORT).show();
                goToDetailDestination(destinationResult.getId());
            }
        }, listDestination, getApplicationContext());
        rvTopDestination.setAdapter(destinationAdapter);
    }

    private void setUpViewPager() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        for (String iklan : listIklan){
            adapter.addFragment(new IklanFragment(iklan), "");
        }

        pagerIklan.setAdapter(adapter);
        pagerIklan.setCurrentItem(0);
        idxIklan = 0;
        tabsDot.setupWithViewPager(pagerIklan);
        pagerIklan.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d(TAG, "onPageScrolled: "+position);
                idxIklan = position;
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,5000);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: "+position);
                idxIklan = position;
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,5000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                idxIklan = (idxIklan + 1) % listIklan.size();
                pagerIklan.setCurrentItem(idxIklan, true);
                handler.postDelayed(runnable,5000);
            }
        };
        handler.postDelayed(runnable,5000);
    }

    private void callIklanData() {
        listIklan = new ArrayList<>();
        listIklan.add("https://tvlk.imgix.net/imageResource/2018/03/29/1522321109509-4feae2de0e7fa398357edc7c43f5a16b.png?auto=compress%2Cformat&cs=srgb&fm=png&ixlib=java-1.1.1&q=75");
        listIklan.add("https://tvlk.imgix.net/imageResource/2018/03/15/1521107344756-d04be2ccb37ce88ec22abcfe32367696.jpeg?auto=compress%2Cformat&cs=srgb&fm=pjpg&ixlib=java-1.1.1&q=75");
        listIklan.add("https://tvlk.imgix.net/imageResource/2018/01/31/1517388997076-b4d022ae07729574f59f1aa4ff0f4595.png?auto=compress%2Cformat&cs=srgb&fm=png&ixlib=java-1.1.1&q=75");
        listIklan.add("https://tvlk.imgix.net/imageResource/2018/02/22/1519296560313-73d42395491259c4b45e7e2e7c25802b.jpeg?auto=compress%2Cformat&cs=srgb&fm=pjpg&ixlib=java-1.1.1&q=75");
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList = new ArrayList<>();
        private List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
