package com.anup.androidroom;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

/**
 * Created by Anup on 1/19/2018.
 */

public class ShowAllRecords extends Activity {

    AppDatabase appDB;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        appDB = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "Sample_User").build();

        recyclerView = (RecyclerView) findViewById(R.id.show_all_recycler);

    }

    class AsyncRoomDatabase extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User> doInBackground(Void... voids) {

            appDB.userDao().getAll();
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
