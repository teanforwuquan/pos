package com.example.administrator.bycjsaypos.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.bycjsaypos.R;
import com.example.administrator.bycjsaypos.model.user;
import com.example.administrator.bycjsaypos.modle.RowsBeans;
import com.example.administrator.bycjsaypos.modle.Users;
import com.example.administrator.bycjsaypos.modle.shopping;

import java.util.List;

public class MyRecycleView  extends RecyclerView.Adapter<MyRecycleView.MyHolderView>{

    shopping goods ;
    Context context;
    List<RowsBeans> rows;
    public MyRecycleView(Context activity,shopping good){
        context = activity;
        goods=good;
       rows = goods.getData().getRows();
    }

    @Override
    public MyHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(context,R.layout.gride_view,null);
        return new MyHolderView(v);
    }

    @Override
    public void onBindViewHolder(MyHolderView holder, int i) {
        if (holder == null) {
            return;
        }
        Log.e("TAG","goods:"+goods);
        holder.text_name.setText(goods.getData().getRows().get(i).getProductName());
        holder.text_code.setText(goods.getData().getRows().get(i).getBarCode());
          String price =  goods.getData().getRows().get(i).getOrigPrice();
        Log.e("TA","price----+++-------"+price);
        if (price == null){
            Log.e("TA","price-----------"+price);
            price = "100";
        }
//        holder.text_picture.setText(price);
        Glide.with(context).load(goods.getData().getRows().get(i).getPicture().trim()).into(holder.img);
//        viewHolder.textView.setText(data[i]);
//        viewHolder.imageView.setBackgroundResource(imgdata[i]);
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }
      class MyHolderView extends RecyclerView.ViewHolder {
          private TextView text_name,text_code;
          public TextView text_picture;
          ImageView img,mm;
          public MyHolderView(View view) {
              super(view);
              img = (ImageView) view.findViewById(R.id.bit);
              text_name = (TextView) view.findViewById(R.id.name_v);
              text_code = (TextView) view.findViewById(R.id.encoded);
              text_picture = (TextView) view.findViewById(R.id.price_view);
              Log.e("TAG","text_picture:+++"+text_picture);
//              linear = (LinearLayout) view.findViewById(R.id.big_p);
          }
      }
}
