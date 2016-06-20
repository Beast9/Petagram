package beast9.com.recyclerview;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;
import java.util.ArrayList;

import beast9.com.recyclerview.adapter.PageAdapter;
import beast9.com.recyclerview.fragment.PerfilMascotaFragment;
import beast9.com.recyclerview.fragment.RecyclerViewFragment;
import beast9.com.recyclerview.java_mail.DatosActivity;

public class MainActivity extends AppCompatActivity implements Serializable{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }


    }

    private ArrayList<Fragment> agregarFragment()
    {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilMascotaFragment());
        return fragments;
    }

    private void setUpViewPager()
    {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_perfil_dog);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.top5:
                Intent i = new Intent(MainActivity.this,TopActivity.class);
                startActivity(i);
                break;

            case R.id.acercade:
                Intent intent1 = new Intent(MainActivity.this,Acerca_De.class);
                startActivity(intent1);
                break;

            case R.id.contacto:
                Intent intent = new Intent(MainActivity.this,DatosActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
