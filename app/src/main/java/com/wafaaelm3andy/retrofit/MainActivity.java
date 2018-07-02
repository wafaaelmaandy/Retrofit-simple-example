package com.wafaaelm3andy.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
TextView result ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result =(TextView)findViewById(R.id.result);

    }

    public void open(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ServiceInterface.baseURL)
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build() ;
        ServiceInterface serviceInterface = retrofit.create(ServiceInterface.class);
        serviceInterface.methed().enqueue(new Callback<ArrayList<Response>>() {
            @Override
            public void onResponse(Call<ArrayList<Response>> call, retrofit2.Response<ArrayList<Response>> response) {
result.setText(response.body().get(0).getFullName().toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Response>> call, Throwable t) {
                result.setText("failed to load");

            }




        });
    }
}
