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
import coloca.user.models.destination.DestinationResult;
import coloca.user.models.guide.TourGuideResult;
import coloca.user.models.tweet.TweetResult;

/**
 * Created by User on 18/03/2018.
 */

public class DetailDestinationAdapter extends RecyclerView.Adapter<DetailDestinationAdapter.ViewHolder>{

    Destination.OnReviewClicked listener;
    List<TweetResult> list;
    Context context;

    public DetailDestinationAdapter(Destination.OnReviewClicked listener, List<TweetResult> list, Context context) {
        this.listener = listener;
        this.list = list;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.txt_username) TextView txtUsername;
        @BindView(R.id.txt_time) TextView txtTime;
        @BindView(R.id.txt_tweet) TextView txtTweet;

        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public DetailDestinationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_review,parent,false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TweetResult tweetResult= list.get(position);

        holder.txtTime.setText(tweetResult.getTime());
        holder.txtTweet.setText(tweetResult.getTweet());
        holder.txtUsername.setText(tweetResult.getUsername());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(tweetResult);
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
    public void refreshData(List<TweetResult> list){
        this.list = list;
        notifyDataSetChanged();
    }

}
