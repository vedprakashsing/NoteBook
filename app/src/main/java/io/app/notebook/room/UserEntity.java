package io.app.notebook.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="userNoteBook")
public class UserEntity {

    private String name;
    @PrimaryKey @NonNull
    private String phone;
    private byte[] password;
    private String email;

    public UserEntity(String name, @NonNull String phone, byte[] password, String email) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
