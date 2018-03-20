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
import coloca.user.models.route.RouteResult;

/**
 * Created by User on 21/03/2018.
 */

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.ViewHolder> {

    private List<RouteResult> list;
    private Context context;

    public RouteAdapter(List<RouteResult> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.icon_awal) ImageView iconAwal;
        @BindView(R.id.icon_akhir) ImageView iconAkhir;
        @BindView(R.id.txt_awal) TextView txtAwal;
        @BindView(R.id.txt_akhir) TextView txtAkhir;

        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public RouteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_route,parent,false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RouteAdapter.ViewHolder holder, int position) {
        final RouteResult routeResult = list.get(position);

        Picasso.with(context).load(routeResult.getIconAwal()).into(holder.iconAwal);
        Picasso.with(context).load(routeResult.getIconAkhir()).into(holder.iconAkhir);
        holder.txtAwal.setText(routeResult.getTxtAwal());
        holder.txtAkhir.setText(routeResult.getTxtAkhir());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void refreshData(List<RouteResult> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
