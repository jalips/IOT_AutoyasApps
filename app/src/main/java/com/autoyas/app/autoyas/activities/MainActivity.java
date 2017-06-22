package com.autoyas.app.autoyas.activities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.autoyas.app.autoyas.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //makeDialog();

        //callNetwork();
    }

    private void makeDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hello W");
        builder.setMessage("My Body");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Display some toast
                Toast toast = Toast.makeText(com.autoyas.app.autoyas.activities.MainActivity.this, "Click positiv.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void callNetwork() {
        // V1 without cache
        RequestQueue queue = Volley.newRequestQueue(this);

        // V2 with cache
        /*
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
        Network network = new BasicNetwork(new HurlStack());
        RequestQueue mRequestQueue = new RequestQueue(cache, network);
        mRequestQueue.start();
        */

        StringRequest request = new StringRequest(Request.Method.GET, "http://www.google.fr/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, "Response from API", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error from api", Toast.LENGTH_LONG).show();
                    }
                });

        queue.add(request);
    }


}
