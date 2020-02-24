package com.example.prak4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes,rvHorizontal;
    private ArrayList<Hero> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvHeroes = findViewById(R.id.rv_Heroes);
        rvHorizontal = findViewById(R.id.rv_list);
        rvHeroes.setHasFixedSize(true);
        rvHorizontal.setHasFixedSize(true);

        list.addAll(HeroData.getListData());
        showRecyclerList();
    }
    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        rvHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        HeroAdapter listHeroAdapterHorizontal = new HeroAdapter(list, 1);
        HeroAdapter listHeroAdapter = new HeroAdapter(list, 2);
        rvHorizontal.setAdapter(listHeroAdapterHorizontal);
        rvHeroes.setAdapter(listHeroAdapter);
    }
}
