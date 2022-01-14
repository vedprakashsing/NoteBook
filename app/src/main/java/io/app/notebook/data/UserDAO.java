package io.app.notebook.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(UserEntity entity);

    @Query("SELECT id FROM users WHERE email = :email AND password = :password")
    public int getCurrentUserIdFromEmail(String email, byte[] password);

    @Query("SELECT id FROM users WHERE phone = :phone AND password = :password")
    public int getCurrentUserIdFromPhone(String phone, byte[] password);
}
