package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ImageFragmentCollectionAdapter adapter;
    ArrayList<String> fileNames;
    RecyclerView recyclerView;
    ArrayList<Bitmap> bitmapArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileNames=new ArrayList<>();
        bitmapArrayList=new ArrayList<>();

        String folderPath = Environment.getExternalStorageDirectory()+"/Aman";
        File file= new File(folderPath);
        File[] files=file.listFiles();

        for (int i=0;i<files.length;i++){
            fileNames.add(files[i].getAbsolutePath());
            bitmapArrayList.add(BitmapFactory.decodeFile(files[i].getAbsolutePath()));
        }

        recyclerView=findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        ImageAdapter imageAdapter=new ImageAdapter(fileNames,MainActivity.this,bitmapArrayList);
        recyclerView.setAdapter(imageAdapter);

        /*viewPager=findViewById(R.id.pager);

        adapter=new ImageFragmentCollectionAdapter(getSupportFragmentManager(),122,fileNames,files.length,this);

        viewPager.setAdapter(adapter);*/




    }
}
