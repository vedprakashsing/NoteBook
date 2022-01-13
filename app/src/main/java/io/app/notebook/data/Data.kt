package io.app.notebook.data

import io.app.notebook.data.AppDatabase

object Data {
    lateinit var db: AppDatabase
    var currentUserId = -1
}