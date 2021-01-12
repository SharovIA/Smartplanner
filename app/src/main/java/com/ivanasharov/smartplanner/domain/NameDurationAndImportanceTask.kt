package com.ivanasharov.smartplanner.domain

//data class NameDurationAndImportanceTask(
//    val startHour: Int,
//    val startMinute: Int,
//    val finishMinuteInStartHour: Int?,
//    val countHours: Int?,
//    val finishHour: Int?,
//    val finishMinute: Int?,
//    var importance : Int?,
//    var name: String?
//)

data class NameDurationAndImportanceTask(
    val inOneHour: Boolean,
    val isNotFullStartHour: Boolean,
    val isNotFullFinishHour: Boolean,
    val isFullHours : Boolean,
    val startHour: Int,
    val startMinute: Int?,
    val finishMinuteInStartHour: Int?,
    val countHours: Int?,
    val finishHour: Int?,
    val finishMinute: Int?,
    var importance : Int?,
    var name: String?
)