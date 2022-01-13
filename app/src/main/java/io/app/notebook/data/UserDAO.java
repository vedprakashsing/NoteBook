package io.app.notebook.data;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

public interface UserDAO {

    @Insert
    public void insertUserDetail(UserEntity userNoteBook);
    @Query("DELETE FROM userNoteBook")
    public void nuke();
    @Query("SELECT * FROM userNoteBook WHERE userNoteBook.phone=phone")
    public NoteEntity getNotes(String phone);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(UserEntity entity);

    @Query("SELECT id FROM users WHERE email = :email AND password = :password")
    public void getCurrentUserIdFromEmail(String email, byte[] password);

    @Query("SELECT id FROM users WHERE phone = :phone AND password = :password")
    public void getCurrentUserIdFromPhone(String phone, byte[] password);
}
