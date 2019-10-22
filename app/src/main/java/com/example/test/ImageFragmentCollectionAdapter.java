package com.example.test;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.io.File;
import java.util.ArrayList;

public class ImageFragmentCollectionAdapter extends PagerAdapter {

    ArrayList<String> fileNames;
    int count;
    Context context;
    LayoutInflater inflater;


    public ImageFragmentCollectionAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<String> fileNames, int count, Context context) {
        this.count=count;
        this.fileNames=fileNames;
        inflater = LayoutInflater.from(context);
    }

    /*@NonNull
    @Override
    public Fragment getItem(int position) {
        ImageFragment imageFragment=new ImageFragment();
        Bundle bundle=new Bundle();
        bundle.putString("path",fileNames.get(position));
        imageFragment.setArguments(bundle);
        return imageFragment;
    }*/

    @Override
    public int getCount() {
        return count;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View imageLayout = inflater.inflate(R.layout.fragment_image, container, false);
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image_view);
        imageView.setImageBitmap(BitmapFactory.decodeFile(fileNames.get(position)));
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
