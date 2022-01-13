package io.app.notebook.data;

public class Data {
    private static Data INSTANCE = null;
    public AppDatabase db;

    // This is the id of the current user. Use this to create and fetch notes.
    public long uid;

    public static Data getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Data();
        }
        return INSTANCE;
    }
}
