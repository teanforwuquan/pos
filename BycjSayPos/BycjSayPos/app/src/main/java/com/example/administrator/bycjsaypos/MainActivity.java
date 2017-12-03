package com.example.administrator.bycjsaypos;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.bycjsaypos.Home.HomePosActivity;
import com.example.administrator.bycjsaypos.Util.Common;
import com.example.administrator.bycjsaypos.fragment.TestFragment;
import com.example.administrator.bycjsaypos.http.httpUtil;
import com.example.administrator.bycjsaypos.model.user;
import com.example.administrator.bycjsaypos.modle.RowsBeans;
import com.example.administrator.bycjsaypos.modle.shopping;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView loginview ,logoff;
    EditText businesscode, username,userpassword;
    Button button, Mybutton;
    public static String P;
    public static String token;

    public  String myjson;

    public static String businessCode, userName,passWord,mylog;
    ImageView imageView ,imagepos;
    public  boolean myLogin = false;
//    shopping goods;
//    BlankFragment frag;
    TestFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//         frag = new BlankFragment();
        frag = new TestFragment();
        loginview = (TextView) findViewById(R.id.login);
        imagepos = (ImageView) findViewById(R.id.img_a);
        logoff = (TextView) findViewById(R.id.log_off);
        imagepos.setOnClickListener(this);
        loginview.setOnClickListener(this);
        logoff .setOnClickListener(this);
       // 读取数据：
        SharedPreferences reads = getSharedPreferences("logtest",Activity.MODE_PRIVATE);
        String name = reads.getString("businessCode","");
        Log.e("T------A--------G", name.toString());
        if (name.equals("SZ_HMTY")){
            myLogin = true;
            Toast.makeText(MainActivity.this,"登录状态ture",Toast.LENGTH_SHORT).show();
            loginview.setText("用户名");
        }else {
            myLogin = false;
            Toast.makeText(MainActivity.this,"登录状态false",Toast.LENGTH_SHORT).show();
        }
    }
    //登录弹出框设置；
    private void ShowDiglogActivity() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final  View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_layout, null);
        username = (EditText) dialogView.findViewById(R.id.username);
        userpassword = (EditText) dialogView.findViewById(R.id.password);
        businesscode = (EditText)dialogView.findViewById(R.id.businesscode);
        button = (Button) dialogView.findViewById(R.id.buttton);
        Mybutton = (Button) dialogView.findViewById(R.id.but);
        imageView = (ImageView) dialogView.findViewById(R.id.image_detal);
        Mybutton.setOnClickListener(this);
        new  LoginTask().execute("businessCode","userName","userName");
        //取消弹出框按钮；
        builder.setView(dialogView);
        final AlertDialog dia = builder.create();
        dia.setView(dialogView);
        dia.show();
        dia.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        //取消弹出框界面；
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dia.dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dia.dismiss();
            }
        });
