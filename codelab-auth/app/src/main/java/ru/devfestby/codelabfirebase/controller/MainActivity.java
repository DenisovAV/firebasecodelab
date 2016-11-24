package ru.devfestby.codelabfirebase.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import ru.devfestby.codelabfirebase.R;
import ru.devfestby.codelabfirebase.model.Speaker;

public class MainActivity extends AppCompatActivity {

    private List<Speaker> speakerList;

    private SpeakerAdapter adapter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speakerList=new ArrayList<>();
        setupToolbar();

        setupList();
        setupRecyclerView();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupList(){
        speakerList = new ArrayList<>();
        for(int i=0; i < 3; i++){
            Speaker speaker = new Speaker();
            speaker.setName("Yonatan Levin");
            speaker.setDescription("Born with the spirit of an entrepreneur, Yonatan loves to create, build and just do fun stuff in the technology field. Yonatan is one of the top Israeli mobile developers, who is also a part of an elite worldwide group of Google Developer Experts. His primary expertise is Android and Mobile UX, but is also friendly to backend technologies and people in general :)");
            speaker.setPhoto("http://devfest.by/assets/img/Yonatan_Levin.jpg");
            speakerList.add(speaker);
        }
    }

    private void setupRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SpeakerAdapter(speakerList,this);
        recyclerView.setAdapter(adapter);
    }
}
