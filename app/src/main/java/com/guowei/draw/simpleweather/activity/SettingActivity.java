package com.guowei.draw.simpleweather.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.guowei.draw.simpleweather.C;
import com.guowei.draw.simpleweather.R;
import com.guowei.draw.simpleweather.evens.UpdateTempEvent;
import com.guowei.draw.simpleweather.utils.DebugUtil;
import com.guowei.draw.simpleweather.utils.ResourcesUtil;
import com.guowei.draw.simpleweather.utils.SpUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends AppCompatActivity {
    @BindView(R.id.degree_spinner)
    Spinner degreeSpinner;
    private int degreeIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        String degreeString = SpUtil.getString(C.SP_NAME, C.DEGREE, C.Centigrade);
        degreeIndex = 0;
        if (degreeString.equals("℃")){
            degreeIndex =0;
        }else if(degreeString.equals("℉")){
            degreeIndex =1;
        }
        degreeSpinner.setSelection(degreeIndex);
        degreeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        SpUtil.postString(C.SP_NAME,C.DEGREE,"℃");
                        break;
                    case 1:
                        SpUtil.postString(C.SP_NAME,C.DEGREE,"℉");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        int selectedItemPosition = degreeSpinner.getSelectedItemPosition();
        if (selectedItemPosition!=degreeIndex){
            EventBus.getDefault().post(new UpdateTempEvent());
        }
        super.onDestroy();
    }
}
