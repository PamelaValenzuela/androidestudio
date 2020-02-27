package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.api.Api;
import com.example.myapplication.api.RetrofitClient;
import com.example.myapplication.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
 private TextView question, category, difficult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        Api api = RetrofitClient.getRetrofit()
                .create(Api.class);

        Call<RespuestaApi> call=api.getQuestion();
        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                question.setText(response.body().getResults().get(0).getQuestion());
                category.setText(response.body().getResults().get(0).getCategory());
                difficult.setText(response.body().getResults().get(0).getDifficulty());

            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                Log.e("error",t.toString());
            }
        });
    }
    private void initializeViews(){
        question =findViewById(R.id.question);
        category = findViewById(R.id.category);
        difficult =findViewById(R.id.difficult);
    }
}
