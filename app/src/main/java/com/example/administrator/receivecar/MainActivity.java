package com.example.administrator.receivecar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private EditText et_car_num;
    private RelativeLayout rl_replace_content;
    private OldUserMsgView oldUserMsgView;
    private AddNewCarView addNewCarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        searchResult();

    }

    private void searchResult() {
        //根据的车牌号查找结果
        et_car_num.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //隐藏软键盘
                    if(actionId== EditorInfo.IME_ACTION_SEARCH){
                                ((InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE))
                                .hideSoftInputFromWindow(
                                        MainActivity.this
                                                .getCurrentFocus()
                                                .getWindowToken(),
                                        InputMethodManager.HIDE_NOT_ALWAYS);
                        //获得用户输入的车牌号，进行判断
                        String userInput=et_car_num.getText().toString();
                        if(userInput.equals("4869")){
                            addNewCarView.setVisibility(View.GONE);
                            oldUserMsgView.setVisibility(View.VISIBLE);
                        }else{
                            oldUserMsgView.setVisibility(View.GONE);
                            addNewCarView.setVisibility(View.VISIBLE);
                        }
                    return true;
                    }
                return false;
            }
        });
        //根据的手机号号查找结果、
        addNewCarView.findPhoneNum();


    }

    public void click(View view){
        switch (view.getId()){
            case R.id.iv_turn_left:
                MainActivity.this.finish();
                break;
            case R.id.iv_receive_camera:
                Log.d("MainActivity", "camera");

                break;
            case R.id.iv_receive_user:
                Log.d("MainActivity","user");
                break;
            case R.id.iv_receive_skip:
                Log.d("MainActivity","skip");
                break;
        }
    }

    private void init() {
        getSupportActionBar().hide();
        addNewCarView= (AddNewCarView) findViewById(R.id.add_car_view);
        oldUserMsgView= (OldUserMsgView) findViewById(R.id.user_msg_view);
        et_car_num= (EditText) findViewById(R.id.et_car_num);
        rl_replace_content= (RelativeLayout) findViewById(R.id.rl_replace_content);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
