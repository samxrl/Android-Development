package com.example.calcolator;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.MediaCodec;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.calculator.calculator;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;

    private String Input = "";
    private String A = "";
    private String B = "";
    private String HOW;
    private double Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationview);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
        }
        navigationView.setCheckedItem(R.id.nav_cal);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_cal:
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_HL:
                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);
                        break;
                }

                return true;
            }
        });

        //设置Text字体——————————————————————————
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        AssetManager mgrText1=getAssets();
        Typeface tyT1=Typeface.createFromAsset(mgrText1,"fonts/STXIHEI.TTF");
        textView1.setTypeface(tyT1);

        TextView textViewR = (TextView) findViewById(R.id.textView2);
        AssetManager mgrTextR=getAssets();
        Typeface tyTR=Typeface.createFromAsset(mgrTextR,"fonts/STXIHEI.TTF");
        textViewR.setTypeface(tyTR);

        //设置按钮字体——————————————————————————
        Button buttondian = (Button) findViewById(R.id.buttondian);
        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        AssetManager mgrdian=getAssets();
        AssetManager mgr0=getAssets();
        AssetManager mgr1=getAssets();
        AssetManager mgr2=getAssets();
        AssetManager mgr3=getAssets();
        AssetManager mgr4=getAssets();
        AssetManager mgr5=getAssets();
        AssetManager mgr6=getAssets();
        AssetManager mgr7=getAssets();
        AssetManager mgr8=getAssets();
        AssetManager mgr9=getAssets();

        Typeface tydian=Typeface.createFromAsset(mgrdian,"fonts/STXIHEI.TTF");
        Typeface ty0=Typeface.createFromAsset(mgr0,"fonts/STXIHEI.TTF");
        Typeface ty1=Typeface.createFromAsset(mgr1,"fonts/STXIHEI.TTF");
        Typeface ty2=Typeface.createFromAsset(mgr2,"fonts/STXIHEI.TTF");
        Typeface ty3=Typeface.createFromAsset(mgr3,"fonts/STXIHEI.TTF");
        Typeface ty4=Typeface.createFromAsset(mgr4,"fonts/STXIHEI.TTF");
        Typeface ty5=Typeface.createFromAsset(mgr5,"fonts/STXIHEI.TTF");
        Typeface ty6=Typeface.createFromAsset(mgr6,"fonts/STXIHEI.TTF");
        Typeface ty7=Typeface.createFromAsset(mgr7,"fonts/STXIHEI.TTF");
        Typeface ty8=Typeface.createFromAsset(mgr8,"fonts/STXIHEI.TTF");
        Typeface ty9=Typeface.createFromAsset(mgr9,"fonts/STXIHEI.TTF");

        buttondian.setTypeface(tydian);
        button0.setTypeface(ty0);
        button1.setTypeface(ty1);
        button2.setTypeface(ty2);
        button3.setTypeface(ty3);
        button4.setTypeface(ty4);
        button5.setTypeface(ty5);
        button6.setTypeface(ty6);
        button7.setTypeface(ty7);
        button8.setTypeface(ty8);
        button9.setTypeface(ty9);
        //设置按钮字体——————————————————————————

        Button buttonchu = (Button) findViewById(R.id.buttonchu);
        Button buttoncheng = (Button) findViewById(R.id.buttoncheng);
        Button buttonjian = (Button) findViewById(R.id.buttonjian);
        Button buttonjia = (Button) findViewById(R.id.buttonjia);
        Button buttonAC = (Button) findViewById(R.id.buttonAC);
        Button buttonshanchu = (Button) findViewById(R.id.buttonshanchu);
        Button buttondengyu = (Button) findViewById(R.id.buttondengyu);

        buttondian.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonchu.setOnClickListener(this);
        buttoncheng.setOnClickListener(this);
        buttonjian.setOnClickListener(this);
        buttonjia.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        buttonshanchu.setOnClickListener(this);
        buttondengyu.setOnClickListener(this);

        button0.setTag(0);
        button1.setTag(1);
        button2.setTag(2);
        button3.setTag(3);
        button4.setTag(4);
        button5.setTag(5);
        button6.setTag(6);
        button7.setTag(7);
        button8.setTag(8);
        button9.setTag(9);
        buttondian.setTag(10);
        buttonchu.setTag(11);
        buttoncheng.setTag(12);
        buttonjian.setTag(13);
        buttonjia.setTag(14);
        buttonAC.setTag(15);
        buttonshanchu.setTag(16);
        buttondengyu.setTag(17);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){ //导航按钮响应：打开侧滑菜单
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    @Override
    public void onClick(View V){

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textViewR = (TextView) findViewById(R.id.textView2);

        if(textViewR.getText().equals("") == false){
            Input = "";
            A = "";
            B = "";
            HOW = "";
            textView1.setText("");
            textViewR.setText("");
        }

        switch ((int)V.getTag()){
            case 0:
                Input=Input+"0";
                textView1.setText(Input);
                if(A.equals("")==false && B.equals("")==false){
                    B = B +"0";
                }
                break;
            case 1:
                Input=Input+"1";
                textView1.setText(Input);
                if(A.equals("")==false){
                    B = B +"1";
                }
                break;
            case 2:
                Input=Input+"2";
                textView1.setText(Input);
                if(A.equals("")==false){
                    B = B +"2";
                }
                break;
            case 3:
                Input=Input+"3";
                textView1.setText(Input);
                if(A.equals("")==false){
                    B = B +"3";
                }
                break;
            case 4:
                Input=Input+"4";
                textView1.setText(Input);
                if(A.equals("")==false){
                    B = B +"4";
                }
                break;
            case 5:
                Input=Input+"5";
                textView1.setText(Input);
                if(A.equals("")==false){
                    B = B +"5";
                }
                break;
            case 6:
                Input=Input+"6";
                textView1.setText(Input);
                if(A.equals("")==false){
                    B = B +"6";
                }
                break;
            case 7:
                Input=Input+"7";
                textView1.setText(Input);
                if(A.equals("")==false){
                    B = B +"7";
                }
                break;
            case 8:
                Input=Input+"8";
                textView1.setText(Input);
                if(A.equals("")==false){
                    B = B +"8";
                }
                break;
            case 9:
                Input=Input+"9";
                textView1.setText(Input);
                if(A.equals("")==false){
                    B = B +"9";
                }
                break;
            case 10: //.
//                if( Input.indexOf(".")>0){
//                    Log.d("PP","true");
//                }else Log.d("PP","false");

                if(Input.equals("")){
                    Input=Input+"0.";
                    textView1.setText(Input);
                    break;
                }else if(A.equals("") && Input.indexOf(".") == -1){ //在输入第一个数且没有小数点
                    Input = Input + ".";
                    textView1.setText(Input);
                    break;
                }else if(A.equals("") && Input.indexOf(".")>0){ //在输入第一个数且有小数点
                    break;
                }else if(A.equals("")==false && B.indexOf(".") == -1){ //在输入第二个数且没有小数点
                    Input = Input + ".";
                    textView1.setText(Input);
                    B = B + ".";
                    break;
                }else if(A.equals("")==false && B.indexOf(".")>0){ //在输入第二个数且有小数点
                    break;
                }
                break;
            case 11: //除
                if(Input.equals("")){
                    break;
                }
                if(B.equals("") == false){
                    break;
                }
                if((""+Input.charAt(Input.length()-1)).equals(""+"+") || (""+Input.charAt(Input.length()-1)).equals(""+"-") ||
                        (""+Input.charAt(Input.length()-1)).equals(""+"÷") ||(""+Input.charAt(Input.length()-1)).equals(""+"×")){
                    Input = Input.substring(0,Input.length()-1);
                    Input = Input + "÷";
                    HOW = "÷";
                    textView1.setText(Input);
                    break;
                }
                A = Input;
                HOW = "÷";
                Input = Input+"÷";
                textView1.setText(Input);
                break;
            case 12: //乘
                if(Input.equals("")){
                    break;
                }
                if(B.equals("") == false){
                    break;
                }
                if((""+Input.charAt(Input.length()-1)).equals(""+"+") || (""+Input.charAt(Input.length()-1)).equals(""+"-") ||
                        (""+Input.charAt(Input.length()-1)).equals(""+"÷") ||(""+Input.charAt(Input.length()-1)).equals(""+"×")){
                    Input = Input.substring(0,Input.length()-1);
                    Input = Input + "×";
                    HOW = "×";
                    textView1.setText(Input);
                    break;
                }
                A = Input;
                HOW = "×";
                Input = Input+"×";
                textView1.setText(Input);
                break;
            case 13: //减
                if(Input.equals("")){
                    break;
                }
                if(B.equals("") == false){
                    break;
                }
                if((""+Input.charAt(Input.length()-1)).equals(""+"+") || (""+Input.charAt(Input.length()-1)).equals(""+"-") ||
                        (""+Input.charAt(Input.length()-1)).equals(""+"÷") ||(""+Input.charAt(Input.length()-1)).equals(""+"×")){
                    Input = Input.substring(0,Input.length()-1);
                    Input = Input + "-";
                    HOW = "－";
                    textView1.setText(Input);
                    break;
                }
                A = Input;
                HOW = "－";
                Input = Input+"-";
                textView1.setText(Input);
                break;
            case 14: //加
                if(Input.equals("")){
                    break;
                }
                if(B.equals("") == false){
                    break;
                }
                if((""+Input.charAt(Input.length()-1)).equals(""+"+") || (""+Input.charAt(Input.length()-1)).equals(""+"-") ||
                        (""+Input.charAt(Input.length()-1)).equals(""+"÷") ||(""+Input.charAt(Input.length()-1)).equals(""+"×")){
                    Input = Input.substring(0,Input.length()-1);
                    Input = Input + "+";
                    HOW = "+";
                    textView1.setText(Input);
                    break;
                }
                A = Input;
                HOW = "+";
                Input = Input+"+";
                textView1.setText(Input);
                break;
            case 15: //AC
                Input = "";
                A = "";
                B = "";
                HOW = "";
                textView1.setText("");
                textViewR.setText("");
                break;
            case 16: //删除
                if(Input.equals("")){
                    break;
                }
                if(B.equals("")==false){
                    Input=Input.substring(0,Input.length()-1);
                    B=B.substring(0,B.length()-1);
                    textView1.setText(Input);
                }else if(B.equals("")&&A.equals("")==false){
                    HOW = "";
                    Input=Input.substring(0,Input.length()-1);
                    textView1.setText(Input);
                }else if(A.equals("")){
                    Input=Input.substring(0,Input.length()-1);
                    textView1.setText(Input);
                }
                break;
            case 17: //等于
                if(B.equals("")){
                    textViewR.setText(Input);
                    break;
                }
                if(A.equals("")){
                    break;
                }
                Result= calculator.Calculator(A,B,HOW);
                textViewR.setText(""+Result);
                break;
        }
    }
}
