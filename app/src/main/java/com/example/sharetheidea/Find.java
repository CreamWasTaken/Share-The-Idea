package com.example.sharetheidea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Find extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);


        final ListView lvFind =(ListView)findViewById(R.id.lvv);

        ArrayList<String> TNames = new ArrayList<>();

        TNames.add("Mark Anthony Agudo");
        TNames.add("Carlo Jay Tana");
        TNames.add("Raphael Magsino");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,TNames);
        lvFind.setAdapter(adapter);

        lvFind.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder BobTheBuilder = new AlertDialog.Builder(Find.this);
                BobTheBuilder.setCancelable(true);
                BobTheBuilder.setTitle("Mark Anthony Agudo: Rating: 4.5");
                BobTheBuilder.setMessage("i can Teach Java and Basic android");

                BobTheBuilder.setPositiveButton("Message", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                BobTheBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                BobTheBuilder.show();
            }
        });


    }
}
