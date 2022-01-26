package com.alaaclips.projectgir1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.CursorWindow;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alaaclips.projectgir1.db.DatabaseHelpers;
import com.alaaclips.projectgir1.model.Users;
import com.alaaclips.projectgir1.model.Volting;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class LogInActivity extends AppCompatActivity {


    Button btn_Login;
    EditText emaile;
    EditText passworde;
    DatabaseHelpers db;
    ArrayList<Users> listUser;
    Users UserVoltinguseingemaile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        btn_Login = findViewById(R.id.btn_Login);

        emaile = findViewById(R.id.Emaile);
        passworde = findViewById(R.id.passworde);


        db = new DatabaseHelpers(this);

        try {
            Field field = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            field.setAccessible(true);
            field.set(null, 100 * 1024 * 1024);
            listUser = db.getallUser();
//the 100MB is the new size
        } catch (Exception e) {
            e.printStackTrace();
        }


        btn_Login.setOnClickListener(view -> {



            UserVoltinguseingemaile = findUser(emaile.getText().toString(), listUser);


            if (UserVoltinguseingemaile == null) {

                Toast.makeText(this, "لا يوجد حسا ببهادا الاسم", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "تم تسجيل الدخول", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(this, BottomNavigationActivity.class);
                startActivity(i);
                finish();

            }

        });


    }


    public Users findUser(String email, ArrayList<Users> customers) {

        for (Users customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

}