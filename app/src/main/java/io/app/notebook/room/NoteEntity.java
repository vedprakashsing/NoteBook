package io.app.notebook.room;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "notes")
public class NoteEntity {
    private String title;
    private String Description;
    private String Phone;
    private String noteId;
    private int id;

    public NoteEntity(String title, String description, String phone,int id) {
        this.title = title;
        Description = description;
        Phone = phone;
        noteId=phone+id;
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
