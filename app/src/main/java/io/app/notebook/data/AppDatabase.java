package io.app.notebook.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class, NoteEntity.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract NoteDAO noteDAO();
}
