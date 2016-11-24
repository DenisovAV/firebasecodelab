package ru.devfestby.codelabfirebase.controller;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ru.devfestby.codelabfirebase.R;
import ru.devfestby.codelabfirebase.model.Speaker;

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.SpeakerViewHolder>{

    private List<Speaker> speakers;
    private Context context;

    public SpeakerAdapter(List<Speaker> speakers, Context context){
        this.speakers = speakers;
        this.context = context;
    }


    @Override
    public SpeakerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_speaker, viewGroup, false);
        SpeakerViewHolder viewHolder = new SpeakerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SpeakerViewHolder holder, int position) {
        final Speaker speaker = speakers.get(position);
        holder.name.setText(speaker.getName());
        holder.description.setText(speaker.getDescription());
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.listener(new Picasso.Listener()
        {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
            {
                exception.printStackTrace();
            }
        });
        builder.build().load(speaker.getPhoto()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return speakers.size();
    }

    public class SpeakerViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;
        TextView description;

        public SpeakerViewHolder(View itemView) {
            super(itemView);
            name =  (TextView)itemView.findViewById(R.id.name);
            description = (TextView)itemView.findViewById(R.id.description);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}
