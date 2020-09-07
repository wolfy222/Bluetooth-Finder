package com.example.bluetoothfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
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

    // CREATING RECEIVER
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String action = intent.getAction();
            Log.i("Action",action);
            //  AFTER FINISHING SEARCH
            if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action))
            {
                statusTextView.setText("Finished");
                searchButton.setEnabled(true);
            }

        }
    };


    public void searchClicked(View view)
    {
        statusTextView.setText("Searching...");
        searchButton.setEnabled(false);
        bluetoothAdapter.startDiscovery();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        statusTextView = findViewById(R.id.statusTextView);
        searchButton = findViewById(R.id.searchButton);

        // SETTING UP THE BLUETOOTH

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        // IT HELP US FIND WHAT WE ARE LOOKING FOR
        IntentFilter intentFilter = new IntentFilter();
        // FILTERS MESSAGE
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        // REGISTER INTENT FILTER
        registerReceiver(broadcastReceiver, intentFilter);


    }
}
