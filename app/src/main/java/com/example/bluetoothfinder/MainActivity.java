package com.example.bluetoothfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    ListView listView;
    TextView statusTextView;
    Button searchButton;
    // POWER EVERYTHING IN BLUETOOTH
    BluetoothAdapter bluetoothAdapter;


    public void searchClicked(View view)
    {
        statusTextView.setText("Searching...");
        searchButton.setEnabled(false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        statusTextView = findViewById(R.id.statusTextView);
        searchButton = findViewById(R.id.searchButton);
    }
}
