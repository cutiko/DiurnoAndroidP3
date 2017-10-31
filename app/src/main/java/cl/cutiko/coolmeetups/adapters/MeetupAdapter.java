package cl.cutiko.coolmeetups.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import cl.cutiko.coolmeetups.R;
import cl.cutiko.coolmeetups.models.Meetup;

/**
 * Created by cutiko on 26-10-17.
 */

public class MeetupAdapter extends FirebaseRecyclerAdapter<Meetup, MeetupAdapter.MeetupHolder> {

    //TODO you have to initialize an interface to this adapter can communicate with the fragment when the user click a row

    public MeetupAdapter(FirebaseRecyclerOptions<Meetup> options, BookListener listener) {
        super(options);
        //TODO you have to initialize an interface to this adapter can communicate with the fragment when the user click a row
    }

    @Override
    public MeetupHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // FIXME: 31-10-17 you have to make this inflates a layout and then return the meetup holder
        // the layout resource file is called list_item_meetup
        return null;
    }

    @Override
    protected void onBindViewHolder(final MeetupHolder holder, int position, Meetup model) {
        holder.title.setText(model.getTitle());
        holder.day.setText(model.getDay());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO here you have to get the key, remember you can't fight the recycling logic but use it to your favor
                Meetup meetup = null;
                //listener.clicked(meetup.getKey());
            }
        });
    }

    public static class MeetupHolder extends RecyclerView.ViewHolder {

        private TextView title, day;

        public MeetupHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTv);
            day = itemView.findViewById(R.id.dayTv);
        }
    }

}
