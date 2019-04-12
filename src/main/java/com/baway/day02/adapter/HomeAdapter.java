package com.baway.day02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.day02.R;
import com.baway.day02.bean.HomeBean;
import com.bumptech.glide.Glide;

import java.util.List;

public class HomeAdapter extends BaseAdapter {
    private Context context;
    private List<HomeBean.ResultBean> homeBeanResult;

    public HomeAdapter(Context context, List<HomeBean.ResultBean> homeBeanResult) {
        this.context = context;
        this.homeBeanResult = homeBeanResult;
    }

    @Override
    public int getCount() {
        return homeBeanResult.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.home_list,null);
            viewHolder.home_im=convertView.findViewById(R.id.home_im);
            viewHolder.home_tv=convertView.findViewById(R.id.home_tv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(homeBeanResult.get(position).getLogo()).into(viewHolder.home_im);
        viewHolder.home_tv.setText(homeBeanResult.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        ImageView home_im;
        TextView home_tv;
    }
}
