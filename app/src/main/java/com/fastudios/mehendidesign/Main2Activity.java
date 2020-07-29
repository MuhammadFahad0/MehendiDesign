package com.fastudios.mehendidesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    RecyclerView Rc;
    LinearLayoutManager manager;
    CustomAdrapter2 CA;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        drawerLayout=findViewById(R.id.drawer_layout2);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.tool2);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_format_list_bulleted_black_24dp);

        final int Backlist[]= {
                R.drawable.back1,
                R.drawable.back2,
                R.drawable.back3,
                R.drawable.back4,
                R.drawable.back5,
                R.drawable.back6,
                R.drawable.back7,
                R.drawable.back8,
                R.drawable.back9,
                R.drawable.back10,
                R.drawable.back11,
                R.drawable.back12,
                R.drawable.back13,
                R.drawable.back14,
                R.drawable.back15,
                R.drawable.back16,
                R.drawable.back17,
                R.drawable.back18,
                R.drawable.back19,
                R.drawable.back20,
                R.drawable.back21,
                R.drawable.back22,
                R.drawable.back23,
                R.drawable.back24,
                R.drawable.back25,
                R.drawable.back26,
                R.drawable.back27,
                R.drawable.back28,
                R.drawable.back29,
                R.drawable.back30,
                R.drawable.back31,
                R.drawable.back32,
                R.drawable.back33,
                R.drawable.back34,
                R.drawable.back35,
                R.drawable.back36,
                R.drawable.back37,
                R.drawable.back38,
                R.drawable.back39,
                R.drawable.back40,
                R.drawable.back41,
                R.drawable.back42,
                R.drawable.back43,
                R.drawable.back44,
                R.drawable.back45,
                R.drawable.back46,
                R.drawable.back47,
                R.drawable.back48,
                R.drawable.back49,
                R.drawable.back50,
                R.drawable.back51,
                R.drawable.back52,
                R.drawable.back53,
                R.drawable.back54,
                R.drawable.back55,
                R.drawable.back56,
                R.drawable.back57,
                R.drawable.back58,
                R.drawable.back59,
                R.drawable.back60,
                R.drawable.back61,
                R.drawable.back62,
                R.drawable.back63,
                R.drawable.back64,
                R.drawable.back65,
                R.drawable.back66,
                R.drawable.back67,
                R.drawable.back68,
                R.drawable.back69,
                R.drawable.back70,
                R.drawable.back71,
                R.drawable.back72,
                R.drawable.back73,
                R.drawable.back74,
                R.drawable.back75,
                R.drawable.back76,
                R.drawable.back77,
                R.drawable.back78,
                R.drawable.back79,
                R.drawable.back80,
                R.drawable.back81,
                R.drawable.back82,
                R.drawable.back83,
                R.drawable.back84,
                R.drawable.back85,
                R.drawable.back86,
                R.drawable.back87,
                R.drawable.back88,
                R.drawable.back89,
                R.drawable.back90,
                R.drawable.back91,
                R.drawable.back92,
                R.drawable.back93,
                R.drawable.back94,
                R.drawable.back95,
                R.drawable.back96,
                R.drawable.back97,
                R.drawable.back98,
                R.drawable.back99,
                R.drawable.back100,
                R.drawable.back101,
                R.drawable.back102,
                R.drawable.back103,
                R.drawable.back104,
                R.drawable.back105,
                R.drawable.back106,
                R.drawable.back107,
                R.drawable.back108,
                R.drawable.back109,
                R.drawable.back110,
                R.drawable.back111,
                R.drawable.back112,
                R.drawable.back113,
                R.drawable.back114,
                R.drawable.back115,
                R.drawable.back116,
                R.drawable.back117,
                R.drawable.back118,
                R.drawable.back119,
                R.drawable.back120,
                R.drawable.back121,
                R.drawable.back122,
                R.drawable.back123,
                R.drawable.back124,
                R.drawable.back125,
                R.drawable.back126,
                R.drawable.back127,
                R.drawable.back128,
                R.drawable.back129,
                R.drawable.back130,
                R.drawable.back131,
                R.drawable.back132,
                R.drawable.back133,
                R.drawable.back134,
                R.drawable.back135,
                R.drawable.back136,
                R.drawable.back137,
                R.drawable.back138,
                R.drawable.back139,
                R.drawable.back140,
                R.drawable.back141,
                R.drawable.back142,
                R.drawable.back143,
                R.drawable.back144,
                R.drawable.back145,
                R.drawable.back146,
                R.drawable.back147,
                R.drawable.back148,
                R.drawable.back149,
                R.drawable.back150,
                R.drawable.back151,
                R.drawable.back152,
                R.drawable.back153,
                R.drawable.back154,
                R.drawable.back155,
                R.drawable.back156,
                R.drawable.back157,
                R.drawable.back158,
                R.drawable.back159
        };
        final int frontlist[]= {
                R.drawable.front1,
                R.drawable.front2,
                R.drawable.front3,
                R.drawable.front4,
                R.drawable.front5,
                R.drawable.front6,
                R.drawable.front7,
                R.drawable.front8,
                R.drawable.front9,
                R.drawable.front10,
                R.drawable.front11,
                R.drawable.front12,
                R.drawable.front13,
                R.drawable.front14,
                R.drawable.front15,
                R.drawable.front16,
                R.drawable.front17,
                R.drawable.front18,
                R.drawable.front19,
                R.drawable.front20,
                R.drawable.front21,
                R.drawable.front22,
                R.drawable.front23,
                R.drawable.front24,
                R.drawable.front25,
                R.drawable.front26,
                R.drawable.front27,
                R.drawable.front28,
                R.drawable.front29,
                R.drawable.front30,
                R.drawable.front31,
                R.drawable.front32,
                R.drawable.front33,
                R.drawable.front34,
                R.drawable.front35,
                R.drawable.front36,
                R.drawable.front37,
                R.drawable.front38,
                R.drawable.front39,
                R.drawable.front40,
                R.drawable.front41,
                R.drawable.front42,
                R.drawable.front43,
                R.drawable.front44,
                R.drawable.front45,
        };

        final int weddinglist[]= {
                R.drawable.wedding2,
                R.drawable.wedding3,
                R.drawable.wedding4,
                R.drawable.wedding5,
                R.drawable.wedding6,
                R.drawable.wedding7,
                R.drawable.wedding8,
                R.drawable.wedding9,
                R.drawable.wedding10,
                R.drawable.wedding11,
                R.drawable.wedding12,
                R.drawable.wedding13,
                R.drawable.wedding14,
                R.drawable.wedding15,
                R.drawable.wedding16,
                R.drawable.wedding17,
                R.drawable.wedding18,
                R.drawable.wedding19,
                R.drawable.wedding20,
                R.drawable.wedding21,
                R.drawable.wedding22,
                R.drawable.wedding23,
                R.drawable.wedding24,
                R.drawable.wedding25,
                R.drawable.wedding26,
                R.drawable.wedding27,
                R.drawable.wedding28,
                R.drawable.wedding29,
                R.drawable.wedding30,
                R.drawable.wedding31,
                R.drawable.wedding32,
                R.drawable.wedding33,
                R.drawable.wedding34,
                R.drawable.wedding35,
                R.drawable.wedding36,
                R.drawable.wedding37,
                R.drawable.wedding38,
                R.drawable.wedding39,
                R.drawable.wedding40,
                R.drawable.wedding41,
                R.drawable.wedding42,
                R.drawable.wedding43,
                R.drawable.wedding44,
                R.drawable.wedding45,
                R.drawable.wedding46,
                R.drawable.wedding47,
                R.drawable.wedding48,
                R.drawable.wedding49,
                R.drawable.wedding50,
                R.drawable.wedding51,
                R.drawable.wedding52,
                R.drawable.wedding53,
                R.drawable.wedding54,
                R.drawable.wedding55,
                R.drawable.wedding56,
                R.drawable.wedding57,
                R.drawable.wedding58,
                R.drawable.wedding59,
                R.drawable.wedding60,
                R.drawable.wedding61,
                R.drawable.wedding62,
                R.drawable.wedding63,
                R.drawable.wedding64,
                R.drawable.wedding65,
                R.drawable.wedding66,
                R.drawable.wedding67,
                R.drawable.wedding68,
                R.drawable.wedding69,
                R.drawable.wedding70,
                R.drawable.wedding71,
                R.drawable.wedding72,
                R.drawable.wedding73,
                R.drawable.wedding74,
                R.drawable.wedding75,
                R.drawable.wedding1
        };

        final int armlist[]= {
                R.drawable.zarm2,
                R.drawable.zarm3,
                R.drawable.zarm4,
                R.drawable.zarm5,
                R.drawable.zarm7,
                R.drawable.zarm8,
                R.drawable.zarm9,
                R.drawable.zarm10,
                R.drawable.zarm11,
                R.drawable.zarm12,
                R.drawable.zarm13,
                R.drawable.zarm14,
                R.drawable.zarm15,
                R.drawable.zarm1,
        };

        final int fingerlist[]= {
                R.drawable.finger2,
                R.drawable.finger3,
                R.drawable.finger4,
                R.drawable.finger5,
                R.drawable.finger6,
                R.drawable.finger7,
                R.drawable.finger8,
                R.drawable.finger9,
                R.drawable.finger10,
                R.drawable.finger11,
                R.drawable.finger12,
                R.drawable.finger13,
                R.drawable.finger14,
                R.drawable.finger15,
                R.drawable.finger16,
                R.drawable.finger17,
                R.drawable.finger18,
                R.drawable.finger19,
                R.drawable.finger20,
                R.drawable.finger21,
                R.drawable.finger22,
                R.drawable.finger23,
                R.drawable.finger24,
                R.drawable.finger25,
                R.drawable.finger26,
                R.drawable.finger27,
                R.drawable.finger28,
                R.drawable.finger29,
                R.drawable.finger30,
                R.drawable.finger31,
                R.drawable.finger32,
                R.drawable.finger33,
                R.drawable.finger34,
                R.drawable.finger35,
                R.drawable.finger36,
                R.drawable.finger37,
                R.drawable.finger38,
                R.drawable.finger39,
                R.drawable.finger40,
                R.drawable.finger41,
                R.drawable.finger42,
                R.drawable.finger43,
                R.drawable.finger44,
                R.drawable.finger45,
                R.drawable.finger46,
                R.drawable.finger47,
                R.drawable.finger48,
                R.drawable.finger49,
                R.drawable.finger50,
                R.drawable.finger51,
                R.drawable.finger52,
                R.drawable.finger53,
                R.drawable.finger54,
                R.drawable.finger55,
                R.drawable.finger56,
                R.drawable.finger57,
                R.drawable.finger58,
                R.drawable.finger59,
                R.drawable.finger60,
                R.drawable.finger61,
                R.drawable.finger62,
                R.drawable.finger63,
                R.drawable.finger64,
                R.drawable.finger65,
                R.drawable.finger66,
                R.drawable.finger67,
                R.drawable.finger68,
                R.drawable.finger69,
                R.drawable.finger70,
                R.drawable.finger71,
                R.drawable.finger72,
                R.drawable.finger73,
                R.drawable.finger74,
                R.drawable.finger75,
                R.drawable.finger76,
                R.drawable.finger77,
                R.drawable.finger78,
                R.drawable.finger79,
                R.drawable.finger80,
                R.drawable.finger81,
                R.drawable.finger82,
                R.drawable.finger83,
                R.drawable.finger84,
                R.drawable.finger85,
                R.drawable.finger86,
                R.drawable.finger87,
                R.drawable.finger88,
                R.drawable.finger89,
                R.drawable.finger90,
                R.drawable.finger91,
                R.drawable.finger92,
                R.drawable.finger93,
                R.drawable.finger94,
                R.drawable.finger95,
                R.drawable.finger96,
                R.drawable.finger97,
                R.drawable.finger98,
                R.drawable.finger99,
                R.drawable.finger100,
                R.drawable.finger101,
                R.drawable.finger102,
                R.drawable.finger103,
                R.drawable.finger104,
                R.drawable.finger105,
                R.drawable.finger106,
                R.drawable.finger107,
                R.drawable.finger108,
                R.drawable.finger109,
                R.drawable.finger110,
                R.drawable.finger111,
                R.drawable.finger112,
                R.drawable.finger113,
                R.drawable.finger114,
                R.drawable.finger115,
                R.drawable.finger116,
                R.drawable.finger117,
                R.drawable.finger118,
                R.drawable.finger119,
                R.drawable.finger120,
                R.drawable.finger121,
                R.drawable.finger122,
                R.drawable.finger123,
                R.drawable.finger124,
                R.drawable.finger125,
                R.drawable.finger126,
                R.drawable.finger127,
                R.drawable.finger128,
                R.drawable.finger129,
                R.drawable.finger130,
                R.drawable.finger131,
                R.drawable.finger132,
        };

        final int footlist[]= {
                R.drawable.foot2,
                R.drawable.foot3,
                R.drawable.foot4,
                R.drawable.foot5,
                R.drawable.foot6,
                R.drawable.foot7,
                R.drawable.foot1,
                R.drawable.foot8,
                R.drawable.foot9,
                R.drawable.foot10,
                R.drawable.foot11,
                R.drawable.foot12,
                R.drawable.foot13,
                R.drawable.foot14,
                R.drawable.foot15,
                R.drawable.foot16,
                R.drawable.foot17,
                R.drawable.foot18,
                R.drawable.foot19,
                R.drawable.foot20,
                R.drawable.foot21,
                R.drawable.foot22,
                R.drawable.foot23,
                R.drawable.foot24,
                R.drawable.foot25,
                R.drawable.foot26,
                R.drawable.foot27,
                R.drawable.foot28,
                R.drawable.foot29,
                R.drawable.foot30,
                R.drawable.foot31,
                R.drawable.foot32,
                R.drawable.foot33,
                R.drawable.foot34,
                R.drawable.foot35,
                R.drawable.foot36,
                R.drawable.foot37,
                R.drawable.foot38,
                R.drawable.foot39,
                R.drawable.foot40,
                R.drawable.foot41,
                R.drawable.foot42,
        };

        Intent intent = getIntent();
        String message = intent.getStringExtra("Message");


        Rc = findViewById(R.id.recyclerr);
        manager = new LinearLayoutManager(this);
        Rc.setLayoutManager(manager);
        switch (message)
        {
            case "backhand":
                CA = new CustomAdrapter2(this,Backlist);

                break;

            case "fronthand":
                CA = new CustomAdrapter2(this,frontlist);
                break;

            case "fingerhand":
                CA = new CustomAdrapter2(this,fingerlist);
                break;

            case "weddinghand":
                CA = new CustomAdrapter2(this,weddinglist);
                break;

            case "armhand":
                CA = new CustomAdrapter2(this,armlist);
                break;

            case "foothand":
                CA = new CustomAdrapter2(this,footlist);
                break;

            default:
                CA = new CustomAdrapter2(this,Backlist);
        }

        Rc.setAdapter(CA);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {



                switch (menuItem.getItemId())
                {
                    case R.id.nav_back:
                        CA = new CustomAdrapter2(Main2Activity.this,Backlist);
                        Rc.setAdapter(CA);
                        drawerLayout.closeDrawers();
                        return false;
                    case R.id.nav_front:
                        CA = new CustomAdrapter2(Main2Activity.this,frontlist);
                        Rc.setAdapter(CA);
                        drawerLayout.closeDrawers();
                        return false;
                    case R.id.Nav_finger:
                        CA = new CustomAdrapter2(Main2Activity.this,fingerlist);
                        Rc.setAdapter(CA);
                        drawerLayout.closeDrawers();
                        return false;
                    case R.id.nav_wedding:
                        CA = new CustomAdrapter2(Main2Activity.this,weddinglist);
                        Rc.setAdapter(CA);
                        drawerLayout.closeDrawers();
                        return false;
                    case R.id.nav_arm:
                        CA = new CustomAdrapter2(Main2Activity.this,armlist);
                        Rc.setAdapter(CA);
                        drawerLayout.closeDrawers();
                        return false;
                    case R.id.nav_foot:
                        CA = new CustomAdrapter2(Main2Activity.this,footlist);
                        Rc.setAdapter(CA);
                        drawerLayout.closeDrawers();
                        return false;
                    default:
                        return false;
                }
            }
        });


    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawers();
        }
        else
        {
            super.onBackPressed();
        }
    }
}
