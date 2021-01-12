package com.ivanasharov.smartplanner.data

import com.ivanasharov.smartplanner.domain.TaskDomain
import kotlinx.coroutines.flow.Flow
import java.util.*
import kotlin.collections.ArrayList

interface TaskRepository {

    fun save (taskDomain: TaskDomain): Long?

   // fun getListCurrentTasks(date: GregorianCalendar) : Flow<ArrayList<TaskDomain>>
    fun getListCurrentTasks(date: GregorianCalendar) : Flow<List<TaskDomain>>

    fun getListCurrentTasksForSchedule(date: GregorianCalendar) : Flow<List<NameTimeImportance>>

    fun changeStatusTask(taskDomain: TaskDomain)

    fun updateTask(taskDomain: TaskDomain)

    fun getTaskById(id: Long): Flow<TaskDomain>

}