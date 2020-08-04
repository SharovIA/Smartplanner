package com.ivanasharov.smartplanner.data

import com.ivanasharov.smartplanner.data.entity.Task
import com.ivanasharov.smartplanner.domain.TaskDomain

class ConvertTaskDataToTaskDomian {

    fun convert(arrayListTasksData: List<Task>): ArrayList<TaskDomain> {
        val arrayListTaskDomain = ArrayList<TaskDomain>()
        var address : String?
        var taskDomain : TaskDomain

        arrayListTasksData.forEach {
            address = null
            if(it.isLocation && it.address != null)
                address = getAddress(it.address)
            taskDomain = TaskDomain(it.name, it.description, it.date,
                it.timeFrom, it.timeTo, it.importance, address, it.isShowMap,
                false, it.contact, false, it.status)
            arrayListTaskDomain.add(taskDomain)
        }
        return arrayListTaskDomain

    }

    private fun getAddress(address: Task.Address): String? {
        return "${address.country}, ${address.region}, ${address.town}, " +
                "${address.street}, ${address.house}"
    }
}