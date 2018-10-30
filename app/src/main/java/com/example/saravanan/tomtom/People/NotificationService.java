package com.example.saravanan.tomtom.People;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class NotificationService extends Service {
    Notification.Builder builder;
    NotificationHelper helper;
    Context context = this;
    int count=0,count1=0;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            helper = new NotificationHelper(context);
        }
Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
checkstatus();
handler.postDelayed(this,5000);
            }
        },5000);

        return START_STICKY;
    }

    private void checkstatus() {
        String username=PeopleLogin.username1;
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        String url="http://fundevelopers.website/TomTom/checkstatus.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               // Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
        if(response.contains("0"))
        {
            if(count==0)
            {
                builder = helper.getNotification("your request", "is submitted\nWait for response");
                helper.getManager().notify(1, builder.build());
                startForeground(1, builder.build());
                count1=0;
            count++;
            }
        }
        else
        {
            if(count1==0) {
                builder = helper.getNotification("Dust bin", "is cleaned");
                helper.getManager().notify(1, builder.build());
                startForeground(1, builder.build());
            count1++;
            }
            }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();
                params.put("name",username);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
