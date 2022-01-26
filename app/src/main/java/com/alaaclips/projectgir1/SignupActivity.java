package com.alaaclips.projectgir1;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alaaclips.projectgir1.db.DatabaseHelpers;
import com.alaaclips.projectgir1.model.Users;
import com.alaaclips.projectgir1.model.VotingList;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class SignupActivity extends AppCompatActivity {

    Bitmap selectedImage;
    ImageView imageView;
    EditText personname;
    EditText PersonEmaile;
    EditText Personpassworde;
    Button btn_signup;
    TextView navetoLogin;
    ImageView testImage;


    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    selectedImage = BitmapFactory.decodeStream(imageStream);
                imageView.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        DatabaseHelpers db = new DatabaseHelpers(this);





        SharedPreferences prefs = getSharedPreferences("ALAA", MODE_PRIVATE);
        boolean state = prefs.getBoolean("state",true);



        VotingList list1 = new VotingList("حماس",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/%D8%B4%D8%B9%D8%A7%D8%B1_%D8%AD%D8%B1%D9%83%D8%A9_%D8%AD%D9%85%D8%A7%D8%B3.jpg/195px-%D8%B4%D8%B9%D8%A7%D8%B1_%D8%AD%D8%B1%D9%83%D8%A9_%D8%AD%D9%85%D8%A7%D8%B3.jpg",
                "lalalalal",
                "الزهار");
        VotingList list2 = new VotingList("فتح",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/%D8%B4%D8%B9%D8%A7%D8%B1_%D8%AD%D8%B1%D9%83%D8%A9_%D8%AD%D9%85%D8%A7%D8%B3.jpg/195px-%D8%B4%D8%B9%D8%A7%D8%B1_%D8%AD%D8%B1%D9%83%D8%A9_%D8%AD%D9%85%D8%A7%D8%B3.jpg",
                "lalalalal",
                "الزهار");
        VotingList list3 = new VotingList("الجهاد",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/%D8%B4%D8%B9%D8%A7%D8%B1_%D8%AD%D8%B1%D9%83%D8%A9_%D8%AD%D9%85%D8%A7%D8%B3.jpg/195px-%D8%B4%D8%B9%D8%A7%D8%B1_%D8%AD%D8%B1%D9%83%D8%A9_%D8%AD%D9%85%D8%A7%D8%B3.jpg",
                "lalalalal",
                "الزهار");

        ArrayList<VotingList> votingitem=new ArrayList<>();
        votingitem.add(list3);
        votingitem.add(list2);
        votingitem.add(list1);



        if (state){
            SharedPreferences.Editor editor = getSharedPreferences("ALAA", MODE_PRIVATE).edit();
            editor.putBoolean("state",false);
            editor.apply();

            votingitem.forEach((n) -> {
                db.insertNote(n);
            });

        }

        imageView = findViewById(R.id.personImage);
        personname = findViewById(R.id.personname);
        PersonEmaile =findViewById(R.id.PersonEmaile);
        Personpassworde = findViewById(R.id.Personpassworde);
        btn_signup = findViewById(R.id.btn_signup);

        navetoLogin = findViewById(R.id.navetoLogin);


        testImage = findViewById(R.id.testImage);


        imageView.setOnClickListener(view -> {


            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, 100);
        });

        testImage.setOnClickListener(view -> {

        });



        btn_signup.setOnClickListener(view -> {

           byte[]  imageBytes =getBytes(selectedImage);

            Users newUser = new Users(personname.getText().toString(), Personpassworde.getText().toString(),PersonEmaile.getText().toString(),imageBytes);
            boolean statew =db.addNewUser(newUser);

            if (statew){

                SharedPreferences.Editor editor = getSharedPreferences("ALAA", MODE_PRIVATE).edit();
                editor.putString("username",newUser.getUserName());
                editor.putString("useremaile",newUser.getEmail());
                editor.apply();


                Toast.makeText(this,"Sucsseful",Toast.LENGTH_LONG).show();


                Intent i = new Intent(this,BottomNavigationActivity.class);
                startActivity(i);
                finish();


            }else{
                Toast.makeText(this,"Fild",Toast.LENGTH_LONG).show();

            }



        });




        navetoLogin.setOnClickListener(view -> {
            Intent i = new Intent(this,LogInActivity.class);
            startActivity(i);
        });







    }

    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }
}