//        WindowManager manager = getWindowManager();
//        Display layout = manager.getDefaultDisplay();//获取屏幕高宽；
//        WindowManager.LayoutParams min = dia.getWindow().getAttributes();
//        min.width = (int) (layout.getWidth() * 0.6);
//        min.height = (int) (layout.getHeight() * 0.75);
//        dia.getWindow().setAttributes(min);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //登录按钮；
            case R.id.login:
                ShowDiglogActivity();
                break;
            //注销登录：
            case R.id.log_off:
                myLogin=false;
                loginview.setText("登录");
                Toast.makeText(MainActivity.this,"取消登录",Toast.LENGTH_SHORT).show();
                break;
            //收银主界面；
            case R.id.img_a:
                new LoginTaskPos().execute("P","token","module","actv","data");
                if (myLogin == false) {
                    ShowDiglogActivity();
                    Toast.makeText(MainActivity.this, "还没有登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent myint = new Intent(MainActivity.this, HomePosActivity.class);
                    startActivity(myint);
                    Log.i("TAG", "onClick:收银界面====================> ");
                }
                break;
            //确定；
            case R.id.but:
                if (myLogin == false) {
                    businessCode = businesscode.getText().toString();
                    userName = username.getText().toString();
                    passWord = userpassword.getText().toString();
                    mylog = loginview.getText().toString();
                    //写入数据；
                    SharedPreferences shared = getSharedPreferences("logtest", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("businessCode", "SZ_HMTY");
                    editor.putString("userName", "admin");
                    editor.putString("passWord", "123");
                    editor.putString("token", token);
                    editor.putString("mylog", "输入用户");
                    editor.commit();
                    myLogin = true;
//                    Toast.makeText(MainActivity.this,"读取数据："+ "\n"+"businessCode: "+businessCode+"\n"+"userName: "+userName
//                            +"\n"+"passWord"+"\n"+passWord+"\n"+"token"+token,Toast.LENGTH_SHORT).show();
                    //判断是否第一次登录；
//                    if (shared.getBoolean("firstStart",true)){
//                        editor = shared.edit();
//                        //下次登录就不显示在引导页，通过标志位false;
//                        editor.putBoolean("firstStart",false);
//                        editor.commit();
//                    }
//                    editor.putString("pss",httpUtil.pss);
//                    editor.putString("token",httpUtil.token);
//                    editor.commit();
//                    SharedPreferences read = getSharedPreferences("logtest",Activity.MODE_PRIVATE);
//                    String businessCode = read.getString("businessCode","");
//                    String userName = read.getString("userName","");
//                    String passWord = read.getString("passWord","");
//                    String token = read.getString("token","");
//                    Toast.makeText(this,"读取数据："+ "\n"+"businessCode: "+businessCode+"\n"+"userName: "+userName
//                            +"\n"+"passWord"+"\n"+passWord+"\n"+"token"+token,Toast.LENGTH_SHORT).show();
//                    Intent mintent = new Intent(MainActivity.this, serverActivity.class);
//                    startActivity(mintent)
                }
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                loginview.setText("用户名");
                break;
//                new LoginTask().execute("businessCode","userName","passWord");


//                if (!userName.equals("")&&!passWord.equals("")){
//                    //写入数据；
//                    SharedPreferences shared = getSharedPreferences("logtest",Activity.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = shared.edit();
//                    editor.putString("businessCode","SZ_HMTY");
//                    editor.putString("userName","admin");
//                    editor.putString("passWord","123");
//                    editor.putString("token",httpUtil.token);
//                    //判断是否第一次登录；
//                    if (shared.getBoolean("firstStart",true)){
//                        editor = shared.edit();
//                        //下次登录就不显示在引导页，通过标志位false;
//                        editor.putBoolean("firstStart",false);
//                        editor.commit();
//                    }
////                    editor.putString("pss",httpUtil.pss);
////                    editor.putString("token",httpUtil.token);
//                    editor.commit();
//                    SharedPreferences read = getSharedPreferences("logtest",Activity.MODE_PRIVATE);
//                    String businessCodes = read.getString("businessCode","");
//                    String userNames = read.getString("userName","");
//                    String passWords = read.getString("passWord","");
//                    String token = read.getString("token","");
//                    Toast.makeText(this,"读取数据："+ "\n"+"businessCode: "+businessCodes+"\n"+"userName: "+userNames+"\n"+"passWord"+"\n"+passWords+"\n"+"token"+token,Toast.LENGTH_SHORT).show();
//                    if (businessCodes.equals(businessCode)&&userNames.equals(userName)&&passWords.equals(passWord)){
//                        Intent mintent = new Intent(MainActivity.this, serverActivity.class);
//                        startActivity(mintent);
//                        Log.i("TAG", "onClick: <-------------------")
        }
    }
//}
    //获取登录状态
//    public static boolean isLogin(){
//        return Login;
//    }
//    //设置登录状态，登录成功师可以调用此方法把登录状态改为true
//    public static void setLogin(boolean isLogin){
//        Login =isLogin;
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (!MainActivity.isLogin()) {
//            Toast.makeText(this,"你还没有登录",Toast.LENGTH_LONG).show();
////            ShowDiglogActivity();
//            }else {
//            Toast.makeText(this,"欢迎回来",Toast.LENGTH_LONG).show();
//        }
//        }
    class LoginTask extends AsyncTask<String,Void,Object> {
        @Override
        protected Object doInBackground(String... params) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("businessCode", "SZ_HMTY");
            map.put("userName", "admin");
            map.put("passWord", "123");
            String json = httpUtil.post(Common.URL_LOGIN, map);
            Log.i("", "doInBackground:+++++++++++++======================> "+json.toString());
                    Gson gson = new Gson();
					user muser = new user();
					user min = gson.fromJson(json, user.class);
					Log.i("TAG", "=====================>" + min.toString());
					String[] str = min.getMessage().split("\\*");
					for (int i = 0; i <str.length; i++) {
					Log.i("TAG", "post: ------------------->"+ str[i]);
					 P = str[0].toString();
					 token = str[1].toString();
					Log.i("TAG", "post: "+P.toString());
						Log.i("TAG", "post:"+token.toString());
				}
            return json;
        }
        @Override
        protected void onPostExecute(Object o) {
            if (o != null) {
                Log.e("TAG", "连接成功");
            }
            super.onPostExecute(o);
        }
    }
//收银模块；
 class LoginTaskPos extends AsyncTask<String,Void,Object> {
    @Override
    protected Object doInBackground(String... params) {
        Map<String, String> hasmap = new HashMap<String, String>();
        hasmap.put("P", "SZ_HMTY|1|admin|1000000000|636467968782852324");
        hasmap.put("token", "9E1F890F84ABF1782A31948F6389BD34");
        hasmap.put("module", "pos");
        hasmap.put("actv", "GetProductList");
        hasmap.put("data", "{}");
        myjson = httpUtil.post(Common.URL_POS, hasmap);
        frag.json = myjson;
//        if (myjson != null) {
//            Gson gson = new Gson();
//            goods = gson.fromJson(myjson, shopping.class);
//            Log.e("Tag", "----" + goods.getData().getRows().get(1).getProductName());
//            TestFragment testFragment = new TestFragment();
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("json",goods);
//            testFragment.setArguments(bundle);
//        }
        return myjson;
    }}
    }


