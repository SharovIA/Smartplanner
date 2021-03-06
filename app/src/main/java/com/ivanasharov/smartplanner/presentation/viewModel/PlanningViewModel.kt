package com.ivanasharov.smartplanner.presentation.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ivanasharov.smartplanner.R
import com.ivanasharov.smartplanner.utils.resources.ResourceProvider
import com.ivanasharov.smartplanner.data.database.requests_model.IdNameStatus
import com.ivanasharov.smartplanner.domain.interactors.interfaces.PlanningInteractor
import com.ivanasharov.smartplanner.presentation.viewModel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

class PlanningViewModel  @ViewModelInject constructor(
    private val mResources: ResourceProvider,
    private val mPlanningInteractor: PlanningInteractor
) : BaseViewModel() {

    private val mTaskList = MutableLiveData<List<IdNameStatus>>()
    private val mStatusOfTasks = MutableLiveData<String>()
    private val mDate = MutableLiveData<String>()
    private val mIsLoading = MutableLiveData<Boolean>(false)
    private val mHasTasks = MutableLiveData<Boolean>(false)
    private val mIsChooseDate = MutableLiveData<Boolean>(false)
    private val mCalendar = Calendar.getInstance()

    val taskList: LiveData<List<IdNameStatus>>
        get() = mTaskList
    val statusOfTasks: LiveData<String>
        get() = mStatusOfTasks
    val date: LiveData<String>
        get() = mDate
    val isLoading: LiveData<Boolean>
        get() = mIsLoading
    val hasTasks: LiveData<Boolean>
        get() = mHasTasks
    val isChooseDate: LiveData<Boolean>
        get() = mIsChooseDate


    val currentDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    val currentMonth = mCalendar.get(Calendar.MONTH)
    val currentYear = mCalendar.get(Calendar.YEAR)

    fun setDate(year: Int, month: Int, day: Int) {
        val date = GregorianCalendar(year, month, day)
        mHasTasks.value = false
        mIsChooseDate.value = true
        getData(date)
        val dayOfWeek = date.get(Calendar.DAY_OF_WEEK)
        val nameOfDay = getNameDay(dayOfWeek)
        mDate.value= "$nameOfDay, ${getTextValue(day)}-${getTextValue(month+1)}-${getTextValue(year)}"
    }

    private fun getData(date: GregorianCalendar) {
        viewModelScope.launch(Dispatchers.IO) {
            mIsLoading.postValue(true)
            mPlanningInteractor.getCurrentTasks(date).collect {
                mTaskList.postValue(it)
                mStatusOfTasks.postValue(getStatusOfTasks())
                mIsLoading.postValue(false)
            }
        }
    }

    private fun getStatusOfTasks(): String = mResources.string(R.string.completed) + " " +
            "${getCountFinishedTasks()}/${getCountTasks()} " + mResources.string(R.string.completedTasks)

    private fun getCountFinishedTasks(): Int = mPlanningInteractor.getCountFinishedTasks()

    private fun getCountTasks(): Int {
        val count =mPlanningInteractor.getCountTasksAll()
        if (count > 0){
            mHasTasks.postValue(true)
        }
        return count
    }

    private fun getTextValue(number: Int): String {
        when (number < 10) {
            true -> return "0$number"
            false -> return "$number"
        }
    }

    private fun getNameDay(day: Int): String {
        when (day) {
            1 -> return mResources.string(R.string.sunday)
            2 -> return mResources.string(R.string.monday)
            3 -> return mResources.string(R.string.tuesday)
            4 -> return mResources.string(R.string.wednesday)
            5 -> return mResources.string(R.string.thursday)
            6 -> return mResources.string(R.string.friday)
            7 -> return mResources.string(R.string.saturday)
            else -> return mResources.string(R.string.week_undefined)
        }
    }

    fun changeStatus(index: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            mPlanningInteractor.changeTask(index)
        }
    }
}
