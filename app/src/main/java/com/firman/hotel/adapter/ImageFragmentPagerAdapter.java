package com.firman.hotel.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.firman.hotel.fragment.ImageFragment;
import com.firman.hotel.model.GalleryItem;

import java.util.ArrayList;

/**
 * Created by Firmanz on 8/18/2016.
 */
public class ImageFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<GalleryItem> listGallery;

    public ArrayList<GalleryItem> getListGallery() {
        return listGallery;
    }

    public void setListGallery(ArrayList<GalleryItem> listGallery) {
        this.listGallery = listGallery;
    }

    public ImageFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ImageFragment.newInstance(listGallery.get(position));
    }

    @Override
        public int getCount() {
        return listGallery.size();
    }
}
