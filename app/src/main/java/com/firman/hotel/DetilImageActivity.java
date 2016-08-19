package com.firman.hotel;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.firman.hotel.adapter.ImageFragmentPagerAdapter;
import com.firman.hotel.model.GalleryItem;

import java.util.ArrayList;

/**
 * Created by Firmanz on 8/18/2016.
 */
public class DetilImageActivity extends AppCompatActivity {
    private ArrayList<GalleryItem> listImage;
    public static String KEY_GALLERY_ITEM = "key_gallery_item";
    private int position;
    public static String KEY_POSITION = "position";

    private ViewPager viewPager;
    private ImageFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_image);

        viewPager = (ViewPager)findViewById(R.id.viewpager);

        listImage = getIntent().getParcelableArrayListExtra(KEY_GALLERY_ITEM);
        position = getIntent().getIntExtra(KEY_POSITION, 0);

        adapter = new ImageFragmentPagerAdapter(getSupportFragmentManager());
        adapter.setListGallery(listImage);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }
}
