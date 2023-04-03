package com.azsoftech.audioplayer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAudioPlayerAdapter extends FragmentPagerAdapter {

    public ViewPagerAudioPlayerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if( position == 0 ) {
            return new SongsFragment();
        } else if ( position == 1 ){
            return new ArtistFragmentMine();
        } else if ( position == 2 ){
            return new AlbumsFragment();
        } else{
            return new PlaylistsFragment();
        }

    }

    @Override
    public int getCount() {

        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0){
            return "Songs";
        } else if (position == 1){
            return "Artists";
        } else if (position == 2){
            return "Albums";
        } else{
            return "Playlists";
        }

    }
}
