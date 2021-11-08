package io.app.notebook.room;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface UserDAO {

    @Insert
    public void insertUserDetail(UserEntity userNoteBook);
    @Query("DELETE FROM userNoteBook")
    public void nuke();
    @Query("SELECT * FROM userNoteBook WHERE userNoteBook.phone=phone")
    public NoteEntity getNotes(String phone);
}
