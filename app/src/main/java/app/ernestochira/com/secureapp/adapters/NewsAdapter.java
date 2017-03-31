package app.ernestochira.com.secureapp.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.ernestochira.com.secureapp.R;
import app.ernestochira.com.secureapp.models.News;

/**
 * Created by usuario on 29/03/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> newses;

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_news, parent, false);

        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        holder.userTextView.setText(newses.get(position).getUser());
        holder.typeIncidenceTextView.setText(newses.get(position).getTypeIncidence());
        holder.descriptionTextView.setText(newses.get(position).getDescription());
        holder.dateTextView.setText(newses.get(position).getDate());
        holder.hourTextView.setText(newses.get(position).getHour());
        holder.evidenceImageView.setImageResource(Integer.valueOf(newses.get(position).getEvidence()));
    }

    @Override
    public int getItemCount() {
        return newses.size();
    }

    public List<News> getIncidence() {
        return newses;
    }

    public void setProducts(List<News> newses) {
        this.newses = newses;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userTextView;
        TextView typeIncidenceTextView;
        TextView descriptionTextView;
        TextView dateTextView;
        TextView hourTextView;
        ImageView evidenceImageView;
        CardView incidenceCardView;

        public ViewHolder(View itemView) {
            super(itemView);

            userTextView = (TextView) itemView.findViewById(R.id.userTextView);
            typeIncidenceTextView = (TextView) itemView.findViewById(R.id.typeIncidenceTextView);
            descriptionTextView = (TextView) itemView.findViewById(R.id.descriptionTextView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            hourTextView = (TextView) itemView.findViewById(R.id.hourTextView);
            evidenceImageView = (ImageView) itemView.findViewById(R.id.evidenceImageView);
            incidenceCardView=(CardView) itemView.findViewById(R.id.incidenceCardView);
        }
    }
}
