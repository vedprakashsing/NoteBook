package io.app.notebook.data;

public class Data {
    private static Data INSTANCE = null;
    public AppDatabase db;

    public static Data getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Data();
        }
        return INSTANCE;
    }
}
