package com.anup.androidroom;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppDatabase appDB;
    EditText etFirstName, etLastName, etPhoneNo, etAddress1, etAddress2, etCity, etState;
    Button btnAddAddress, btnPushToDb;
    RelativeLayout rlAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         initUi();

        appDB = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Sample_User").build();

        //


    }

    private void initUi() {
        etFirstName = (EditText) findViewById(R.id.et_first_name);
        etLastName = (EditText) findViewById(R.id.et_last_name);
        etPhoneNo = (EditText) findViewById(R.id.et_phone_number);
        btnAddAddress = (Button) findViewById(R.id.btn_address);
        btnAddAddress.setOnClickListener(this);
        rlAddress = (RelativeLayout) findViewById(R.id.rl_address);
        etAddress1 = (EditText) findViewById(R.id.et_address1);
        etAddress2 = (EditText) findViewById(R.id.et_address2);
        etCity = (EditText) findViewById(R.id.et_city);
        etState = (EditText) findViewById(R.id.et_state);
        btnPushToDb = (Button) findViewById(R.id.btn_save);
        btnPushToDb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_address){
            if(rlAddress.getVisibility() == View.GONE){
                rlAddress.setVisibility(View.VISIBLE);
            } else {
                rlAddress.setVisibility(View.GONE);
            }

        } else if(v.getId() == R.id.btn_save){
            new AsyncRoomDatabase().execute();
            Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_LONG).show();
        }

    }

    class AsyncRoomDatabase extends AsyncTask<Void, Void, List<User>>{

        @Override
        protected List<User> doInBackground(Void... voids) {
            User user= new User();
            Address address = new Address();
            user.setFirstName("Sumit");
            user.setLastName("Kumar");
            if(etFirstName.length() > 0 && etLastName.length() > 0 && etPhoneNo.length() > 0){
                user.setFirstName(etFirstName.getText().toString());
                user.setLastName(etLastName.getText().toString());
                user.setPhoneNo(etPhoneNo.getText().toString());

                if(etAddress1.length() > 0){

                   address.setAddress1(etAddress1.getText().toString());
                } else{
                    address.setAddress1("No Address Availlable");
                } if(etAddress2.length() > 0){
                    address.setAddress2(etAddress2.getText().toString());
                } else{
                    address.setAddress2("No Address Availlable");
                } if(etCity.length() > 0){
                    address.setCity(etCity.getText().toString());
                } else{
                    address.setCity("No Address Availlable");
                } if(etState.length() > 0){
                    address.setState(etState.getText().toString());
                } else{
                    address.setState("No Address Availlable");
                }
                user.setAddress(address);
            }
            appDB.userDao().insertSingleRecord(user);
            List<User> fetchedUse = appDB.userDao().getAll();
            return fetchedUse;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i("Anup", "Insert starting");
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            for (User user : users){
                Log.i("Anup", "-"+user.getUid());
                Log.i("Anup", "-"+user.getFirstName());
                Log.i("Anup", "-"+user.getLastName());
                Log.i("Anup", "-"+user.getAddress().getAddress1());
                Log.i("Anup", "-"+user.getAddress().getAddress2());
                Log.i("Anup", "-"+user.getAddress().getCity());
                Log.i("Anup", "-"+user.getAddress().getState());

            }
        }

        /* @Override
        protected Void doInBackground(Void... voids) {

            User user= new User();
            user.setUid(3);
            user.setFirstName("Cristo");
            user.setLastName("Kumar");

            appDB.userDao().insertSingleRecord(user);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.i("Anup", "inserted!");
            *//*runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    List<User> fetchedUse = appDB.userDao().getAll();
                    for (User user : fetchedUse){
                        Log.i("Anup", "-"+user.getUid());
                        Log.i("Anup", "-"+user.getFirstName());
                        Log.i("Anup", "-"+user.getLastName());
                    }
                }
            });*//*



        }*/
    }

}
