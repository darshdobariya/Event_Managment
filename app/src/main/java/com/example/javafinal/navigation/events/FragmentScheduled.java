package com.example.javafinal.navigation.events;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javafinal.Pojo.EventDemo;
import com.example.javafinal.R;
import com.example.javafinal.apiinterface.EventInterface;
import com.example.javafinal.retrofit.EventRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FragmentScheduled extends Fragment {
    ImageView btnReminder;
    RecyclerView recyclerView;
    ConstraintLayout emptyScreen;
    public FragmentScheduled() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scheduled, container, false);

        emptyScreen = view.findViewById(R.id.emptyScreen);
        btnReminder = view.findViewById(R.id.btnReminder);
        recyclerView = view.findViewById(R.id.rcEventScheduled);

        btnReminder.setOnClickListener(v ->{
            Intent intent = new Intent(getActivity(), Reminder.class);
            startActivity(intent);
        });
        
        listingData();

        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(lm);

        return view;
    }

    private void listingData() {
        EventInterface eventInterface = EventRetrofit.getRetrofit().create(EventInterface.class);
        Call<EventDemo> eventDemoCall = eventInterface.getData();
        eventDemoCall.enqueue(new Callback<EventDemo>() {
            @Override
            public void onResponse(Call<EventDemo> call, Response<EventDemo> response) {
                if (response.isSuccessful()){
                    FramScheduledAdapter framScheduledAdapter = new FramScheduledAdapter(response.body().getEntries());
                    recyclerView.setAdapter(framScheduledAdapter);

                    emptyScreen.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<EventDemo> call, Throwable t) {

            }
        });
    }

    public class FramScheduledAdapter extends RecyclerView.Adapter<FramScheduledAdapter.myViewHolder> {

        List<EventDemo.Entry> list;

        public FramScheduledAdapter(List<EventDemo.Entry> list){
            this.list = list;
        }

        @NonNull
        @Override
        public FramScheduledAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_events, null);
            FramScheduledAdapter.myViewHolder viewHolder = new FramScheduledAdapter.myViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull FramScheduledAdapter.myViewHolder holder, int position) {
            holder.tvCategory.setText(list.get(position).getCategory());
            holder.tvName.setText(list.get(position).getApi());
            holder.tvDes.setText(list.get(position).getDescription());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class myViewHolder extends RecyclerView.ViewHolder {

            TextView tvName, tvDes, tvCategory;
            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                tvName = itemView.findViewById(R.id.tvUserName);
                tvDes = itemView.findViewById(R.id.tvDescription);
                tvCategory = itemView.findViewById(R.id.tvCategory);
            }
        }
    }
}