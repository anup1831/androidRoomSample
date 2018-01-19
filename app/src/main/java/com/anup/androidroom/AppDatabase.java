package com.anup.androidroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Anup on 1/18/2018.
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    abstract UserDao userDao();
}
