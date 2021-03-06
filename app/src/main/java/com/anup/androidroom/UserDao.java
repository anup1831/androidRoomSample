package com.anup.androidroom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Anup on 1/18/2018.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

   /* @Query("SELECT * FROM user WHERE uid IN (:uid)")
    List<User> loadAllByIds(int[] userId);

    @Query("SELECT * FROM user WHERE first_name LIKE first AND " + "last_name LIKE last LIMIT 1")
    User findByName(String first, String last);*/

    @Insert
    void insertSingleRecord(User user);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);


}
