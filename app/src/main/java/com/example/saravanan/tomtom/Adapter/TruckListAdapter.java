package com.example.saravanan.tomtom.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.saravanan.tomtom.Interface.NameValue;
import com.example.saravanan.tomtom.R;
import com.example.saravanan.tomtom.Track;
import com.example.saravanan.tomtom.Truck.TruckList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TruckListAdapter extends RecyclerView.Adapter<TruckListAdapter.ViewHolder> {
Track track;
NameValue nameValue;

    public TruckListAdapter(List<TruckList> list) {
        this.list = list;
    }
    public void setTrack(Track t)
    {
        this.track=t;
    }
    public void setvalue(NameValue nameValue)
    {
        this.nameValue=nameValue;
    }

    public List<TruckList> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.truck_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
TruckList truckList=list.get(i);
viewHolder.head.setText(truckList.getHead());
viewHolder.body.setText(truckList.getBody());
    viewHolder.bt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(track !=null)
            {
             String name=viewHolder.head.getText().toString();
                track.track(name);
            }
        }
    });
    viewHolder.bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username=viewHolder.head.getText().toString();
            if(nameValue!=null)
            {
                nameValue.notifyme(username);
            }


        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView head,body;
Button bt,bt1;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            head=itemView.findViewById(R.id.headname);
            body=itemView.findViewById(R.id.bodymobile);
bt=itemView.findViewById(R.id.trackbt);
     bt1=itemView.findViewById(R.id.notify);
        }
    }
}
