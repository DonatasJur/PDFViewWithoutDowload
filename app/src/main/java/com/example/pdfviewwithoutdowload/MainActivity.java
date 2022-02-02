package com.example.pdfviewwithoutdowload;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public static List<PDFModel> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("PDF One", "https://foreverliving.app.box.com/file/913349516266?s=cwyz87ezbw2xve8pbuki2tajoohg4xez"));
        list.add(new PDFModel("PDF Two", "https://foreverliving.app.box.com/file/913343765167"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemClickListener itemClickListener = new ItemClickListener() {

            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(MainActivity.this, PDFActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        };

        PDFAdapter adapter = new PDFAdapter(list, this, itemClickListener);
        recyclerView.setAdapter(adapter);
    }
}