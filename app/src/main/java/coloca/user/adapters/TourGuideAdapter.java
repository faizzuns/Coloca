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
import coloca.user.listeners.Destination;
import coloca.user.listeners.Main;
import coloca.user.models.guide.AllTourGuideModel;
import coloca.user.models.guide.TourGuideResult;
import coloca.user.models.tweet.TweetResult;

/**
 * Created by User on 18/03/2018.
 */

public class TourGuideAdapter extends RecyclerView.Adapter<TourGuideAdapter.ViewHolder>{

    Main.OnTourGuideClicked listener;
    List<AllTourGuideModel.TourGuideData> list;
    Context context;

    public TourGuideAdapter(Main.OnTourGuideClicked listener, List<AllTourGuideModel.TourGuideData> list, Context context) {
        this.listener = listener;
        this.list = list;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img_photo_tour)
        ImageView imgPhotoTour;
        @BindView(R.id.txt_name_tour) TextView txtName;
        @BindView(R.id.txt_location_tour) TextView txtLocation;
        @BindView(R.id.txt_language_tour) TextView txtLanguage;

        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public TourGuideAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tour_guide,parent,false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final AllTourGuideModel.TourGuideData tourGuideResult= list.get(position);

        Picasso.with(context).load(tourGuideResult.getImgUrl()).into(holder.imgPhotoTour);
        holder.txtName.setText(tourGuideResult.getName());
        if (tourGuideResult.getListLocation().size() != 0) {
            String s = "";
            for (String ss : tourGuideResult.getListLocation()) s += "," + ss;
            holder.txtLocation.setText("Location : " + s);
        }
        if (tourGuideResult.getListLanguage().size() != 0){
            String s = "";
            for (String ss : tourGuideResult.getListLanguage()) s += "," + ss;
            holder.txtLanguage.setText("Language : " + s);
        }
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
    public void refreshData(List<AllTourGuideModel.TourGuideData> list){
        this.list = list;
        notifyDataSetChanged();
    }

}
