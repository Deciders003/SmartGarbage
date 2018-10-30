package com.example.saravanan.tomtom.Truck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class TruckLogin extends AppCompatActivity {
EditText username,password;
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_login);
        username=findViewById(R.id.truckuser);
        password=findViewById(R.id.truckpass);
        bt=findViewById(R.id.truckbt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1=username.getText().toString();
                String password1=password.getText().toString();
Log.e("usern",username1);
                if(username1.isEmpty() && password1.isEmpty())
                {
                 Toast.makeText(getApplicationContext(),"username and password is required",Toast.LENGTH_SHORT).show();
                }
               else {
                    RequestQueue requestQueue = Volley.newRequestQueue(TruckLogin.this);
                    requestQueue.getCache().clear();
                    String url = "http://fundevelopers.website/TomTom/driverlogin.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.contains("LoginSuccessfully")) {
                                Intent intent = new Intent(TruckLogin.this, GetRequest.class);
                                startActivity(intent);
                 username.setText("");
                 password.setText("");
                            } else {
                                Toast.makeText(getApplicationContext(), "Please enter the correct details", Toast.LENGTH_SHORT).show();
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
    }
}
