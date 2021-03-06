package com.ivanasharov.smartplanner.domain.model

import java.util.*

data class TaskDomain(
    val name : String?,
    val description : String?,
    val date : GregorianCalendar?,
    val timeFrom : GregorianCalendar?,
    val timeTo : GregorianCalendar?,
    val importance: Int,
    val address: String?,
    val isAddContact : Boolean?,
    val contact : String?,
    val isAddCalendar : Boolean,
    val selectNameOfCalendar : String?,
    var status : Boolean,
    val id: Long?
)