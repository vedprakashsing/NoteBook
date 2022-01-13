package io.app.notebook.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserEntity {
    @PrimaryKey
    private int id;
    private String name;
    private String phone;
    // This annotation tells Room to map the byte array to a blob instead of a string
    @ColumnInfo(name = "password", typeAffinity = ColumnInfo.BLOB) private byte[] password;
    private String email;

    public UserEntity(int id, String name, String phone, byte[] password, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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
