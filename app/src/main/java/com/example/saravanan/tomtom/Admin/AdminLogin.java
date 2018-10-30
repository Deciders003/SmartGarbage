package com.example.saravanan.tomtom.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.saravanan.tomtom.R;

public class AdminLogin extends AppCompatActivity {
EditText et1,et2;
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        et1=findViewById(R.id.id);
        et2=findViewById(R.id.pass);
        bt=findViewById(R.id.submit);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=et1.getText().toString();
                String password=et2.getText().toString();
                if(username.isEmpty() && password.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"username and password is required",Toast.LENGTH_SHORT).show();
                }

                else if(username.equals("admin") && password.equals("login"))
                {
                    Intent intent=new Intent(AdminLogin.this,Admin.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"please enter correct username and password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
