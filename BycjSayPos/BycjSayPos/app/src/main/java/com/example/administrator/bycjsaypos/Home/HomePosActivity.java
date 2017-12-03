package com.example.administrator.bycjsaypos.Home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.bycjsaypos.Data.Data;
import com.example.administrator.bycjsaypos.R;
import com.example.administrator.bycjsaypos.adapter.HomePosAdapter;
import com.example.administrator.bycjsaypos.fragment.TestFragment;

import java.util.ArrayList;
/**
 * Created by Administrator on 2017/11/21.
 */
public class HomePosActivity extends FragmentActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {
    private PagerAdapter adapter;
    private ViewPager vp;
    ImageView imageview;
    ListView list_view;
    HomePosAdapter posAdapter;
    //当前菜单栏位置View
    private View currentView=null;
    //菜单栏文本内容
    String[] items = {"日化类","熟食类","日杂百货类","小食品类","烟酒类"};
    //菜单栏所在的Layout
     private LinearLayout menu;
    /**判断是否点击的立即购买按钮*/
    boolean isClickBuy = false;

     private  Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //去掉标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //设置ContentView
        setContentView(R.layout.homepos_layout);
        //初始化界面
        initView();
    }
    private void initView() {
        //找到菜单栏
        menu = (LinearLayout) findViewById(R.id.menu);
        imageview = (ImageView) findViewById(R.id.return_home);
        list_view = (ListView) findViewById(R.id.shopping_list);
        posAdapter = new HomePosAdapter(getApplicationContext(), Data.arrayList_cart);
        list_view.setAdapter(posAdapter);
        imageview.setOnClickListener(this);
        //初始化菜单
        initMenu(menu);
        //找到ViewPager
        vp= (ViewPager) findViewById(R.id.vp);
        //监听滑动
        vp.setOnPageChangeListener(this);
        //改变菜单栏第一个按钮的样式
        setMenuStyle(menu.findViewById(0));
        //实例化MiPagerAdapter
        adapter=new MiPagerAdapter(getSupportFragmentManager());
        //设置adapter
        vp.setAdapter(adapter);
    }
    private void initMenu(LinearLayout menu) {
        for(int index= 0;index<items.length;index++){
            //inflate
            View view=getLayoutInflater().inflate(R.layout.menu_item,null);
            //设置Id方便查找
            view.setId(index);
            //找到菜单文本框
            TextView tv= (TextView) view.findViewById(R.id.tv);
            //设置文本内容
            tv.setText(items[index]);
            //设置点击监听事件
            view.setOnClickListener(this);
            //添加view
            menu.addView(view);
        }
    }
    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.return_home:
                finish();
                break;
        }
        if(view.getId()>=0&&view.getId()<5){
            //把0到4的Id区分开
            //0到4是菜单按钮的id
            //注：不用占用它
            doMenuOnclick(view.getId());
        }else {
            //其他按钮的点击
        }
    }
    private void doMenuOnclick(int id) {
        if(adapter!=null){
            //联动
            vp.setCurrentItem(id);
        }
    }
    @SuppressLint("ResourceType")
    private void setMenuStyle(View view) {
        if(currentView!=null){

            HorizontalScrollView sv = (HorizontalScrollView) view.getParent().getParent();
            if((view.getId()+1)*getResources().getDimension(R.dimen.rdo1)>getResources().getDimension(R.dimen.comming)&&currentView.getId()<view.getId()){
                //滑向左时，将本应隐藏到右边屏幕的菜单拽到最右边
                sv.setScrollX((int) ((view.getId()+1)*getResources().getDimension(R.dimen.rdo1)-getResources().getDimension(R.dimen.comming)));
            }
            if(sv.getScrollX()>view.getId()*getResources().getDimension(R.dimen.rdo1)&&currentView.getId()>view.getId()){
                //跟上面的相反
                sv.setScrollX((int) (view.getId()*getResources().getDimension(R.dimen.rdo1)));
            }
        }
        //改变当前按钮样式
        TextView tv= (TextView) view.findViewById(R.id.tv);
        View v = view.findViewById(R.id.v);
        tv.setTextColor(getResources().getColor(R.color.buttonTextColor));
        v.setBackgroundColor(getResources().getColor(R.color.buttonTextColor));
        if(currentView!=null){
            //恢复之前按钮的样式
            TextView currentTv= (TextView) currentView.findViewById(R.id.tv);
            View currentV = currentView.findViewById(R.id.v);
            currentTv.setTextColor(getResources().getColor(R.color.button));
            currentV.setBackgroundColor(getResources().getColor(R.color.view));
        }
        //...

        currentView=view;
    }
    @Override
    public void onPageSelected(int i) {
        View view = menu.findViewById(i);
        setMenuStyle(view);
    }

    private class MiPagerAdapter extends FragmentPagerAdapter {

        public MiPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            //这个要以实际项目为主
//            return  fragments[position];
//            return new BlankFragment();
            return new TestFragment();
        }

        @Override
        public int getCount() {
            return items.length;
        }
    }
    @Override
    public void onPageScrollStateChanged(int i) {
    }
    @Override
    public void onPageScrolled(int i, float v, int i1) {
    }
}
