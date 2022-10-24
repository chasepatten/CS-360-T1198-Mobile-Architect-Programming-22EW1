package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.*;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Creates database */
        userDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "users").build();
    }

    /* Registers the User */
    public void UserRegister(View v){
        EditText username = (EditText) findViewById(R.id.editTextUsername);
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);
        String usernameInput = username.getText().toString();
        String passwordInput = password.getText().toString();

        /* Checks to see if username exists, if not it then registers the user with the password
        they provided */
        if(!verifyLogin(usernameInput, passwordInput)){
            addUser(usernameInput, passwordInput);
        }
    }

    /* Function used to login. We take the username and password from the EditText widgets and then
    search for the username and password */
    public void Login(View v){
        EditText usernameText = (EditText) findViewById(R.id.editTextUsername);
        EditText passwordText = (EditText) findViewById(R.id.editTextTextPassword);
        String nameText = usernameText.getText().toString();
        String passText = passwordText.getText().toString();

        /* If login passes then pass on to main display */
        if(verifyLogin(nameText, passText)){
            setContentView(R.layout.main_display);
        }
    }

    /* This function checks the login credentials provided against the user account database. */
    private boolean verifyLogin(String username, String password){
        UserDao userDatabase = db.userDao();
        User user = userDatabase.findByName(username, password);
        return user != null;
    }

    /* This is the function that is used to add the user to the database */
    private void addUser(String username, String password){
        /* Adds the database to userDatabase */
        UserDao userDatabase = db.userDao();
        /* Creates a user object */
        User user = new User();

        /* Sets the attributes to the new user object */
        user.userName = username;
        user.password = password;
        /* Calls the database's insertAll function to add in the user info */
        userDatabase.insertAll(user);
    }
}