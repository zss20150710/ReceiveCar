package com.example.administrator.receivecar;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/23.
 */
public class AddNewCarPopView extends LinearLayout{
    private TextView tv_users_name;
    private Context context;
    public AddNewCarPopView(Context context,String name) {
        super(context);
        this.context=context;
        init();
        tv_users_name.setText(name);
    }

    public AddNewCarPopView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    private void init() {
        LayoutInflater.from(context).inflate(R.layout.view_pop_my_cars, this, true);
        tv_users_name= (TextView) findViewById(R.id.tv_users_name);

    }
    private  PopupWindow popupWindow;
    private ListView lv_all_cars;
    private List<String> list_cars;
    public void showMyCar(View parent){
        list_cars=new ArrayList();
        for(int i=0;i<5;i++){
            list_cars.add(i+"haibara");
        }
        View view_cars=LayoutInflater.from(context).inflate(R.layout.listview_cars,null);
        popupWindow = new PopupWindow(view_cars, 250,ViewGroup.LayoutParams.MATCH_PARENT, true);
        popupWindow.showAsDropDown(parent,0,5);
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //刷新状态
        popupWindow.update();
        view_cars.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                return false;
            }
        });
        lv_all_cars= (ListView) view_cars.findViewById(R.id.lv_all_cars);
        ArrayAdapter adapter=new ArrayAdapter(context,android.R.layout.simple_list_item_1,list_cars);
        lv_all_cars.setAdapter(adapter);
    }
    public void setItemClickListener(){
        //设置lv_all_cars的点击事件
        lv_all_cars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==list_cars.size()-1){
                    popupWindow.dismiss();

                }
            }
        });
    }

}
