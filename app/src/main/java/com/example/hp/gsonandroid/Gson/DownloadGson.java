package com.example.hp.gsonandroid.Gson;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.gsonandroid.MainActivity;
import com.example.hp.gsonandroid.Model.FacebookModel;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by HP on 9/10/2016.
 */
public class DownloadGson extends AsyncTask<String,FacebookModel,Void> {
    private TextView txtID, txtLogin;
    private ImageView imgAvatar;
    private Context context;

    public DownloadGson(TextView txtID, TextView txtLogin, ImageView imgAvatar, Context context) {
        this.txtID = txtID;
        this.txtLogin = txtLogin;
        this.imgAvatar = imgAvatar;
        this.context = context;
    }

    @Override
    protected Void doInBackground(String... strings) {
        String link= "https://api.github.com/users/"+strings[0];
        try {
            URL url= new URL(link);
            InputStreamReader reader= new InputStreamReader(url.openStream(),"UTF-8");
            FacebookModel facebookModel= new Gson().fromJson(reader,FacebookModel.class);
            publishProgress(facebookModel);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(FacebookModel... values) {
        super.onProgressUpdate(values);
        FacebookModel facebookModel= values[0];
        txtID.setText("Your ID: "+facebookModel.getId());
        txtLogin.setText("Your User: "+facebookModel.getLogin());
        Picasso.with(context).load(facebookModel.getAvatar_url()).into(imgAvatar);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Toast.makeText(context, "Sucessfull!!! :))", Toast.LENGTH_SHORT).show();
        super.onPostExecute(aVoid);
    }
}
