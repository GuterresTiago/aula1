package com.example.aula1.Model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class User implements Parcelable {
    private int id;
    private String name;
    private String username;
    private String email;




    public User(int id, String name, String username, String email) {
        this.id = id;
        this.name=name;
        this.username=username;
        this.email = email;

    }
    public User(JSONObject json) {
        super();
        try {
            this.id = json.getInt("id");
            this.name = json.getString("name");
            this.username = json.getString("username");
            this.email = json.getString("email");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected User(Parcel in) {
        id = in.readInt();
        name= in.readString();
        username=in.readString();
        email = in.readString();


    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public String toString() {
        return "id: "+id+"\n"+
                "Nome: "+name+"\n"+
                "Username: " + username+"\n"+
                "Email: "+email+"\n---------\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
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
        parcel.writeString(this.username);
        parcel.writeString(this.email);
    }
}

