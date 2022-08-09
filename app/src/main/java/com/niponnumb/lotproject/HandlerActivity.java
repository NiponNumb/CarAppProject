package com.niponnumb.lotproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class HandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_handler);

    }

    public void iniciarHandler(View view) {

        Handler mHandler = new Handler(){

            @Override
            public void handleMessage(@NonNull Message msg) {
                Bundle datos = msg.getData();
                Toast.makeText(HandlerActivity.this, datos.getString("key_msg"), Toast.LENGTH_LONG)
                        .show();
            }
        };

        Message msg = new Message();
        Bundle datos = new Bundle();
        datos.putString("key_msg", "Hola Alex");
        msg.setData(datos);
        mHandler.sendMessage(msg);
    }
}
