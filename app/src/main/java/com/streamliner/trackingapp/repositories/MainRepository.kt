package com.streamliner.trackingapp.repositories

import com.streamliner.trackingapp.database.Run
import com.streamliner.trackingapp.database.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
        val runDAO: RunDAO
){

    suspend fun insertRun(run: Run) = runDAO.insertRun(run)

    suspend fun deleteRun(run: Run) = runDAO.deleteRun(run)

    fun getAllRunsSortedByDate() = runDAO.getAllRunsSortedByDate()

    fun getAllRunsSortedByDistance() = runDAO.getAllRunsSortedByDistance()

    fun getAllRunsSortedByTime() = runDAO.getAllRunsSortedByTime()

    fun getAllRunsSortedByAverageSpeed() = runDAO.getAllRunsSortedByAverageSpeed()

    fun getAllRunsSortedByCalories() = runDAO.getAllRunsSortedByCalories()

    fun getTotalAverageSpeed() = runDAO.getTotalAverageSpeed()

    fun getTotalDistance() = runDAO.getTotalDistance()

    fun getTotalCalories() = runDAO.getTotalCalories()

    fun getTotalTime() = runDAO.getTotalTime()
}