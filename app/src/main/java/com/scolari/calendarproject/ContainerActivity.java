package com.scolari.calendarproject;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.scolari.calendarproject.fragments.AcademyFragment;
import com.scolari.calendarproject.fragments.CalendarFragment;
import com.scolari.calendarproject.fragments.ContactsFragment;
import com.scolari.calendarproject.fragments.PerformFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        bottomBar.setDefaultTab(R.id.calendar);


        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.calendar:
                        CalendarFragment calendarFragment= new CalendarFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, calendarFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;

                    case R.id.academy:
                        AcademyFragment academyFragment= new AcademyFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, academyFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;

                    case R.id.contacts:
                        ContactsFragment contactsFragment= new ContactsFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, contactsFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;

                    case R.id.perform:
                        PerformFragment performFragment= new PerformFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, performFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;



                }
            }
        });



    }
}
