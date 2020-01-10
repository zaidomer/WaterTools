package com.pawmocca.watertools;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.pawmocca.watertools.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static String oldLearnURL = "http://learn.uwaterloo.ca";
    public static String oldPortalURL = "https://portal.uwaterloo.ca";
    public static String oldQuestURL = "https://quest.pecs.uwaterloo.ca/psp/SS/ACADEMIC/SA/?cmd=login&languageCd=ENG&";
    public static String oldWorksURL = "https://waterlooworks.uwaterloo.ca/myAccount/dashboard.htm";
    public static String oldCrowdmarkURL = "https://app.crowdmark.com/student/courses";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_portal, R.id.navigation_quest, R.id.navigation_crowdmark, R.id.navigation_learn, R.id.navigation_works)
//                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

}
/*
public class MainActivity extends AppCompatActivity {

    public static String oldLearnURL = "http://learn.uwaterloo.ca";
    public static String oldPortalURL = "https://portal.uwaterloo.ca";
    public static String oldQuestURL = "https://quest.pecs.uwaterloo.ca/psp/SS/ACADEMIC/SA/?cmd=login&languageCd=ENG&";
    public static String oldWorksURL = "https://waterlooworks.uwaterloo.ca/myAccount/dashboard.htm";
    public static String oldCrowdmarkURL = "https://app.crowdmark.com/student/courses";

    Toolbar toolbar;
    FrameLayout frameLayout;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_portal, R.id.navigation_quest, R.id.navigation_crowdmark, R.id.navigation_learn, R.id.navigation_works)
//                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        frameLayout = findViewById(R.id.simpleFrameLayout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("test1"));
        tabLayout.addTab(tabLayout.newTab().setText("test2"));
    }
}
*/