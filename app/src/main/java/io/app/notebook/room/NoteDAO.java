package io.app.notebook.room;

import androidx.room.Insert;
import androidx.room.Query;

public interface NoteDAO {

    @Insert
    public void insertUserDetail(NoteEntity noteBook);
    @Query("DELETE FROM notes WHERE notes.noteId=noteId")
    public void nuke(String noteID);
    @Query("SELECT * FROM notes WHERE notes.phone=phone")
    public NoteEntity getNotes(String phone);
}
