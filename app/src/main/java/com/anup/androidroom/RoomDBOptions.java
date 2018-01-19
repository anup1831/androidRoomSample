package com.anup.androidroom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Anup on 1/19/2018.
 */

public class RoomDBOptions extends Activity implements View.OnClickListener{

    Button btnInsertOneRecord, btnInsertMultipleRec, btnUpdate, btnDelete, btnShowAll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUi();
    }

    private void initUi() {
        btnInsertOneRecord = (Button) findViewById(R.id.btn_add_single);
        btnInsertMultipleRec = (Button) findViewById(R.id.btn_add_multiple);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnShowAll = (Button) findViewById(R.id.btn_show_all);
        btnInsertOneRecord.setOnClickListener(this);
        btnInsertMultipleRec.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnShowAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_add_single){
            startActivity(new Intent(this, MainActivity.class));
        } else if(v.getId() == R.id.btn_add_multiple){

        } else if (v.getId() == R.id.btn_update){

        } else if(v.getId() == R.id.btn_delete){

        } else if(v.getId() == R.id.btn_show_all){

        }
    }
}
