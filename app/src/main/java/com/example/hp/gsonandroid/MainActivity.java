package com.example.hp.gsonandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.gsonandroid.Gson.DownloadGson;

public class MainActivity extends AppCompatActivity {
    private EditText edtLinkGithub;
    private Button btnDownload;
    private ImageView imgAvatar;
    private TextView txtID, txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        edtLinkGithub = (EditText) findViewById(R.id.txt_linkGitHub);
        btnDownload = (Button) findViewById(R.id.btn_GetInfo);
        imgAvatar = (ImageView) findViewById(R.id.img_avatar);
        txtID = (TextView) findViewById(R.id.txt_ID);
        txtLogin = (TextView) findViewById(R.id.txt_Login);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadGson downloadGson= new DownloadGson(txtID,txtLogin,imgAvatar,MainActivity.this);
                downloadGson.execute(edtLinkGithub.getText().toString());
            }
        });

    }
}
