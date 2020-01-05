package com.example.holideys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.holideys.fragment.Fr_Black_Friday;
import com.example.holideys.fragment.Fr_Holi;
import com.example.holideys.fragment.Fr_Internet_Day;
import com.example.holideys.fragment.Fr_New_Year;
import com.example.holideys.fragment.Fragment_navigation_view;
import com.example.holideys.fragment.HolideyFragment;
import com.example.holideys.fragment.HomeFragment;
import com.example.holideys.fragment.fR_Hanami;
import com.example.holideys.fragment.fR_Harvey_Ball;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragment1DataListener,Fragment_navigation_view.HomeCallBack {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toogle;

    public static String NAME = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNaviView();
        initFragmentHome();


    }
    private void initFragmentHome(){
        initNaviView();
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        fr.replace(R.id.container,homeFragment).commit();
    }

    private void initNaviView(){
        FragmentTransaction fr=getSupportFragmentManager().beginTransaction();
        fr.add(R.id.comtainer,new Fragment_navigation_view());
        fr.commit();
        drawerLayout=findViewById(R.id.drawer_view);
        navigationView=findViewById(R.id.navigation_view);
        toogle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onOpenFragment2(String string, String year,String mounth,String day) {
        FragmentManager fr1 = getSupportFragmentManager();
        Fragment fragment = fr1.findFragmentById(R.id.container);
        fragment = new HolideyFragment();

        Bundle bundle= new Bundle();
        bundle.putString(HolideyFragment.KEY,string);
        bundle.putString(HolideyFragment.KEY1,year);
        bundle.putString(HolideyFragment.KEY2,mounth);
        bundle.putString(HolideyFragment.KEY3,day);
        fragment.setArguments(bundle);
        fr1.beginTransaction()
                .add(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null)
                .commit();
    }

    @Override
    public void sendType(String type) {
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();

        switch (type){
            case Fragment_navigation_view.NEW_YEAR_TYPE:
                Fr_New_Year fr_new_year = new Fr_New_Year();
                fr.replace(R.id.container,fr_new_year);
                break;
            case Fragment_navigation_view.HOLI_TYPE:
                Fr_Holi fr_holi = new Fr_Holi();
                fr.replace(R.id.container,fr_holi);
                break;
            case Fragment_navigation_view.Hanami_TYPE:
                fR_Hanami fR_hanami = new fR_Hanami();
                fr.replace(R.id.container,fR_hanami);
                break;
            case Fragment_navigation_view.INTERNET_EDAY_TYPE:
                Fr_Internet_Day fr_internet_day = new Fr_Internet_Day();
                fr.replace(R.id.container,fr_internet_day);
                break;
            case Fragment_navigation_view.HARVEY_DAY_TYPE:
                fR_Harvey_Ball fR_harvey_ball =new  fR_Harvey_Ball();
                fr.replace(R.id.container,fR_harvey_ball);
                break;
            case Fragment_navigation_view.BLACK_FRIDAY_TYPE:
                Fr_Black_Friday fr_black_friday = new Fr_Black_Friday();
                fr.replace(R.id.container,fr_black_friday);
                break;
        }


        fr.addToBackStack(null).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {

                drawerLayout.openDrawer(GravityCompat.START);
            }
        }



        int id=item.getItemId();
        switch (id){
            case R.id.view_settings:
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/profile.php?id=100001984552635"));
                startActivity(intent);
                break;
            case R.id.view_item1:
                Intent intent1=new Intent();
                intent1.setAction(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:098551500"));
                startActivity(intent1);
                break;
            case R.id.view_item2:
                Intent intent2=new Intent();
                intent2.setAction(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("geo:40.138623, 44.475904"));
                startActivity(intent2);
                break;
            case R.id.view_item3:
                Toast.makeText(MainActivity.this,"tank you for watch",Toast.LENGTH_LONG).show();
                break;
        }

       return super.onOptionsItemSelected(item);
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }




}

