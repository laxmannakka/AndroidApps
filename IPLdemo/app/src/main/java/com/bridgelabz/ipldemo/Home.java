package com.bridgelabz.ipldemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgelabz1 on 29/6/16.
 */

public class Home extends android.support.v4.app.Fragment {

    String uri;
    GridView gridview;
    List<Bitmap> list;
    View view;

    public Home() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uri = "http://192.168.0.118/laxman/teamlogos.json";
        TeamLogos obj = new TeamLogos();
        obj.execute(uri);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home, container, false);
        gridview = (GridView) view.findViewById(R.id.gridview);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "" + position,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),HttpInnternetmanager.DisplayTeam.class);
                intent.putExtra("TEAM_NAME", position);
                startActivity(intent);

            }
        });


        return view;
    }


    public class TeamLogos extends AsyncTask<String, String, List<Bitmap>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Bitmap> doInBackground(String... params) {
            String url;
            Bitmap photo;
            String Content = HttpInnternetmanager.getDataFromjson(uri);

            try {
                list = new ArrayList<>();
                JSONObject obj = new JSONObject(Content);

                url = obj.getString("DD");
                photo = HttpInnternetmanager.getdataImages(url);
                list.add(photo);
                url = obj.getString("GL");
                photo = HttpInnternetmanager.getdataImages(url);
                list.add(photo);
                url = obj.getString("KKR");
                photo = HttpInnternetmanager.getdataImages(url);
                list.add(photo);
                url = obj.getString("KIXP");
                photo = HttpInnternetmanager.getdataImages(url);
                list.add(photo);
                url = obj.getString("MI");
                photo = HttpInnternetmanager.getdataImages(url);
                list.add(photo);
                url = obj.getString("RCB");
                photo = HttpInnternetmanager.getdataImages(url);
                list.add(photo);
                url = obj.getString("RPS");
                photo = HttpInnternetmanager.getdataImages(url);
                list.add(photo);
                url = obj.getString("SRH");
                photo = HttpInnternetmanager.getdataImages(url);
                list.add(photo);


                return list;
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(List<Bitmap> bitmaps) {
            gridview.setAdapter(new GridAdapter(view.getContext(), bitmaps));
            super.onPostExecute(bitmaps);
        }
    }


    public static class MainActivity extends AppCompatActivity {


        TabLayout tabLayout;
        ViewPager viewPager;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tabLayout = (TabLayout) findViewById(R.id.tabLayout);
            viewPager = (ViewPager) findViewById(R.id.viewpager);
            setViewpager(viewPager);

            tabLayout.setupWithViewPager(viewPager);

        }

        private void setViewpager(ViewPager viewPager) {
        Viewpageradapter adapter = new Viewpageradapter(getSupportFragmentManager());
            adapter.addFragment(new Home(),"Home");
            adapter.addFragment(new Franchies.ListofTeams(),"listofteams");
            adapter.addFragment(new Franchies(),"Franchies");
            viewPager.setAdapter(adapter);

        }


        class Viewpageradapter extends FragmentPagerAdapter {

            private final List<String> mFragmentTitleList = new ArrayList<>();
            private final List<Fragment> mFragmentList = new ArrayList<>();
            public Viewpageradapter(FragmentManager fm) {
                super(fm);
            }


            public void addFragment(Fragment fragment, String title) {
                mFragmentList.add(fragment);
                mFragmentTitleList.add(title);
            }
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentTitleList.get(position);
            }
        }


    }
}
