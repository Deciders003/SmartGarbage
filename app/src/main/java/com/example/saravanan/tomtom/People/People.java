package com.example.saravanan.tomtom.People;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.saravanan.tomtom.Interface.NameValue;
import com.example.saravanan.tomtom.MainActivity;
import com.example.saravanan.tomtom.R;
import com.tomtom.online.sdk.map.MarkerBuilder;
import com.tomtom.online.sdk.map.SimpleMarkerBalloon;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class People extends AppCompatActivity {
EditText name,mobileno;
Button getlocation,submit;
 String user=null;
TextView textView;
    Geocoder geocoder;
    List<Address> addresses;
    @Override
    public void onBackPressed() {
       //finishAffinity();
        GetLocation.setlang=0;
        GetLocation.setlat=0;
        Intent intent=new Intent(People.this, MainActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        geocoder = new Geocoder(this, Locale.getDefault());
        textView=findViewById(R.id.textv);
final RequestQueue requestQueue= Volley.newRequestQueue(this);
        name=findViewById(R.id.name);

//location=findViewById(R.id.garloc);
getlocation=findViewById(R.id.getlocbt);
submit=findViewById(R.id.submitbt);
name.setText(PeopleLogin.username1);
if(GetLocation.setlat!=0 && GetLocation.setlang!=0)
{
   // location.setText(GetLocation.setlat+","+GetLocation.setlang);
    try {
        addresses = geocoder.getFromLocation(GetLocation.setlat, GetLocation.setlang, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
        String city = addresses.get(0).getLocality();
        textView.setText(address+"\n"+city);
//basket.markerBalloon(new SimpleMarkerBalloon(address+"\n"+city));
        Log.e("address",address);

    } catch (IOException e) {
        e.printStackTrace();
    }
}


getlocation.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Intent intent=new Intent(People.this,GetLocation.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
startActivity(intent);
    }
});
submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final String name1,mobile,location1;
        name1=name.getText().toString();
      //  location1=location.getText().toString();
       // String[] split=location1.split(",");
        final String lati= String.valueOf(GetLocation.setlat);
        final String lang= String.valueOf(GetLocation.setlang);
        String url="http://fundevelopers.website/TomTom/TomTom.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
           Toast.makeText(People.this,response,Toast.LENGTH_LONG).show();
           Intent intent=new Intent(People.this,NotificationService.class);
           startService(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();
                params.put("name",name1);
                params.put("latitude",lati);
                params.put("longitude",lang);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
});

    }

}
