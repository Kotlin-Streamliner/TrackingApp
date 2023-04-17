package com.streamliner.trackingapp.database

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")
data class Run(
    var img: Bitmap? = null,
    var timeStamp: Long = 0L,   // describe when run was
    var averageSpeed: Float = 0f, // in km
    var distance: Int = 0,  // in meters
    var time: Long = 0L, // describe how long run was
    var calories: Int = 0, // calories burned while run
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
