package io.app.notebook.data;

import androidx.room.Entity;

@Entity(tableName = "notes")
public class NoteEntity {
    private String title;
    private String Description;
    private String userId;
    private int id;

    public NoteEntity(String title, String description, String userId, int id) {
        this.title = title;
        Description = description;
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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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
