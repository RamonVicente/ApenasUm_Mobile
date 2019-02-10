package com.apenasum.gui;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.apenasum.fragments.CardFragment;
import com.apenasum.R;

public class HomeActivity extends AppCompatActivity {
    FloatingActionButton fab;
    HomeActivity activity;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        activity = this;
        fab = findViewById(R.id.fab);

        Fragment fragment = new CardFragment();
        fragment = new CardFragment();
        chageFragment(fragment);

        BottomAppBar bottom_appbar = findViewById(R.id.bottom_appbar);
        bottom_appbar.replaceMenu(R.menu.bottom_appbar_menu);


        bottom_appbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Fragment fragment = null;
                String tag = "";
                Class fragmentClass = null;
                switch (item.getItemId()) {


                    case R.id.app_bar_transaction:
                        // fab.setImageResource(R.drawable.search);
                        fab.setVisibility(View.GONE);
                        fragment = new TransactionFragment();
                        break;
                    default:

                        break;

                }
                chageFragment(fragment);

                return true;
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void chageFragment(Fragment newFragment) {
        // Create new fragment and transaction
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
        transaction.replace(R.id.frame, newFragment);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();
    }

    public FloatingActionButton getFab() {
        return fab;
    }
}
