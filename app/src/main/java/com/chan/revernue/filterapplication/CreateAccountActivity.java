package com.chan.revernue.filterapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }
    public void onClickConCreateAccount(View view){
        Button btn_next = (Button)findViewById(R.id.btnConCreateAccount);
        Intent intent = new Intent(CreateAccountActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void onClickimvBack(View view){
        ImageView imageView = (ImageView) findViewById(R.id.imvBack);
        Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
        startActivity(intent);

    }

//    public void onClickimvBack(View view){
//        Button btn_next = (Button)findViewById(R.id.imvBack);
//        Intent intent = new Intent(CreateAccountActivity.this,MainActivity.class);
//        startActivity(intent);
//    }

}
