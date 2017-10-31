package cl.cutiko.coolmeetups.views.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import cl.cutiko.coolmeetups.R;
import cl.cutiko.coolmeetups.adapters.BookListener;
import cl.cutiko.coolmeetups.adapters.MeetupAdapter;
import cl.cutiko.coolmeetups.models.Meetup;
import cl.cutiko.coolmeetups.views.details.DetailsActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MeetupListFragment extends Fragment implements BookListener {

    private MeetupAdapter adapter;

    public MeetupListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meetup_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        // FIXME: 31-10-17 you have to initialize the firebase options properly
        FirebaseRecyclerOptions<Meetup> options = null;
        //TODO initialize this properly
        //adapter = new MeetupAdapter(options, this);
        //recyclerView.setAdapter(adapter);
    }

    @Override
    public void clicked(String key) {
        //When the user click the list then we move on to the next activity with the key, we will use the key to get the full event
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(DetailsActivity.MEETUP_KEY, key);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        // FIXME: 31-10-17 on start the adapter should start to?
    }

    //TODO you need make the adapter stop listening: override the corresponding life cycle event
}
