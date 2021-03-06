package coloca.user.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import coloca.user.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IklanFragment extends Fragment {

    @BindView(R.id.img_iklan)
    ImageView imgIklan;

    private String iklan;

    public IklanFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public IklanFragment(String iklan){
        this.iklan = iklan;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_iklan, container, false);
        ButterKnife.bind(this,v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Picasso.with(getContext()).load(iklan).into(imgIklan);
    }
}
