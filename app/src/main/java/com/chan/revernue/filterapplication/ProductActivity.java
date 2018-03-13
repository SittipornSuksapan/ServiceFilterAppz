package com.chan.revernue.filterapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }
    public void onClickbtnProduct(View view){
        Button btn_next = (Button)findViewById(R.id.btnProduct);
        Intent intent = new Intent(ProductActivity.this,EquipmentActivity.class);
        startActivity(intent);
    }
}
