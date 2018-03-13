package com.chan.revernue.filterapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
    }
    public void onClickcustomer(View view){
        Button btn_next = (Button)findViewById(R.id.btncustomer);
        Intent intent = new Intent(CustomerActivity.this,ProductActivity.class);
        startActivity(intent);
    }
}
