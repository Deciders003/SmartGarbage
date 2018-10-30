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

public class PeopleLogin extends AppCompatActivity {
    EditText username,password;
    Button register,submit;
    static String username1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_login);
    username=findViewById(R.id.peopleuser);
    password=findViewById(R.id.peoplepass);
    submit=findViewById(R.id.peoplebt);
    register=findViewById(R.id.peoplereg);
    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            username1=username.getText().toString();
            String password1=password.getText().toString();
            if(username1.isEmpty() && password1.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"username and password is required",Toast.LENGTH_SHORT).show();
            }
else {
                RequestQueue requestQueue = Volley.newRequestQueue(PeopleLogin.this);
                String url = "http://fundevelopers.website/TomTom/peoplelog.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                        if (response.contains("LoginSuccessfully")) {
                            Intent intent = new Intent(PeopleLogin.this, People.class);
                            intent.putExtra("user", username1);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Please enter correct username and password", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("username", username1);
                        params.put("password", password1);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
            }
    });
    register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(PeopleLogin.this,PeopleRegister.class);
            startActivity(intent);
        }
    });


    }
}
