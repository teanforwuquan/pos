package com.example.administrator.bycjsaypos.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.bycjsaypos.R;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.data;

public class Adapter_GridView extends BaseAdapter {
private Context context;
private  ArrayList<HashMap<String,Object>> arrayList;
	
	public Adapter_GridView(Context context,ArrayList<HashMap<String,Object>> arrayList){
		
		this.context=context;
		this.arrayList=arrayList;
	}
	
	@Override
	public int getCount() {
		return arrayList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return arrayList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View currentView, ViewGroup arg2) {
		HolderView holderView=null;
		if (currentView==null) {
			holderView=new HolderView();
			currentView=LayoutInflater.from(context).inflate(R.layout.gride_view,arg2,false);
			holderView.iv_pic=(ImageView) currentView.findViewById(R.id.bit);
			holderView.text_name = (TextView) currentView.findViewById(R.id.name_v);
			holderView.text_picture = (TextView) currentView.findViewById(R.id.pricews);
			holderView.text_code = (TextView) currentView.findViewById(R.id.encoded);
			currentView.setTag(holderView);
		}else {
			holderView=(HolderView) currentView.getTag();
		}
		
//		holderView.iv_pic.setImageResource(data[position]);
		HashMap<String, Object> map = arrayList.get(position);
	//	 holderView.iv_pic.setImageResource((Integer) map.get("picture"));
		holderView.text_name.setText("名称"+ map.get("name"));
		holderView.text_picture.setText("油价"+ map.get("pic"));
		holderView.text_code.setText("条码"+ map.get("code"));

		
		return currentView;
	}
	
	
	public class HolderView {
		
		private ImageView iv_pic;
		private TextView text_name;
		private TextView text_code;
		private TextView text_picture;

		
	}

}
