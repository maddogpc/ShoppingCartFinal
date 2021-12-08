package com.example.shoppingcartfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PostLoginDashboard extends AppCompatActivity {

    BuyerDashFragment bdf;
    ShoppingCartFragment scf;
    SellerDashFragment sdf;
    InventoryFragment inf;

    String user_name_g = "";
    String user_email_g = "";
    boolean user_posNo_gs = false;
    int user_posNo_g = 0;

    boolean hasDatabase = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login_dashboard);

        User currentUser = new Buyer(user_name_g, user_email_g);

        // Ensures that the user is signed in
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this );
        // Start database singleton
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        if (signInAccount != null)
        {
            // Welcome the user with name and email
            //welcome.setText("Welcome , " + signInAccount.getDisplayName() + " (" + signInAccount.getEmail() + ")!");

            // Get references for attributes
            DatabaseReference user = database.getReference("users");
            // Declare temporary variables
            final String user_name = signInAccount.getDisplayName();
            user_name_g = user_name;
            user_email_g = signInAccount.getEmail();
            // Read from the database
            user.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        try {
                            user_name_g = snapshot.child(user_name).child("name").getValue(String.class);
                            user_email_g = snapshot.child(user_name).child("email").getValue(String.class);
                            user_posNo_gs = snapshot.child(user_name).child("sellerStatus").getValue(Boolean.class);
                            System.out.println("name: " + user_name_g + ", email: " + user_email_g + ", sellerStatus: " + user_posNo_gs);
                        }
                        catch (NullPointerException npe) {
                            System.out.println("Null pointer");
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    System.out.println("No values found in the database");
                }
            });
            // Update user class in app
            currentUser.setName(user_name_g);
            currentUser.setEmail(user_email_g);
            currentUser.setStatus(user_posNo_gs);
            // Write to the database
            user.child(user_name).setValue(currentUser);
        }

        if (currentUser.getSellerStatus() == true)
        {
            currentUser = new Seller("", "");
            selectFragment(currentUser);
        }

        bdf = new BuyerDashFragment();
        scf = new ShoppingCartFragment();
        sdf = new SellerDashFragment();
        inf = new InventoryFragment();
    }
    public void selectFragment(User user) {
        Fragment index;
        if (user.getSellerStatus() == false)
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