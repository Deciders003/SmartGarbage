package com.example.saravanan.tomtom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.saravanan.tomtom.Admin.AdminLogin;
import com.example.saravanan.tomtom.People.People;
import com.example.saravanan.tomtom.People.PeopleLogin;
import com.example.saravanan.tomtom.Truck.TruckLogin;

public class MainActivity extends AppCompatActivity{
    Button bt1,bt2,bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    bt1=findViewById(R.id.people);
    bt2=findViewById(R.id.truck);
    bt3=findViewById(R.id.admin);
ImageView imageView=findViewById(R.id.imageView3);
        final ImageView imageView1 = findViewById(R.id.carmain2);
        final ImageView imageView2 = findViewById(R.id.carmain1);
        final ImageView imageView3 = findViewById(R.id.carmain);
    bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageView3.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.INVISIBLE);
            Intent intent=new Intent(MainActivity.this, PeopleLogin.class);
        startActivity(intent);

        }
    });
    bt2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageView3.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.INVISIBLE);
            Intent intent=new Intent(MainActivity.this, TruckLogin.class);
            startActivity(intent);
        }
    });
    bt3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageView3.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.INVISIBLE);
            Intent intent=new Intent(MainActivity.this, AdminLogin.class);
            startActivity(intent);
        }
    });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}