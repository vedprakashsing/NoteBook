package io.app.notebook.data;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

public interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertNote(NoteEntity entity);

    // Get all notes for current user
    @Query("SELECT * from notes WHERE userId = :uid")
    public List<NoteEntity> getAllNotes(long uid);
}
