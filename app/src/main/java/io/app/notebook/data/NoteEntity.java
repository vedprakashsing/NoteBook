package io.app.notebook.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class NoteEntity {
    private String title;
    private String description;
    private String userId;
    @PrimaryKey(autoGenerate = true
    ) private int id;

    public NoteEntity(String title, String description, String userId, int id) {
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
