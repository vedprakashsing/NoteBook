package io.app.notebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import io.app.notebook.data.AppDatabase;
import io.app.notebook.data.Data;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the database instance and store it in a singleton
        Data.getInstance().db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "notebook-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}