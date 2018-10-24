package com.miapp.alejandromota.app_spiner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spiner;
    private EditText et1,et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.editText);
        et2=(EditText) findViewById(R.id.editText2);
        tv1=(TextView) findViewById(R.id.textView);
        spiner=(Spinner) findViewById(R.id.spinner);

        String[] opciones= {"SUMA","RESTA","MULTIPLICAR","DIVIDIR"};
        ArrayAdapter <String> arregloAdapter = new ArrayAdapter<>(this,R.layout.spinner_item_drago, opciones);
        spiner.setAdapter(arregloAdapter);
    }

    //Método del boton
    public void calcular(View view){
        String valor1= et1.getText().toString();
        String valor2=et2.getText().toString();

        int valor1_int= Integer.parseInt(valor1);
        int valor2_int=Integer.parseInt(valor2);

        String seleccion= spiner.getSelectedItem().toString();

        if(seleccion.equals("SUMA")){
            int suma= valor1_int+valor2_int;
            String resultado=String.valueOf(suma);
            tv1.setText(resultado);

        }else if(seleccion.equals("RESTA")){
            int resta= valor1_int-valor2_int;
            String resultado=String.valueOf(resta);
            tv1.setText(resultado);

        }else if(seleccion.equals("MULTIPLICAR")){

            int multi= valor1_int*valor2_int;
            String resultado=String.valueOf(multi);
            tv1.setText(resultado);

        }else if(seleccion.equals("DIVIDIR")){

            if(valor2_int==0){
                Toast.makeText(this,"No puedes dividir con 0",Toast.LENGTH_LONG).show();
            }else{
                float divide= valor1_int/valor2_int;
                String resultado=String.valueOf(divide);
                tv1.setText(resultado);
            }


        }


    }
}
