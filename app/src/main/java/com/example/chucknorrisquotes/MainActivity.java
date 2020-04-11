package com.example.chucknorrisquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String ARG_ITEM_ID = "item_id";

    private Button button;
    private TextView quote;
    private ImageView image;
    private RelativeLayout bgColour;
    private List<Quote> quotes = null;

    public List<Quote> getData() {return quotes;}



    private Quote value;

    String result;

    private String[] colours = {
            "#FFA7A7",
            "#85B67C",
            "#7CB6B5",
            "#807CB6",
            "#7C89B6"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        quote = (TextView) findViewById(R.id.textView2);

        bgColour= (RelativeLayout) findViewById(R.id.bgColour);

        //Create retrofit in the Main Activity
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Get the api here with the following
        QuoteService service = retrofit.create(QuoteService.class);
        Call<Quote> quoteCall = service.getAllQuotes();

        quoteCall.enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
               //List<Quote> quotes = response.body().getData();

               //Specific quote

              //  updateUi();
               // MainActivity.this.getCallingActivity();

                result =  response.body().toString();

            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {

            }
        });


        //button to call the quotes
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //display joke
                quote.setText(result);

                updateUi();

                //refresh API
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.chucknorris.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                //Get the api here with the following
                QuoteService service = retrofit.create(QuoteService.class);
                Call<Quote> quoteCall = service.getAllQuotes();

                quoteCall.enqueue(new Callback<Quote>() {
                    @Override
                    public void onResponse(Call<Quote> call, Response<Quote> response) {
                        //List<Quote> quotes = response.body().getData();

                        //Specific quote


                        // MainActivity.this.getCallingActivity();

                        result =  response.body().toString();

                    }

                    @Override
                    public void onFailure(Call<Quote> call, Throwable t) {

                    }
                });



                //change colour per click
                Random randomColour = new Random();
                int randomColourNum = randomColour.nextInt(colours.length);
                int colour = Color.parseColor(colours[randomColourNum]);

                bgColour.setBackgroundColor(colour);





            }
        });




    }

    private void updateUi() {

        if(value !=null) {
            ((TextView) findViewById(R.id.textView2)).setText(value.getValue());
        }

    }
}


