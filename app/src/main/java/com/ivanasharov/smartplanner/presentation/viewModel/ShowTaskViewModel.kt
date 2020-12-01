package com.ivanasharov.smartplanner.presentation.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import com.ivanasharov.smartplanner.presentation.viewModel.base.BaseViewModel

class ShowTaskViewModel @ViewModelInject constructor(
): BaseViewModel() {
/*
    val taskUI = TaskUI()
    var  gMap : GoogleMap? = null
    var isCorrectAddress = false

    init {
        taskUI.isAddToCalendar.value =false
    }

   private fun longToCalendar(timeInMillis : Long?) : GregorianCalendar?{
        if (timeInMillis != null) {
            val calendar: Calendar = Calendar.getInstance()
           calendar.timeInMillis = timeInMillis
            return GregorianCalendar(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE)
            )
        }
        else return null
    }

    fun init(intent: Intent) {
        taskUI.name.value = intent.getStringExtra("name")
        taskUI.description.value = intent.getStringExtra("description")
        taskUI.date.value = longToCalendar(intent.getLongExtra("date", 0))
        taskUI.timeFrom.value = intent.getStringExtra("timeFrom")
        taskUI.timeTo.value = intent.getStringExtra("timeTo")
        taskUI.importance.value = intent.getStringExtra("importance")
        taskUI.address.value = intent.getStringExtra("address")
        taskUI.isSnapContact.value = intent.getBooleanExtra("isSnapContact", false)
        taskUI.contact.value = intent.getStringExtra("contact")
        taskUI.status.value = intent.getBooleanExtra("status", false)
    }

    private fun loadMap() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    fun onMapReady() {
        gMap?.setMinZoomPreference(12f)
        gMap?.isIndoorEnabled = true
        val uiSettings = gMap?.uiSettings
        uiSettings?.isIndoorLevelPickerEnabled = true
        uiSettings?.isMyLocationButtonEnabled = true
        uiSettings?.isMapToolbarEnabled = true
        uiSettings?.isCompassEnabled = true
        uiSettings?.isZoomControlsEnabled = true

        if (taskUI.address.value != null) {
            val coordinates = getCoordinaty()
            if (coordinates != null) {
                isCorrectAddress = true
                gMap?.addMarker(MarkerOptions().position(coordinates))
                gMap?.moveCamera(CameraUpdateFactory.newLatLng(coordinates))
            }
        }
    }

*/
}