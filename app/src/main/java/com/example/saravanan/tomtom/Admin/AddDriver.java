package com.example.saravanan.tomtom.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.saravanan.tomtom.R;
import com.google.common.net.InternetDomainName;

import java.util.HashMap;
import java.util.Map;

public class AddDriver extends AppCompatActivity {
EditText username,password,mobilno,license;
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);
username=findViewById(R.id.driverusername);
password=findViewById(R.id.driverpass);
mobilno=findViewById(R.id.drivermobileno);
license=findViewById(R.id.driverlicense);
bt=findViewById(R.id.driversub);
bt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
String username1,password1,mobileno1,license1;
username1=username.getText().toString();
password1=password.getText().toString();
mobileno1=mobilno.getText().toString();
license1=license.getText().toString();
String url="http://fundevelopers.website/TomTom/driverregister.php";
        RequestQueue requestQueue= Volley.newRequestQueue(AddDriver.this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AddDriver.this,response,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(AddDriver.this,Admin.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();
                params.put("username",username1);
                params.put("password",password1);
                params.put("mobile_no",mobileno1);
                params.put("license_id",license1);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
});
    }
}
