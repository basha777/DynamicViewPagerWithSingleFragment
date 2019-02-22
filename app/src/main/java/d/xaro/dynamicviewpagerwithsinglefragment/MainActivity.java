package d.xaro.dynamicviewpagerwithsinglefragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    MyViewPagerAdaper myViewPagerAdaper;
    ArrayList<String>  titlesArrayList;
    ArrayList<Fragment> fragmentArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        titlesArrayList = new ArrayList<>();
        fragmentArrayList = new ArrayList<>();
        getTitlesFromServer();


      }

    private void getTitlesFromServer() {
        //here we get the title from the server
        titlesArrayList.add("vegitables");
        titlesArrayList.add("soups");
        titlesArrayList.add("cars");

        for(int i=0;i<titlesArrayList.size();i++){
            fragmentArrayList.add(SingleFragment.getInstance(titlesArrayList.get(i)));
        }
        setUpViewPager();
    }

    private void setUpViewPager() {
        myViewPagerAdaper = new MyViewPagerAdaper(getSupportFragmentManager());
        viewPager.setAdapter(myViewPagerAdaper);
        tabLayout.setupWithViewPager(viewPager);

    }


    public class MyViewPagerAdaper extends FragmentPagerAdapter {

        public MyViewPagerAdaper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentArrayList.get(i);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titlesArrayList.get(position);
        }

        @Override
        public int getCount() {
            return titlesArrayList.size();
        }
    }
}
