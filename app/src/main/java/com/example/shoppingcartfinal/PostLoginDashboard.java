package com.example.shoppingcartfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class PostLoginDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login_dashboard);

        User currentUser = new Buyer("", "", 0);

        // Ensures that the user is signed in
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this );
        if (signInAccount != null)
        {
            // Welcome the user with name and email
            //welcome.setText("Welcome , " + signInAccount.getDisplayName() + " (" + signInAccount.getEmail() + ")!");
            currentUser.setName(signInAccount.getDisplayName());
            currentUser.setEmail(signInAccount.getEmail());
        }

        if (currentUser.getSellerStatus() == true)
        {
            currentUser = new Seller("", "", 1);
        }
    }
}