package com.example.administrator.receivecar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/7/22.
 */
public class OldUserMsgView extends LinearLayout {
    private TextView tv_car_num;
    private TextView tv_phone_num;
    private TextView tv_user_name;
    private TextView tv_car_vin;
    private ImageView iv_car_version;
    private ImageView iv_turn_left;
    private Context context;
    public OldUserMsgView(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public OldUserMsgView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

   private void init() {
       LayoutInflater.from(context).inflate(R.layout.view_all_message,this,true);
       tv_car_num= (TextView) findViewById(R.id.tv_car_num);
       tv_phone_num= (TextView) findViewById(R.id.tv_phone_num);
       tv_user_name= (TextView) findViewById(R.id.tv_user_name);
       tv_car_vin= (TextView) findViewById(R.id.tv_car_vin);
       iv_car_version= (ImageView) findViewById(R.id.iv_car_version);
       iv_turn_left= (ImageView) findViewById(R.id.iv_turn_left);
    }
    /*
    *设置并展示用户信息
    * @params
    * */
    public void settingMessage(String tv_car_num1,String tv_phone_num1,String tv_user_name1,String tv_car_vin1,int id){
        tv_car_num.setText(tv_car_num1);
        tv_phone_num.setText(tv_phone_num1);
        tv_user_name.setText(tv_user_name1);
        tv_car_vin.setText(tv_car_vin1);
        iv_car_version.setImageResource(id);
        iv_car_version.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
     /*
    *x选择正确的车型
    * @params
    * */
    public void chooseCar(){
        PopupWindow window=new PopupWindow();

    }
 }
