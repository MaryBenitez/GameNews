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

import com.example.maris.gamenews.MainActivities.Data.Model.Request;
import com.example.maris.gamenews.MainActivities.Data.Remote.APIServiceGameNews;
import com.example.maris.gamenews.MainActivities.Data.Remote.APIUtilsGameNews;
import com.example.maris.gamenews.R;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    Button iniciar;
    EditText usern;
    EditText passw;

    private APIServiceGameNews APIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Inicializacion();

        final EditText usern = (EditText) findViewById(R.id.usuario);
        final EditText passw = (EditText) findViewById(R.id.contraseña);
        iniciar = findViewById(R.id.btniniciar);

        APIService = APIUtilsGameNews.getAPIService();

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validación por si el usuario deja algun campo vacio
                    //String username = usern.getText().toString().trim();
                    //String password = passw.getText().toString().trim();

                String title = usern.getText().toString().trim();
                String body = passw.getText().toString().trim();

                    //condición donde indica si username y password no estan vacios

                    if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                        //llamando metodo
                        sendPost(title, body);
                        //Si el metodo se envia con exito, entra a la siguiente actividad
                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(intent);
                    }

                else {
                    Toast.makeText(getApplicationContext(), "Complete los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void Inicializacion() {
       final EditText usern = findViewById(R.id.usuario);
        final EditText passw = findViewById(R.id.contraseña);
        iniciar = findViewById(R.id.btniniciar);
    }

    /*public void sendPost(String user, String pass) {
        APIService.savePost(user, pass).enqueue(new Callback<Request>() {
            //Metodo que espera como parametros un llamada a la clase Request y una respuesta de dicha clase
            @Override
            public void onResponse(Call<Request> call, Response<Request> response) {
                if(response.isSuccessful()) {
                    //Si la respuesta fue exitosa, se manda a llamar el metodo donde muestra el tccken
                    //y asi poder obtener dicho tocken
                    showResponse(response.body().toString());
                    Log.i("MENSAJE", "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Request> call, Throwable t) {
                Log.e("MENSAJE", "Unable to submit post to API.");
            }
        });
    }*/


    public void sendPost(final String title, final String body) {
        APIService.savePost(title, body).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Request>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Tag",body);
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Request post) {
                        Log.d("token: ",post.getToken());
                        NavegationD(post.getToken());
                    }
                });

    }


    public void NavegationD(String token){
        //Intent intent =new Intent(this, MainActivity2.class);
        //intent.putExtra("TOKEN_ID",token);
        Log.d("SI OBTIENE TOKEN",token);
        //startActivity(intent);
    }



    //Metodo que muestra el tocken recibido, si no exite lo pone null
    public void showResponse(String response) {
       Log.d("TOCKEN","Nulo?  "+(response==null));
    }



}