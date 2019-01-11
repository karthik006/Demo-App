package com.example.karthik.demoapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewOne;
    RecyclerView recyclerViewTwo;
    DataAdapter dataAdapterOne;
    DataAdapter dataAdapterTwo;
    List<Movies> dataOne;
    List<Movies> dataTwo;
    int selectedPosition = -1;

    FloatingActionButton FAB1, FAB2, FAB3;

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

        FAB1 = findViewById(R.id.viewFAB);
        FAB2 = findViewById(R.id.backFAB);
        FAB3 = findViewById(R.id.nextFAB);

        FAB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Video Library", Toast.LENGTH_SHORT).show();
            }
        });

        FAB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Back", Toast.LENGTH_SHORT).show();
            }
        });

        FAB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "New Activity", Toast.LENGTH_SHORT).show();
            }
        });
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
            View view = inflater.inflate(R.layout.horizontal_list, parent, false);
            DataAdapter.mViewHolder holder = new DataAdapter.mViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull DataAdapter.mViewHolder holder, final int position) {
            final Movies current = data.get(position);
            holder.listImage.setImageResource(current.resID);
            holder.listText.setText(current.movieName);

            if(selectedPosition == position)
                holder.itemView.setBackgroundColor(Color.parseColor("#D4D7F2"));
            else
                holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), current.movieName, Toast.LENGTH_SHORT).show();
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPosition = position;
                    notifyDataSetChanged();
                    return true;
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class mViewHolder extends RecyclerView.ViewHolder {
            ImageView listImage;
            TextView listText;

            public mViewHolder(View itemView) {
                super(itemView);
                listImage = itemView.findViewById(R.id.imageViewList);
                listText = itemView.findViewById(R.id.textViewList);
            }
        }
    }

    public class Movies {
        private int resID;
        private String movieName;

        Movies(int resID, String movieName)
        {
            this.resID = resID;
            this.movieName = movieName;
        }
    }

    public List<Movies> getListOne()
    {
        dataOne = new ArrayList<>();

        Movies movies;

        movies = new Movies(R.drawable.interstellar, "Interstellar");
        dataOne.add(movies);

        movies = new Movies(R.drawable.godfather, "Godfather");
        dataOne.add(movies);

        movies = new Movies(R.drawable.rosemarys_baby, "Rosemary's Baby");
        dataOne.add(movies);

        movies = new Movies(R.drawable.ib, "Inglourious Basterds");
        dataOne.add(movies);

        movies = new Movies(R.drawable.lobster, "Lobster");
        dataOne.add(movies);

        return dataOne;
    }

    public List<Movies> getListTwo()
    {
        dataTwo = new ArrayList<>();

        Movies movies;

        movies = new Movies(R.drawable.shawshank, "Shawshank Redemption");
        dataTwo.add(movies);

        movies = new Movies(R.drawable.annihilation, "Annihilation");
        dataTwo.add(movies);

        movies = new Movies(R.drawable.twelve_angry_men, "12 Angry Men");
        dataTwo.add(movies);

        return  dataTwo;
    }
}
