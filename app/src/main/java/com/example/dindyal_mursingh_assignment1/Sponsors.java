package com.example.dindyal_mursingh_assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dindyal_mursingh_assignment1.Adapter.Speakers_Adapter_class;
import com.example.dindyal_mursingh_assignment1.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class Sponsors extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    List<Item> items;
    Speakers_Adapter_class adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        initItem();
    }
    private void initItem(){
        items = new ArrayList<>();

        items.add(new Item(0,"Sponsor1","Vegan Food","https://" +
                "getbento.imgix.net" +
                "/m2CLZntpSSO0ocR4jfL5_Logo._Anna-01%201.jpg"));

        items.add(new Item(1,"Sponsor2","Pizza","https:" +
                "//botw-pd.s3.amazonaws.com/styles/logo-original-577x577/s3/032011/pizza_pizza_logo.png?" +
                "itok=AzaP1ibz"));

        items.add(new Item(1,"Sponsor3","Snacks","https://opj.ca/" +
                "wp-content/uploads/2018/05/walmart.jpg"));
        items.add(new Item(1,"Sponsor4","Anon","https://vig" +
                "nette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015"));
        items.add(new Item(1,"Sponsor5","Anon","https://vig" +
                "nette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015"));
        items.add(new Item(1,"Sponsor6","Memeber3","https://vig" +
                "nette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015"));
        items.add(new Item(1,"Sponsor6","Member4","https://vig" +
                "nette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015"));


        adapter = new Speakers_Adapter_class(this, items);
        recyclerView.setAdapter(adapter);
    }
}
