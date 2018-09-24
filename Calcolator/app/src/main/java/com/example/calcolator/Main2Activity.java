package com.example.calcolator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.API.GetHL;
import com.calculator.calculator;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout mDrawerLayout;
    private double Country = 0.0;
    private boolean flg = false;
    private double RMB=0;
    private double MBHB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                GetHL.getRequest1();
                Country=GetHL.getData5();
                flg = true;
            }
        }).start();



        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        Button toOther = (Button) findViewById(R.id.to_other);
        Button toRMB = (Button) findViewById(R.id.to_RMB);
        toOther.setOnClickListener(this);
        toRMB.setOnClickListener(this);
        toOther.setTag(1);
        toRMB.setTag(2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationview);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
        }
        navigationView.setCheckedItem(R.id.nav_HL);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_HL:
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_cal:
                        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) findViewById(R.id.MBHB);
                //选择列表项的操作
                switch (position){
                    case 0:
                        Country=GetHL.getData5();
                        textView.setText("英镑");
                        break;
                    case 1:
                        Country=GetHL.getData3();
                        textView.setText("港币");
                        break;
                    case 2:
                        Country=GetHL.getData1();
                        textView.setText("美元");
                        break;
                    case 3:
                        Country=GetHL.getData16();
                        textView.setText("瑞士法郎");
                        break;
                    case 4:
                        Country=GetHL.getData9();
                        textView.setText("新加坡元");
                        break;
                    case 5:
                        Country=GetHL.getData13();
                        textView.setText("瑞典法郎");
                        break;
                    case 6:
                        Country=GetHL.getData12();
                        textView.setText("丹麦克朗");
                        break;
                    case 7:
                        Country=GetHL.getData10();
                        textView.setText("挪威克朗");
                        break;
                    case 8:
                        Country=GetHL.getData4();
                        textView.setText("日元");
                        break;
                    case 9:
                        Country=GetHL.getData7();
                        textView.setText("加拿大元");
                        break;
                    case 10:
                        Country=GetHL.getData6();
                        textView.setText("澳大利亚元");
                        break;
                    case 11:
                        Country=GetHL.getData2();
                        textView.setText("欧元");
                        break;
                    case 12:
                        Country=GetHL.getData18();
                        textView.setText("澳门元");
                        break;
                    case 13:
                        Country=GetHL.getData17();
                        textView.setText("韩国元");
                        break;
                    case 14:
                        Country=GetHL.getData21();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //未选中时候的操作
                Country=GetHL.getData5();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home: //导航按钮响应：打开侧滑菜单
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.top_AC:
                EditText input1 = (EditText) findViewById(R.id.et_RMB);
                EditText input2 = (EditText) findViewById(R.id.et_MBHB);
                input1.setText("");
                input2.setText("");

        }
        return true;
    }

    @Override
    public void onClick(View V){

        final EditText input1 = (EditText) findViewById(R.id.et_RMB);
        final EditText input2 = (EditText) findViewById(R.id.et_MBHB);

        String rmb = input1.getText().toString();
        String mbhb = input2.getText().toString();

        while (flg==false){//等待汇率获取完毕

        }

        switch ((int)V.getTag()){
            case 1:
                if(input1.getText().toString().length()>0){
                    RMB = Double.parseDouble(rmb);
                }
                if(input2.getText().toString().length()>0){
                    MBHB = Double.parseDouble(mbhb);
                }
                if(input1.getText().toString().length()<1){
                    Toast.makeText(Main2Activity.this,"请输入人民币金额",Toast.LENGTH_SHORT).show();
                    break;
                }
                MBHB =RMB /Country *100;
                String output1 = ""+MBHB;
                input2.setText(output1);
                break;
            case 2:
                if(input1.getText().toString().length()>0){
                    RMB = Double.parseDouble(rmb);
                }
                if(input2.getText().toString().length()>0){
                    MBHB = Double.parseDouble(mbhb);
                }
                if(input2.getText().toString().length()<1) {
                    Toast.makeText(Main2Activity.this, "请输入目标货币金额", Toast.LENGTH_SHORT).show();
                    break;
                }
                RMB = MBHB * Country /100;
                String output2 = ""+RMB;
                input1.setText(output2);
                break;
        }

    }

}
