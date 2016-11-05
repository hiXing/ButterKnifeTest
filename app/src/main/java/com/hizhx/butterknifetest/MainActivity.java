package com.hizhx.butterknifetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.login)
    Button loginBtn;
    @BindView(R.id.regist)
    Button registBtn;
    @BindView(R.id.name)
    EditText nameEt;
    @BindView(R.id.password)
    EditText passwdEt;
    @BindView(R.id.toolBar)
    Toolbar toolbar;

    @BindString(R.string.login_error)
    String loginErrorMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitle("TestFragment");
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.login) void login() {
        Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.regist) void regist(){
        Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show();
    }
}
