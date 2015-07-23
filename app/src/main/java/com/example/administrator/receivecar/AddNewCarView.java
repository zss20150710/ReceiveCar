package com.example.administrator.receivecar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/22.
 */
public class AddNewCarView extends LinearLayout {
    private EditText et_phone_num;
    private EditText et_car_vin;
    private AddNewCarPopView addNewCarPopView;
    private Context context;
    public AddNewCarView(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public AddNewCarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }
   private void init() {
       LayoutInflater.from(context).inflate(R.layout.view_add_new_car,this,true);
       addNewCarPopView= (AddNewCarPopView) findViewById(R.id.addNewCarPopView);
       et_phone_num= (EditText) findViewById(R.id.et_phone_num);
       et_car_vin= (EditText) findViewById(R.id.et_car_vin);

    }
    /*
    *如果存在手机号码，则弹出选择车辆或者增加新车
    * @params
    * */


    public void findPhoneNum(){
        et_phone_num.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEARCH){
                    InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(et_phone_num.getWindowToken(), 0);
                    //获得用户输入的车牌号，进行判断
                    String userInput=et_phone_num.getText().toString();
                    if(userInput.equals("4869")){
                        addNewCarPopView.setVisibility(View.VISIBLE);
                        addNewCarPopView.showMyCar(findViewById(R.id.tv_users_name));
                        addNewCarPopView.setItemClickListener();

                    }else{

                    }
                    return true;
                }
                return false;
            }
        });
    }




     /*
    *x选择正确的车型
    * @params
    * */

        public void showMyCar(View parent,List<String> list){
            View view_cars=LayoutInflater.from(context).inflate(R.layout.listview_cars,null);
            ListView lv_all_cars= (ListView) view_cars.findViewById(R.id.lv_all_cars);
            ArrayAdapter adapter=new ArrayAdapter(context,android.R.layout.simple_list_item_1,list);
            lv_all_cars.setAdapter(adapter);
            PopupWindow popupWindow=new PopupWindow(view_cars,100, LayoutParams.WRAP_CONTENT);
            popupWindow.showAsDropDown(parent,0,-10);



    }
 }
