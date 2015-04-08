package com.example.reang.apppro;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Homepage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_homepage, menu);
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


        if(id==R.id.icontodolist){
            Intent i=new Intent(this ,Todolist.class);

            startActivity(i);
        }
//        if(id==R.id.iconmap){
//            Intent i=new Intent(this ,Todolist.class);
//
//            startActivity(i);
//        }
            if(id==R.id.iconmylist){
            Intent i=new Intent(this ,Mylist.class);

            startActivity(i);
        }

        if(id==R.id.BTlogout){
            this.finish();
//              Intent i=new Intent(this ,Sign_up.class);
//
//
        }
        //else if..
    }



}
