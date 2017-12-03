package com.example.administrator.bycjsaypos.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.bycjsaypos.R;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by Administrator on 2017/12/1.
 */
public class HomePosAdapter extends BaseAdapter{
    private Context context ;
    private ArrayList<HashMap<String,Object>> arrayList = new ArrayList<HashMap<String, Object>>();
    private View.OnClickListener listener;
    public HomePosAdapter(Context context,ArrayList<HashMap<String,Object>> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    public HomePosAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return (arrayList != null && arrayList.size() == 0) ? 0: arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        HolderView holderView = null;
        if (convertView ==null) {
            holderView = new HolderView();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list,parent, false);
            holderView.text_a = (TextView) convertView.findViewById(R.id.text_a);
            holderView.text_c = (TextView) convertView.findViewById(R.id.text_c);
            holderView.text_d = (TextView) convertView.findViewById(R.id.text_d);
            convertView.setTag(holderView);
        }else {
            holderView = (HolderView) convertView.getTag();
        }
        if (arrayList.size() != 0){
            holderView.text_a.setText("名称"+ arrayList.get(position).get("num"));
            holderView.text_c.setText("价格"+arrayList.get(position).get("picture"));
            holderView.text_d.setText("条形码"+arrayList.get(position).get("commentry"));
            Log.d("TAG", "getView:------------------------------------> "+arrayList.get(position).get("num").toString());
        }
        int width = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int height = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        convertView.measure(width,height);
        Log.e("LGH",""+convertView.getMeasuredHeight());
        return convertView;
    }
   public class HolderView{
        private TextView  text_a;
        private TextView  text_b;
       private  TextView  text_c;
       private  TextView  text_d;


   }
}
