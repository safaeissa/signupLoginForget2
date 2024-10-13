package com.example.signuploginforget;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
private TextView etForget,etSignUp,etLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        connect();
        gotoLogin();
    }
    public void connect()
    {
        etForget=findViewById(R.id.etForget);
        etSignUp=findViewById(R.id.etSignUp);
        etLogin=findViewById(R.id.etLogin);
        etForget.setOnClickListener(view -> gotoForget());
        etSignUp.setOnClickListener(view -> gotoSignUp());
        etLogin.setOnClickListener(view -> gotoLogin());
    }
    private void gotoLogin(){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new LoginFragment());
        ft.commit();}
    private void gotoSignUp(){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new SignUpFragment());
        ft.commit();}
    private void gotoForget(){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new ForgetPasswordFragment());
        ft.commit();}
}