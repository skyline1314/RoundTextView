package com.skyline.roundedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.skyline.roundedittext.custom.RoundTextView;

public class MainActivity extends AppCompatActivity {

    private RoundTextView set_attr_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        set_attr_view = (RoundTextView) findViewById(R.id.set_attr_view);
        set_attr_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_attr_view.setLeft_top_radiu(20);//px
            }
        });
    }
}
