package com.example.sharetheidea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_Up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        final dbHelper myDb = new dbHelper(this);

        final EditText UsernameSU = (EditText)findViewById(R.id.edt_userSU);
        final EditText nameSU = (EditText)findViewById(R.id.edt_nameSU);
        final EditText PassSU = (EditText)findViewById(R.id.edt_passSU);
        final EditText CfPassSU = (EditText)findViewById(R.id.edt_cfpassSU);
        Button btnSU = (Button)findViewById(R.id.btn_SU);

        btnSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nameSU.getText().toString().equals("") || UsernameSU.getText().toString().equals("") || CfPassSU.getText().toString().equals("") || PassSU.getText().toString().equals("")){  //PassSU.getText().toString().equals(CfPassSU.getText().toString()
                    Toast.makeText(Sign_Up.this,"Details can't be Empty",Toast.LENGTH_LONG).show();
                }
                else if (PassSU.getText().toString().equals(CfPassSU.getText().toString())){

                    boolean result = myDb.InsertData(UsernameSU.getText().toString(),CfPassSU.getText().toString(),nameSU.getText().toString());
                    if (result == true){
                        Toast.makeText(Sign_Up.this,"Account Created",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(Sign_Up.this,"Account not Created(Error in Code)",Toast.LENGTH_LONG).show();
                    }

                }
                else{

                    Toast.makeText(Sign_Up.this,"Please Check the Details",Toast.LENGTH_LONG).show();
                }

        //myDb.InsertData(UsernameSU.getText().toString(),PassSU.getText().toString(),nameSU.getText().toString())
            }
        });
    }
}
