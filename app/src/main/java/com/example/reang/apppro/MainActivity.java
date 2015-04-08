package com.example.reang.apppro;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity implements  Runnable{


    ArrayList<Map<String, String>> data;
    SimpleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<Map<String, String>>();
        adapter = new SimpleAdapter(this,
                data,
                android.R.layout.simple_list_item_2,
                new String[] {"username", "password"},
                new int[] {android.R.id.text1, android.R.id.text2});
        ListView l = (ListView)findViewById(R.id.listtest);
        l.setAdapter(adapter);
        LoginTask task = new LoginTask();
        task.execute();


    }

    @Override
    protected void onResume() {
        super.onResume();
        //LoginTask w = new LoginTask();
        //w.execute("https://ict.siit.tu.ac.th/~u5522791086/login.json", " LOGIN");
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

     public void buttonClicked(View v){
        int id=v.getId();
        TextView Textname;
        if(id==R.id.BTjoin) //change button name
        {
//            if()

            Intent i=new Intent(this ,Homepage.class);

            startActivity(i);

        }
         if(id==R.id.TextCreateAcc){
             Intent i=new Intent(this ,Sign_up.class);

             startActivity(i);
         }
        //else if..
    }

    @Override
    public void run() {

    }

    class LoginTask extends AsyncTask<String,Void,Boolean>
    {
        String errorMsg = "";


        String username,password;

      @Override
        protected Boolean doInBackground(String... params) {
            BufferedReader reader;
            StringBuilder buffer = new StringBuilder();
            String line;
            try {
                //  title = params[1];
                URL u = new URL("http://ict.siit.tu.ac.th/~u5522791086/login.json");
                HttpURLConnection h = (HttpURLConnection)u.openConnection();
                h.setRequestMethod("GET");
                h.setDoInput(true);
                h.connect();

                int response = h.getResponseCode();
                if (response == 200) {
                    reader = new BufferedReader(new InputStreamReader(h.getInputStream()));
                    while((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }
                    //Start parsing JSON

                    JSONObject jlogin = new JSONObject(buffer.toString());
                    JSONArray juser = jlogin.getJSONArray("login");

                    for(int i=0;i<juser.length();i++ ) {
                        username = juser.getJSONObject(i).getString("username");
                        password = juser.getJSONObject(i).getString("password");





                    Map<String, String> item = new HashMap<String, String>();
                    item.put("username", username);
                    item.put("password", password);
                    data.add(0, item);

                }

                    errorMsg = "";
                    return true;
                }
                else {
                    errorMsg = "HTTP Error";
                }
            } catch (MalformedURLException e) {
                Log.e("WeatherTask", "URL Error");
                errorMsg = "URL Error";
            } catch (IOException e) {
                Log.e("WeatherTask", "I/O Error");
                errorMsg = "I/O Error";
            } catch (JSONException e) {
                Log.e("WeatherTask", "JSON Error");
                errorMsg = "JSON Error";
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean result) {
//                    //  TextView tvTitle, tvWeather, tvWind,tvHumid,tvTemp;
            ListView listtest;
//            if (pDialog.isShowing()) {
//                pDialog.dismiss();
//            }
//            ListView l = (ListView)findViewById(R.id.listView);
//
//            listView = (ListView) findViewById(R.id.listView);
//          //  tvWeather = (TextView)findViewById(R.id.tvWeather);
         //   ListView l = (ListView) findViewById(R.id.listtest);
         //   l.setAdapter(adapter);
//
         //   if (result) {
//                listView.setText(listView);
//            Map<String, String> item = new HashMap<String, String>();
//            item.put("username", username);
//            item.put("password", password);
//            data.add(0, item);
//
//            }
                //listtest.setText(adapter);


          //  }
        }
    }


}
