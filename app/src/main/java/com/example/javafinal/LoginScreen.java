package com.example.javafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class LoginScreen extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    TextView tvForgot, btnResetPassword;
    Boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        btnResetPassword = findViewById(R.id.btnReset);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        tvForgot = findViewById(R.id.tvForgot);

        tvForgot.setOnClickListener(v ->{
            ForgotClick();
        });
    }
    public void ForgotClick(){
        if (check.equals(true)){
            check = false;
            edtPassword.setEnabled(false);
            edtPassword.setBackgroundColor(Color.parseColor("#FAF3EC"));
            btnResetPassword.setText("RESET PASSWORD");
        }else {
            check  = true;
            edtPassword.setEnabled(true);
            edtPassword.setBackgroundColor(Color.parseColor("#FDFCFB"));
            btnResetPassword.setText("LOG IN");
        }
    }
}