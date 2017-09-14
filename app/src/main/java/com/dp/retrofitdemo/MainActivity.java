package com.dp.retrofitdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.dp.pojo.Repo;
import com.dp.services.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by egemenmede on 14/09/2017.
 */

public class MainActivity extends AppCompatActivity {

    RestInterface apiService;
    Context context;
    TextView tvHelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        tvHelloWorld = (TextView) findViewById(R.id.tvHelloWorld);

        /* API SERVICE */
        apiService = API.getClient().create(RestInterface.class);

        Call<List<Repo>> call = apiService.listRepos("egemenmede");
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful()) {
                    Log.d("DEMO_LOG", String.valueOf(response));
                    String result = "";
                    for (Repo responseBlock : response.body()) {
                        result += responseBlock.getName()+"\n";
                        tvHelloWorld.setText(result);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {}
        });
    }
}
