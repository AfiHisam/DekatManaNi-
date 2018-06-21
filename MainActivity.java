package com.example.afihisam.dekatmanani;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button loc;
    private static final int MY_PERMISSION_REQUEST_LOCATION = 1;
    private static final String TAG = "tag";
    TextView la,lo,addr;

    ProgressDialog pDialog;

    String tag_json_obj = "json_obj_req";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        loc = (Button)findViewById(R.id.location);

        la = (TextView)findViewById(R.id.latitute);
        lo = (TextView)findViewById(R.id.longitute);
        addr = (TextView)findViewById(R.id.address);





        pDialog = new ProgressDialog(this);

        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                    if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION)){
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);

                    } else {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
                    }
                } else {
                    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                    try{

                       // Toast.makeText(MainActivity.this, "Latitute : " + location.getLatitude() + "\n" +
                                //"Longitute :" + location.getLongitude(), Toast.LENGTH_LONG).show();

                        la.setText(Double.toString(location.getLatitude()));
                        lo.setText(Double.toString(location.getLongitude()));



                        String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+location.getLatitude()+","+location.getLongitude()+"&sensor=true&key=YOUR_API_KEY";

                        pDialog.setMessage("Loading...");
                        pDialog.show();


                        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                                url, null,
                                new Response.Listener<JSONObject>() {

                                    @Override
                                    public void onResponse(JSONObject response) {
                                        Log.d(TAG, response.toString());
                                   //     Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_LONG).show();



                                try {
                                 
                                    Toast.makeText(MainActivity.this,"Status : "+response.get("status").toString(),Toast.LENGTH_LONG).show();
                                    addr.setText(response.getJSONArray("results").getJSONObject(1).get("formatted_address").toString());

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                        pDialog.hide();
                                    }
                                }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.d(TAG, "Error: " + error.getMessage());
                                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                                // hide the progress dialog
                                pDialog.hide();
                            }
                        });

// Adding request to request queue
                        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);




                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Not found !", Toast.LENGTH_LONG).show();

                    }
                }

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
