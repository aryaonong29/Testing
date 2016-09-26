package com.arianasp.testing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ariana on 9/27/2016.
 */

public class AdiActivity extends AppCompatActivity implements AdapterEdiText.OnCardClickListener,DialogEditCommunicator{

    RecyclerView recyclerView;
    List<DataDao> list = new ArrayList<>();
    AdapterEdiText adapterEdiText;
    int rowPositionClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adi);

        recyclerView = (RecyclerView) findViewById(R.id.recyler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterEdiText = new AdapterEdiText(setDummyData(), AdiActivity.this);
        recyclerView.setAdapter(adapterEdiText);
        adapterEdiText.setOnCardClickListener(this);

    }

    public List<DataDao> setDummyData(){
        DataDao d1 = new DataDao("tittle 1","descripfion 1",0);
        DataDao d2 = new DataDao("tittle 2","descripfion 2",0);
        DataDao d3 = new DataDao("tittle 3","descripfion 3",0);
        DataDao d4 = new DataDao("tittle 4","descripfion 4",0);
        DataDao d5 = new DataDao("tittle 5","descripfion 5",0);

        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d5);

        return list;
    }

    @Override
    public void OnCardClicked(View view, int position, DataDao data) {
        showDialogEdit();
        rowPositionClick = position;
    }

    public void showDialogEdit(){
        DialogEdit edit = new DialogEdit();
        edit.show(getSupportFragmentManager(),"dialog edit");
    }

    @Override
    public void sendData(DataDao data) {
        adapterEdiText.updateData(rowPositionClick,data);
        adapterEdiText.notifyDataSetChanged();
    }

    public static void startThisActivity(Context context){
        Intent i = new Intent(context,AdiActivity.class);
        context.startActivity(i);
    }
