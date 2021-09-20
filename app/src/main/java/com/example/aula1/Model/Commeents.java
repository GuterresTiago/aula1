package com.example.aula1.Model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Commeents implements Parcelable {
    private int post_id;
    private String name;
    private String body;

    public Commeents(int post_id, String name, String body) {
        this.post_id = post_id;
        this.name = name;
        this.body = body;
    }
    public int getPost_id() {
        return post_id;
    }

    public String getBody() {
        return body;
    }





    public Commeents(JSONObject json){
        super();
        try{
            this.post_id= json.getInt("id");
            this.name= json.optString("name");
            this.body= json.getString("body");

        }catch (JSONException e){ e.printStackTrace();}
    }
    protected Commeents(Parcel in) {
        post_id=in.readInt();
        name=in.readString();
        body=in.readString();
    }
    public static final Creator<Commeents> CREATOR = new Creator<Commeents>() {
        @Override
        public Commeents createFromParcel(Parcel in) {
            return new Commeents(in);
        }

        @Override
        public Commeents[] newArray(int size) {
            return new Commeents[size];
        }
    };


    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setBody(String body) {
        this.body = body;
    }

    public static Creator<Commeents> getCREATOR() {
        return CREATOR;
    }



    public String toString() {
        return "id: "+post_id+"\n"+
                "Nome: "+name+"\n"+
                "Username: " + body+"\n---------\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commeents commeents = (Commeents) o;
        return post_id == commeents.post_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(post_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.post_id);
        parcel.writeString(this.name);
        parcel.writeString(this.body);
    }
}
