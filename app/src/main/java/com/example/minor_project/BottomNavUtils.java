package com.example.minor_project;

import android.app.Activity;
import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavUtils {

    public static void setupBottomNavigation(Activity activity) {
        BottomNavigationView bottomNavigationView = activity.findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home && !isCurrentItem(activity, MainActivity.class)) {
                navigateToActivity(activity, MainActivity.class);
                return true;
            } else if (item.getItemId() == R.id.bookmark && !isCurrentItem(activity, bookMarkView.class)) {
                navigateToActivity(activity, bookMarkView.class);
                return true;
            }
            // Add other cases for additional menu items if needed
            return false;
        });
    }

    private static boolean isCurrentItem(Activity activity, Class<?> targetActivityClass) {
        return activity.getClass().equals(targetActivityClass);
    }

    private static void navigateToActivity(Activity activity, Class<?> targetActivityClass) {
        activity.startActivity(new Intent(activity, targetActivityClass));

    }
}
