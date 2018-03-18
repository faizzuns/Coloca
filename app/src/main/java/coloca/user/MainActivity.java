package coloca.user;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import coloca.user.fragments.IklanFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "cekMain";
    @BindView(R.id.pager_iklan) ViewPager pagerIklan;
    @BindView(R.id.tabs_dot) TabLayout tabsDot;
    @BindView(R.id.edt_search) EditText edtSearch;
    @BindView(R.id.rv_top_destination) RecyclerView rvTopDestination;
    @BindView(R.id.rv_top_tour_guide) RecyclerView rvTopTourGuide;

    List<Integer> listIklan;
    ViewPagerAdapter adapter;
    private Handler handler;
    private Runnable runnable;
    private int idxIklan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        callIklanData();
        setUpViewPager();
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
