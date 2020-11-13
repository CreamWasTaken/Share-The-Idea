package com.example.sharetheidea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Teach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach);

        EditText desc =(EditText)findViewById(R.id.edt_desc);
        Button reg = (Button)findViewById(R.id.btn_register);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Teach.this,"Registered",Toast.LENGTH_LONG).show();
            }
        });
    }
}
