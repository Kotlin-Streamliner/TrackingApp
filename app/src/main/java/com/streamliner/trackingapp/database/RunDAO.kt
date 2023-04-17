package com.streamliner.trackingapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table ORDER BY timeStamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY time DESC")
    fun getAllRunsSortedByTime(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY calories DESC")
    fun getAllRunsSortedByCalories(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY averageSpeed DESC")
    fun getAllRunsSortedByAverageSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distance DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<Run>>

    @Query("SELECT SUM(time) FROM running_table")
    fun getTotalTime(): LiveData<Long>

    @Query("SELECT SUM(calories) FROM running_table")
    fun getTotalCalories(): LiveData<Int>

    @Query("SELECT SUM(distance) FROM running_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT AVG(averageSpeed) FROM running_table")
    fun getTotalAverageSpeed(): LiveData<Float>
}