package com.chan.revernue.filterapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class EquipmentActivity extends AppCompatActivity {

    private EditText txtEquipmentEditText, edtEenerationEditText, edtSizeEditText, edtCategoryEditText;
    private String edtEenerationString;
    private String txtEquipmentString;
    private String edtSizeEditTextString;
    private String edtCategoryEditTextString;
    private String[] loginStrings;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);

        initialView();
        saveController();
        uploadValueToServer();
//        getValueFromIntent();

//        saveController();
    }
//    private void getValueFromIntent() {
//        loginStrings = getIntent().getStringArrayExtra("Login");
//    }
    private void initialView() {
        txtEquipmentEditText = (EditText) findViewById(R.id.txtEquipment);
        edtEenerationEditText = (EditText) findViewById(R.id.edtGeneration);
        edtSizeEditText = (EditText) findViewById(R.id.edtSize);
        edtCategoryEditText = (EditText) findViewById(R.id.edtCategory);

    }

    public void saveController() {

        //get value from edit text
        txtEquipmentString = txtEquipmentEditText.getText().toString().trim();
        edtEenerationString = edtEenerationEditText.getText().toString().trim();
        edtSizeEditTextString = edtEenerationEditText.getText().toString().trim();
        edtCategoryEditTextString = edtEenerationEditText.getText().toString().trim();

        //check space
        if (txtEquipmentString.equals("") || edtEenerationString.equals("")) {
            //have space
            MyAlert myAlert = new MyAlert(EquipmentActivity.this);

            myAlert.myDialog("Have space", "Please fill all");

        } else {
            //no space
            uploadValueToServer();
            Intent intent = new Intent(EquipmentActivity.this, HomeActivity.class);
            intent.putExtra("Login", loginStrings);
            startActivity(intent);
            finish();

        }



    }

    private void uploadValueToServer() {


        String tag = "12JulyV1";
        Log.d(tag, "Code ==>" + txtEquipmentString);
        Log.d(tag, "Name ==>" + edtEenerationString);
        Log.d(tag, "Gender ==>" + edtSizeEditTextString);
        Log.d(tag, "ID_parent ==>" + edtCategoryEditTextString);

        try {

            PostChildToServer postChildToServer = new PostChildToServer(EquipmentActivity.this);
            postChildToServer.execute(txtEquipmentString,edtEenerationString,edtSizeEditTextString,edtCategoryEditTextString);
            String strResult = postChildToServer.get();
            Log.d(tag, "Result ==>" + strResult);

            if (Boolean.parseBoolean(strResult)) {
                finish();
            } else {
                Toast.makeText(EquipmentActivity.this,"Error Please Try Again",
                        Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {

            Log.d(tag, "e upload ==>" + e.toString());
        }


    }

    public void setLoginStrings(String[] loginStrings) {
        this.loginStrings = loginStrings;
    }

//
//    private void uploadValueToServer() {
//    }

//
//    public void onClickbtnEquipment(View view){
//        Button btn_next = (Button)findViewById(R.id.btnEquipment);
//        Intent intent = new Intent(EquipmentActivity.this,HomeActivity.class);
//        startActivity(intent);
//    }



}
