package com.azsoftech.audioplayer;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class SongsFragment extends Fragment {

    ListView listView;
    LayoutInflater layoutInflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View songsFragmentView = inflater.inflate(R.layout.songs_layout, container, false);

        listView = songsFragmentView.findViewById(R.id.listView);

        listView.setAdapter(new MyAdapter() );

        return songsFragmentView;
    }
    //ONCREATE VIEW END

    //CUSTOM LIST ADAPTER
    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.music_list_item,listView,false);

            return myView;
        }
    }

}