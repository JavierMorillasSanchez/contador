package com.javierms.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Dentro de la public class hago una variable
    // que va a ser donde almacene mi numero
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    };

        // en el codigo, en parametros, hay que poner View
        // porque lo que estas haciendo es usar una vista
        public void aumentar(View view){
            if(contador <999){
                contador++;
                mostrarContador();
                playSonido(R.raw.clic);
            }else {
                mostrarContador();
            };
        };

        public void reducir(View view){
            if(contador >0) {
                contador--;
                mostrarContador();
                playSonido(R.raw.tic);
            }else{
                mostrarContador();
            }
        };

        public void reiniciar(View view){
            contador=0;
            mostrarContador();
        };

        public void mostrarContador(){
            TextView contadorplus=findViewById(R.id.contador);
            if(contador <10) {
                String contadorString = "00" + contador;
                contadorplus.setText(contadorString);
            } else if (contador <100){
                String contadorString = "0" + contador;
                contadorplus.setText(contadorString);
            } else{
                String contadorString = "" + contador;
                contadorplus.setText(contadorString);
            }
        };

            public void playSonido( int sound){
                MediaPlayer mp;
                mp = MediaPlayer.create(getApplicationContext(), sound);
                mp.start();

            };

            public void copyText (View view){
                TextView txtcontador = findViewById(R.id.contador);
                String valorContador = txtcontador.getText().toString();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text", valorContador);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Contador copiado al portapapeles", Toast.LENGTH_SHORT).show();

            };
    }




