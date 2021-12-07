package com.example.shoppingcartfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class PostLoginDashboard extends AppCompatActivity {

    BuyerDashFragment bdf;
    ShoppingCartFragment scf;
    SellerDashFragment sdf;
    InventoryFragment inf;

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

        bdf = new BuyerDashFragment();
        scf = new ShoppingCartFragment();
        sdf = new SellerDashFragment();
        inf = new InventoryFragment();
    }
    public void selectFragment(View view, User user) {
        Fragment index;
        if (user.buyerOrSeller() == false)
        {
            index = bdf;
        }
        else
        {
            index = sdf;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.shopnav, index).commit();
    }
}