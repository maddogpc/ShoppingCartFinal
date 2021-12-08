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

        final User currentUser = new Buyer(user_name_g, user_email_g);

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
            // Update user class in app
            currentUser.setName(user_name_g);
            currentUser.setEmail(user_email_g);
            currentUser.setStatus(user_posNo_gs);

            System.out.println("Will call avel");
            // Assign a new user object to existing currentUser object to update the user class upon reading Firebase data
            User finalCurrentUser = currentUser;
            ConcreteViewModel concreteViewModel = new ConcreteViewModel(finalCurrentUser);
            // Read from the database
            user.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists())
                    {
                        System.out.println("Calling avel");
                        try {
                            // Assigning temporary attributes to data from DB
                            user_name_g = snapshot.child(user_name).child("name").getValue(String.class);
                            user_email_g = snapshot.child(user_name).child("email").getValue(String.class);
                            user_posNo_gs = snapshot.child(user_name).child("sellerStatus").getValue(Boolean.class);
                            System.out.println("name: " + user_name_g + ", email: " + user_email_g + ", sellerStatus: " + user_posNo_gs);
                            hasDatabase = true;
                            // Change attributes of user in listener
                            finalCurrentUser.setName(user_name_g);
                            finalCurrentUser.setEmail(user_email_g);
                            finalCurrentUser.setStatus(user_posNo_gs);
                            // Change fragment when user has seller status
                            if (finalCurrentUser.getSellerStatus() == true)
                            {
                                User currentUser2 = new Seller(currentUser.getName(), currentUser.getEmail());
                                System.out.println("changed status");
                                concreteViewModel.setUser(currentUser2);
                                selectFragment(currentUser2);
                            }
                        }
                        catch (NullPointerException npe) {
                            System.out.println("Null pointer");
                        }
                    }
                    else
                    {
                        // Write to the database
                        user.child(user_name).setValue(finalCurrentUser);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    System.out.println("No values found in the database");
                }
            });
            System.out.println("status 1 " + currentUser.getSellerStatus());

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
            System.out.println("Set to Buyer Fragment");
            index = bdf;
        }
        else
        {
            System.out.println("Set to Seller Fragment");
            index = sdf;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.shopnav, index).commit();
    }
}