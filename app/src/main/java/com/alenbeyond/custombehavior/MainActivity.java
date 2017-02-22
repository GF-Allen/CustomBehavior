package com.alenbeyond.custombehavior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    private Button btn;
//    private float startX;
//    private float startY;

    private ArrayList<String> data;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.lv);

        init();
//        btn = (Button) findViewById(R.id.btn);
//        btn.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        startX = event.getX();
//                        startY = event.getY();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        float moveX = event.getX();
//                        float moveY = event.getY();
//                        btn.offsetLeftAndRight((int) (moveX - startX));
//                        btn.offsetTopAndBottom((int) (moveY - startY));
//                        break;
//                }
//                return true;
//            }
//        });


    }

    private void init() {
        data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            data.add("弟" + i + "条");
        }
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(new MyAdapter(this,data));
    }
}
