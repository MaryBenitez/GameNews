package com.example.maris.gamenews.MainActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maris.gamenews.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    TextView content;

    Button iniciar;
    EditText usern;
    EditText passw;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Inicializacion();


        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!usern.getText().toString().equals("") && !passw.getText().toString().equals("")) {

                    try {
                        GetText();
                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(intent);
                    } catch (Exception ex) {
                        Toast.makeText(getApplicationContext(),"ACCESO DENEGADO",Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),"Complete los campos",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void Inicializacion(){
        usern=findViewById(R.id.usuario);
        passw=findViewById(R.id.contraseña);
        iniciar=findViewById(R.id.btniniciar);
    }


    public  void  GetText()  throws UnsupportedEncodingException
    {

        //Obteniedo valores escritos por el usuario
        username = usern.getText().toString();
        password = passw.getText().toString();

        //Creando variables para los valores enviados al servidor
        String data = URLEncoder.encode("name", "UTF-8")
                + "=" + URLEncoder.encode(username, "UTF-8");

        data += "&" + URLEncoder.encode("pass", "UTF-8")
                + "=" + URLEncoder.encode(password, "UTF-8");

        String text = "";
        BufferedReader reader = null;

        //Enviando datos
        try {

            //Definiendo URL donde se enviaran los datos
            URL url = new URL("http://gamenewsuca.herokuapp.com/login");

            //Enviando solicitud de datos POST
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(data);
            writer.flush();

            //Obteniendo respuesta del servidor
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;

            //Leyendo respuesta del servidor
            while((line = reader.readLine()) != null){

                //Anexa la respuesta del servidor en una cadena
                stringBuilder.append(line+"\n");

            }

            text = stringBuilder.toString();
            Log.d("mensaje",text);

        }

        catch (Exception ex){}

        finally {

            try{

                reader.close();

            }

            catch (Exception ex){}

        }

        //Mostrar la respuesta en el Activity
        content.setText( text  );

    }





}
