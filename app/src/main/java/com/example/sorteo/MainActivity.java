package com.example.sorteo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private EditText editTextNumber, Nombre;
    private TextView textViewRes;

    int a[] = new int[100];
    String noms[] = new String[100];
    Random rd = new Random();
    String Nom = "", sAux = "";
    int Num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = (EditText)findViewById (R.id.editTextNumber);
        Nombre = (EditText)findViewById (R.id.Nombre);
        textViewRes = (TextView)findViewById (R.id.textViewRes);
        arrNums();
    }

    private void arrNums ()
    {
        for(int i = 0 ; i < a.length; i++)
        {
            a[i] = i + 1;
        }
    }

    public void guar (View view)
    {
        String geted = editTextNumber.getText().toString();
        Nom = Nombre.getText().toString();

        if (geted == null)
        {
            Num = 0;
        }
        else
        {
            Num = Integer.parseInt(geted);
        }

        if(Num <= 0 || Num > 100)
        {
            Toast.makeText(getApplicationContext(),"Solo numeros del 1 al 100",Toast.LENGTH_SHORT).show();
        }
        else
        {
            for(int i = 0 ; i < a.length; i++)
            {
                if(a[i]== Num)
                {
                    if(noms[i]==null)
                    {
                        noms[i] = Nom;
                        sAux = "guardado: " + Nom + " con el numero: " + Num;
                        textViewRes.setText(sAux);
                        Toast.makeText(getApplicationContext(),"Elemento Guardado",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        sAux = "numero ya usado por: " + noms[i];
                        textViewRes.setText(sAux);
                        Toast.makeText(getApplicationContext(),"numero ya usado",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

    }

    public void ver (View view)
    {
        sAux = "los participantes son; \n";

        for (int i = 0; i < a.length; i++)
        {
            if(noms[i]!=null)
            {
                sAux += a[i] + " : " + noms[i] + "\n";
                Toast.makeText(getApplicationContext(),"Mostrando numeros y participantes",Toast.LENGTH_SHORT).show();
            }
        }

        textViewRes.setText(sAux);

    }

    public void sortear (View view)
    {
        sAux = "El ganador es: \n";
        int Aleatorio = rd.nextInt(100);

        if (noms[Aleatorio]!=null)
        {
            sAux += "El numero: " + a[Aleatorio] + " Seleccionado por: " + noms[Aleatorio];
            Toast.makeText(getApplicationContext(),"Ganador!!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            sAux = "El numero: " + a[Aleatorio]+ " No fue escogido por nadie \n intente otra vez";
            Toast.makeText(getApplicationContext(),"Intente de nuevo",Toast.LENGTH_SHORT).show();
        }

        textViewRes.setText(sAux);

    }

    public void editar (View view)
    {
        int j = 0;
        String geted = editTextNumber.getText().toString();
        if (geted == null)
        {
            j = 0;
        }
        else
        {
            j = Integer.parseInt(geted);
        }

        String nuevo = Nombre.getText().toString();


        if(j <= 0 || j > 100)
        {
            Toast.makeText(getApplicationContext(),"Solo numeros del 1 al 100",Toast.LENGTH_SHORT).show();
        }
        else
        {
            sAux = "Nombre anterior en el numero: " + j + " Era " + noms[j-1]+ "\n \n";
            noms[j-1] = nuevo;
            sAux += "Ahora " + noms[j-1] + " tiene el numero : " + j;
            textViewRes.setText(sAux);
            Toast.makeText(getApplicationContext(),"Cambio realizado",Toast.LENGTH_SHORT).show();
        }

    }

}