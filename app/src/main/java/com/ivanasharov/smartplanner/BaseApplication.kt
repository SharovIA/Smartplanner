package com.ivanasharov.smartplanner

import android.app.Application
import com.ivanasharov.smartplanner.di.DaggerAppComponent


class BaseApplication : Application() {

 /*   companion object{
        private lateinit var baseApplication : BaseApplication

        fun getInstance() : BaseApplication = baseApplication
    }

   companion object{
        private lateinit var component: AppComponent
        private lateinit var baseApplication : BaseApplication

        fun getComponent() : AppComponent = component
        fun getInstance() : BaseApplication = baseApplication
    }
*/
    override fun onCreate() {
        super.onCreate()
    //    baseApplication = this

        initializeComponent()

    }

    private fun initializeComponent() {
      /*  component =
            DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(baseApplication))
            .databaseModule(DatabaseModule(baseApplication))
            .build()
       */
        DI.appComponent = DaggerAppComponent.builder()
            .appContext(this)
          // .appComponent()
            //.taskReposiitiryModule()
            //.databaseModule()
            .build()
    }
}