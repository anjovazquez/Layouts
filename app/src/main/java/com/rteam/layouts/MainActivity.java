package com.rteam.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.frame)
    Button frame;

    @Bind(R.id.linear)
    Button linear;

    @Bind(R.id.relative)
    Button relative;

    @Bind(R.id.table)
    Button table;

    @Bind(R.id.grid)
    Button grid;

    @OnClick({R.id.frame, R.id.linear, R.id.relative, R.id.table, R.id.grid})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.frame:
                intent = new Intent(this, FrameLayoutActivity.class);
                break;
            case R.id.linear:
                intent = new Intent(this, LinearLayoutActivity.class);
                break;
            case R.id.relative:
                intent = new Intent(this, RelativeLayoutActivity.class);
                break;
            case R.id.table:
                intent = new Intent(this, TableLayoutActivity.class);
                break;
            case R.id.grid:
                intent = new Intent(this, GridLayoutActivity.class);
                break;
            default:
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
