package coloca.user.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import coloca.user.R;
import coloca.user.listeners.Main;
import coloca.user.models.destination.DestinationResult;
import coloca.user.models.guide.TourGuideResult;

/**
 * Created by User on 18/03/2018.
 */

public class TopTourGuideAdapter extends RecyclerView.Adapter<TopTourGuideAdapter.ViewHolder>{

    Main.OnTourGuideClicked listener;
    List<TourGuideResult> list;
    Context context;

    public TopTourGuideAdapter(Main.OnTourGuideClicked listener, List<TourGuideResult> list, Context context) {
        this.listener = listener;
        this.list = list;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img_tour_guide) ImageView img;
        @BindView(R.id.txt_name_tour_guide) TextView txt;

        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public TopTourGuideAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tour_guide_top,parent,false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TourGuideResult tourGuideResult= list.get(position);

        Picasso.with(context).load(tourGuideResult.getImgUrl()).into(holder.img);
        holder.txt.setText(tourGuideResult.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(tourGuideResult);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public void refreshData(List<TourGuideResult> list){
        this.list = list;
        notifyDataSetChanged();
    }

}
