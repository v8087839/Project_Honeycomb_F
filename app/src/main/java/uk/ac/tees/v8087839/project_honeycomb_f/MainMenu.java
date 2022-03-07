package uk.ac.tees.v8087839.project_honeycomb_f;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;

import uk.ac.tees.v8087839.project_honeycomb_f.ui.main.SectionsPagerAdapter;
import uk.ac.tees.v8087839.project_honeycomb_f.databinding.ActivityMainMenuBinding;

public class MainMenu extends AppCompatActivity {

    private ActivityMainMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //LogOut method (When this is attached to a button the pre-registered if statement in SignUp class can also be active)

        //public void logout(View view){
        //    FirebaseAuth.getInstance().signOut();
        //    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        //    finish();
        //}
    }
}