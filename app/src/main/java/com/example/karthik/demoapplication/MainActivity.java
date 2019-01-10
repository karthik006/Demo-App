package com.example.karthik.demoapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewOne;
    RecyclerView recyclerViewTwo;
    DataAdapter dataAdapterOne;
    DataAdapter dataAdapterTwo;
    List<Movies> dataOne;
    List<Movies> dataTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewOne = findViewById(R.id.recyclerViewOne);
        recyclerViewTwo = findViewById(R.id.recyclerViewTwo);

        dataAdapterOne = new DataAdapter(this, getListOne());
        dataAdapterTwo = new DataAdapter(this, getListTwo());

        recyclerViewOne.setAdapter(dataAdapterOne);
        recyclerViewTwo.setAdapter(dataAdapterTwo);
        recyclerViewOne.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerViewTwo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
    }

    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.mViewHolder> {
        private LayoutInflater inflater;
        List<Movies> data;

        public DataAdapter(Context context, List<Movies> data)
        {
            inflater = LayoutInflater.from(context);
            this.data = data;
        }

        @NonNull
        @Override
        public DataAdapter.mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull DataAdapter.mViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class mViewHolder extends RecyclerView.ViewHolder {

            public mViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

    public class Movies {

    }

    public List<Movies> getListOne()
    {
        dataOne = new ArrayList<>();

        return dataOne;
    }

    public List<Movies> getListTwo()
    {
        dataTwo = new ArrayList<>();

        return  dataTwo;
    }
}
