package com.gaby.programa2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   // String passwdReg="12345";
   // String usrReg="gaby";
    String passwdReg, usrReg;
    EditText user, password;
    Button login;
    SharedPreferences  pref;
    SharedPreferences.Editor editor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("datos", MODE_PRIVATE);
        editor = pref.edit();
        /*editor.putString("user1","Gaby");
        editor.putString("user2","Otero");
        editor.putString("pass1","12345");
        editor.putString("pass2","hola1");*/
        editor.commit();
        //String usr1=pref.getString("user1","-");
        //String pas1=pref.getString("pass1","-");


        user=(EditText)findViewById(R.id.edt_user);
        password=(EditText)findViewById(R.id.edt_passwd);
        login=(Button)findViewById(R.id.btn_login);
        login.setText("LOGIN");
    }
    public void login(View view) {
        String name, pass;
        name = user.getText().toString();
        pass = password.getText().toString();
        String pas1;
        String usr1;

        usr1=pref.getString(user.getText().toString(),"-");
        if(!usr1.equals("-") && usr1.equals(password.getText().toString()))
        {
            mensaje("Bienvenidx");
        }
        else mensaje("Datos erróneos");
       /* for (int i = 0; i < 10; i++)
        {
            usr1 = pref.getString("user" + i, "-");
            //usr1=pref.getString(user.getText().toString(),"-");
            if (!usr1.equals("-") && usr1.equals(name))
            //if(!usr1.equals("-")&&usr1.equals(password.getText().toString()))
            {
                pas1 = pref.getString("pass"+i, "-");
                if (pas1.equals(pass)) {
                    Toast.makeText(this, "BIENVENIDX", Toast.LENGTH_SHORT).show();
                }
            }
        }*/


    }

    public void registr(View view)
    {
        String usr=pref.getString(user.getText().toString(),"-");
        if(!usr.equals("-"))
        {
            editor.putString(user.getText().toString(), password.getText().toString());
            editor.commit();
        }
        else mensaje("Usuario Existente");
    }

    public void mensaje(String s)
    {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}