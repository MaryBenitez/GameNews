package com.example.maris.gamenews.MainActivities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maris.gamenews.MainActivities.Data.Model.LoginPOST;
import com.example.maris.gamenews.MainActivities.Data.Remoto.APIServiceGameNews;
import com.example.maris.gamenews.MainActivities.Data.Remoto.APIUtilsGameNews;
import com.example.maris.gamenews.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button iniciar;
    EditText usern;
    EditText passw;

    private APIServiceGameNews APIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Inicializacion();

        APIService = APIUtilsGameNews.getAPIService();

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validación por si el usuario deja algun campo vacio
                if (!usern.getText().toString().equals("") && !passw.getText().toString().equals("")) {

                    String username = usern.getText().toString().trim();
                    String password = passw.getText().toString().trim();

                    //condición donde indica si username y password no estan vacios
                    if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                        //llamando metodo
                        sendPost(username, password);
                        //Si el metodo se envia con exito, entra a la siguiente actividad
                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(intent);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Complete los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void Inicializacion() {
        usern = findViewById(R.id.usuario);
        passw = findViewById(R.id.contraseña);
        iniciar = findViewById(R.id.btniniciar);
    }

    public void sendPost(String user, String pass) {
        APIService.savePost(user, pass).enqueue(new Callback<LoginPOST>() {
            //Metodo que espera como parametros un llamada a la clase LoginPOST y una respuesta de dicha clase
            @Override
            public void onResponse(Call<LoginPOST> call, Response<LoginPOST> response) {
                if(response.isSuccessful()) {
                    //Si la respuesta fue exitosa, se manda a llamar el metodo donde muestra el tccken
                    //y asi poder obtener dicho tocken
                    showResponse(response.body().toString());
                    Log.i("MENSAJE", "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<LoginPOST> call, Throwable t) {
                Log.e("MENSAJE", "Unable to submit post to API.");
            }
        });
    }

    //Metodo que muestra el tocken recibido, si no exite lo pone null
    public void showResponse(String response) {
       Log.d("TOCKEN","Nulo?  "+(response==null));
    }



}