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
import coloca.user.models.destination.DestinationResult;
import coloca.user.models.guide.TourGuideResult;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "cekMain";
    @BindView(R.id.pager_iklan) ViewPager pagerIklan;
    @BindView(R.id.tabs_dot) TabLayout tabsDot;
    @BindView(R.id.edt_search) EditText edtSearch;
    @BindView(R.id.rv_top_destination) RecyclerView rvTopDestination;
    @BindView(R.id.rv_top_tour_guide) RecyclerView rvTopTourGuide;
    @BindView(R.id.btn_go)
    Button btnGo;

    List<Integer> listIklan;
    ViewPagerAdapter adapter;
    private Handler handler;
    private Runnable runnable;
    private int idxIklan;

    List<DestinationResult> listDestination;
    DestinationAdapter destinationAdapter;

    List<TourGuideResult> listTopTourGuide;
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
                goToDetailDestination();
            }
        });
    }

    private void goToDetailDestination(){
        Intent intent = new Intent(getApplicationContext(), DetailDestinationActivity.class);
        startActivity(intent);
    }

    private void callTopTourGuideData() {
        listTopTourGuide = new ArrayList<>();
        listTopTourGuide.add(new TourGuideResult(1, R.mipmap.ic_launcher, "Joko"));
        listTopTourGuide.add(new TourGuideResult(1, R.mipmap.ic_launcher, "Joko"));
        listTopTourGuide.add(new TourGuideResult(1, R.mipmap.ic_launcher, "Joko"));
        listTopTourGuide.add(new TourGuideResult(1, R.mipmap.ic_launcher, "Joko"));
        listTopTourGuide.add(new TourGuideResult(1, R.mipmap.ic_launcher, "Joko"));
        listTopTourGuide.add(new TourGuideResult(1, R.mipmap.ic_launcher, "Joko"));
        topTourGuideAdapter.refreshData(listTopTourGuide);
    }

    private void callDestinationData() {
        listDestination = new ArrayList<>();
        listDestination.add(new DestinationResult(1, R.mipmap.ic_launcher, "Bali"));
        listDestination.add(new DestinationResult(1, R.mipmap.ic_launcher, "Bali"));
        listDestination.add(new DestinationResult(1, R.mipmap.ic_launcher, "Bali"));
        listDestination.add(new DestinationResult(1, R.mipmap.ic_launcher, "Bali"));
        listDestination.add(new DestinationResult(1, R.mipmap.ic_launcher, "Bali"));
        listDestination.add(new DestinationResult(1, R.mipmap.ic_launcher, "Bali"));
        destinationAdapter.refreshData(listDestination);
    }

    private void setTopTourGuideData() {
        listTopTourGuide = new ArrayList<>();
        final LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvTopTourGuide.setLayoutManager(llm);

        topTourGuideAdapter = new TopTourGuideAdapter(new Main.OnTourGuideClicked() {
            @Override
            public void onClick(TourGuideResult tourGuideResult) {
                Toast.makeText(MainActivity.this, tourGuideResult.getName(), Toast.LENGTH_SHORT).show();
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
            public void onClick(DestinationResult destinationResult) {
                Toast.makeText(MainActivity.this, destinationResult.getDestinationName(), Toast.LENGTH_SHORT).show();
            }
        }, listDestination, getApplicationContext());
        rvTopDestination.setAdapter(destinationAdapter);
    }

    private void setUpViewPager() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        for (int iklan : listIklan){
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
        listIklan.add(R.drawable.iklan_1);
        listIklan.add(R.drawable.iklan_2);
        listIklan.add(R.drawable.iklan_3);
        listIklan.add(R.drawable.iklan_4);
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
