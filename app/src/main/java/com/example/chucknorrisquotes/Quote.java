package com.example.chucknorrisquotes;

import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quote {

    @SerializedName("iconUrl")
    private String iconUrl;

    @SerializedName("id")
    private String id;

    @SerializedName("Url")
    private String Url;

    @SerializedName("value")
    private String value;

    private List<Quote> quotes = null;

    public List<Quote> getData() {return quotes;}

    public Quote() {
        this.iconUrl=iconUrl;
        this.id=id;
        this.Url=Url;
        this.value=value;
    }

    public String getIconUrl(){
        return iconUrl;
    }

    public void setIconUrl(String iconUrl){
        this.iconUrl=iconUrl;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getUrl(){
        return Url;
    }

    public void setUrl(String Url){
        this.Url=Url;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value=value;
    }

    @NonNull
    @Override
    public String toString(){return value;}

    /*public void setData(List<Quote> quotes) {
        //clear current quote
        quotes.clear();
        //add quote back
        quotes.addAll(quotes);
        //dataset changed
        notifyDataSetChanged();
    }*/


}
