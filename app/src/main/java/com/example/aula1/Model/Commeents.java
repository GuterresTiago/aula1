package com.example.aula1.Model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Commeents implements Parcelable {
    private int id;
    private String name;
    private String body;

    public Commeents(int id, String name, String body) {
        this.id = id;
        this.name = name;
        this.body = body;
    }
    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }





    public Commeents(JSONObject json){
        super();
        try{
            this.id = json.getInt("id");
            this.name= json.getString("name");
            this.body= json.getString("body");

        }catch (JSONException e)
        { e.printStackTrace();}
    }
    protected Commeents(Parcel in) {
        id =in.readInt();
        name=in.readString();
        body=in.readString();
    }
    public static final Parcelable.Creator<Commeents> CREATOR = new Parcelable.Creator<Commeents>() {
        @Override
        public Commeents createFromParcel(Parcel in) {
            return new Commeents(in);
        }

        @Override
        public Commeents[] newArray(int size) {
            return new Commeents[size];
        }
    };


    public void setId(int id) {
        this.id = id;
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
        return "id: "+ id +"\n"+
                "Nome: "+name+"\n"+
                "Username: " + body+"\n---------\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commeents commeents = (Commeents) o;
        return id == commeents.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.body);
    }
}
