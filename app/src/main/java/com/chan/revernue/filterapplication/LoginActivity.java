package com.chan.revernue.filterapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private String urlLogin = "http://devtest.boripatp.com/chan01/api/login.php";
    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private String email, password;

    //Ok http3
    private static final OkHttpClient client = new OkHttpClient();
    static String jsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email =edtEmail.getText().toString();
                password = edtPassword.getText().toString();
                if (email.equals("") || password.equals("") ){
                    Toast.makeText(LoginActivity.this, getResources().getString(R.string.email),
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if (email.length() <= 1 || password.length() <= 1) {
                    Toast.makeText(LoginActivity.this, getResources().getString(R.string.password_id), Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    LoginMember(urlLogin, email, password);
                } catch (Exception e) {
                    e.printStackTrace();
                }



//                if (edtEmail.getText().toString().equals("admin") && edtPassword.getText().toString().equals("1234")){
//                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(getApplicationContext(), "No ID and Pass",Toast.LENGTH_LONG).show();
//                }
            }
        });

    }

//    public void onClickbtnRegister(View view) {
//        Button btn_next = (Button)findViewById(R.id.btnRegister);
//        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
//        startActivity(intent);
//    }
    void LoginMember(String urlLogin, String email, String password ) throws IOException{
        FormBody.Builder formbuilder = new FormBody.Builder();
        formbuilder.add("member_email", email);
        formbuilder.add("member_password", password);

        MediaType.parse("application/json; charset=utf-8");
        RequestBody formRequestBody = formbuilder.build();
        Request request = new Request.Builder()
                .url(urlLogin)
                .post(formRequestBody)
                .build();
            client.newCall(request)
                    .enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.i("Result login user", "Fail");


                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            jsonData = response.body().string();
                            Log.i("Result login user", jsonData);


                            Intent intent = new Intent(getApplicationContext(), ListMemberActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);

//                          Toast.makeText(getApplicationContext(), "Welcome to zzService Filter",Toast.LENGTH_LONG).show();
//                          Intent intent = new Intent(LoginActivity.this, ListMemberActivity.class);
//                          startActivity(intent);



                        }
                    });

    }
}
