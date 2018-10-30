package com.example.saravanan.tomtom.People;

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

import java.util.HashMap;
import java.util.Map;

public class PeopleRegister extends AppCompatActivity {
EditText username,password,mobile;
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_register);
    username=findViewById(R.id.peopleregusername);
    password=findViewById(R.id.peopleregpass);
    mobile=findViewById(R.id.peopleregmob);
    bt=findViewById(R.id.peopleregbt);
    bt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username1=username.getText().toString();
            String password1=password.getText().toString();
            String mobile1=mobile.getText().toString();
            String url="http://fundevelopers.website/TomTom/peoplereg.php";
            RequestQueue requestQueue= Volley.newRequestQueue(PeopleRegister.this);
            StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                    if(response.contains("Registered successfully"))
                    {
                        Intent intent=new Intent(PeopleRegister.this,PeopleLogin.class);
                        startActivity(intent);
                    }
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
                    params.put("mobile_no",mobile1);
                    return params;
                }
            };
            requestQueue.add(stringRequest);
        }
    });
    }
}
