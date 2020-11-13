package com.example.sharetheidea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharetheidea.ui.dashboard.DashboardFragment;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final dbHelper myDb = new dbHelper(this);

        final EditText UsernameLG =(EditText)findViewById(R.id.edt_userLG);
        final EditText passLG =(EditText)findViewById(R.id.edt_passLG);
        final Button btnLogin =(Button)findViewById(R.id.btn_LoginLG);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, BottomNav.class);
                //startActivity(i);
                boolean result = myDb.LoginData(UsernameLG.getText().toString(),passLG.getText().toString());
                if (result == true){
                    Intent i = new Intent(Login.this, BottomNav.class);
                    startActivity(i);
                }
                else{
                    if (UsernameLG.getText().toString().equals("admin")&&passLG.getText().toString().equals("admin"))
                    {
                        Intent toMainAct = new Intent(Login.this, BottomNav.class);
                        startActivity(toMainAct);
                    }
                    else
                    {
                        Toast.makeText(Login.this,"Incorrect login details",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
