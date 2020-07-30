package com.example.ctngus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import com.example.ctngus.QuanCoTuong.QuanCo;

import java.util.List;

public class QuanCoAdapter extends BaseAdapter {

    Context mContext;
    List<QuanCo> danhSachQuanCo;

    QuanCoAdapter(Context context, List<QuanCo> danhSachQuanCo){
        this.mContext = context;
        this.danhSachQuanCo = danhSachQuanCo;
    }

    @Override
    public int getCount() {
        return danhSachQuanCo.size();
    }

    @Override
    public Object getItem(int position) {
        return danhSachQuanCo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        QuanCo quanCo = danhSachQuanCo.get(position);

        if(convertView == null)
        {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.quan_co,null);
        }

        ImageButton button = convertView.findViewById(R.id.quanCo);
        button.setImageResource(R.drawable.ic_quan_soai_foreground);
//        button.setBackgroundColor(Color.parseColor("#f6e58d"));
        return button;
    }
}
