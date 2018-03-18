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

/**
 * Created by User on 18/03/2018.
 */

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.ViewHolder>{

    Main.OnDestinationClicked listener;
    List<DestinationResult> list;
    Context context;

    public DestinationAdapter(Main.OnDestinationClicked listener, List<DestinationResult> list, Context context) {
        this.listener = listener;
        this.list = list;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img_destination) ImageView imgDestination;
        @BindView(R.id.txt_destination) TextView txtDestination;

        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public DestinationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_destination,parent,false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(DestinationAdapter.ViewHolder holder, int position) {
        final DestinationResult destinationResult = list.get(position);

        Picasso.with(context).load(destinationResult.getImgUrl()).into(holder.imgDestination);
        holder.txtDestination.setText(destinationResult.getDestinationName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(destinationResult);
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
    public void refreshData(List<DestinationResult> list){
        this.list = list;
        notifyDataSetChanged();
    }

}
