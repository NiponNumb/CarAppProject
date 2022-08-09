package com.niponnumb.lotproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ThreadActivity extends AppCompatActivity {

    boolean bolEmpezar = false;
    int contador = 0;
    TextView txtNumero;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_thread);

        txtNumero = findViewById(R.id.txt_numero);
    }

    public void iniciarHilo(View view){

        bolEmpezar = true;

        new Thread(() -> {
            while (bolEmpezar){
                contador++;
                runOnUiThread(() -> txtNumero.setText(String.valueOf(contador)));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
