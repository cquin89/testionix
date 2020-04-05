package com.losingtimeapps.testionix

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.losingtimeapps.testionix.data.remote.DataRepositoryImp
import com.losingtimeapps.testionix.data.remote.DataService
import com.losingtimeapps.testionix.domain.boundary.BaseScheduler
import com.losingtimeapps.testionix.domain.boundary.DataRepository
import com.losingtimeapps.testionix.domain.usecase.GetDataUseCase
import com.losingtimeapps.testionix.presentation.MainActivity
import com.losingtimeapps.testionix.presentation.MainViewModel
import com.losingtimeapps.testionix.presentation.MainViewModelFactory
import com.losingtimeapps.testionix.util.NetworkModule

class InjectorHelper() {

    companion object {

        lateinit var dataService: DataService

        private fun injectBaseScheduler(): BaseScheduler = TestScheduleImp()

        private fun injectDataUseCase(dataService: DataRepository): GetDataUseCase =
            GetDataUseCase(dataService, injectBaseScheduler())

        fun injectMainViewModel(): MainViewModel {
            return MainViewModel(
                injectDataUseCase(
                    DataRepositoryImp(NetworkModule.provideService())
                )
            )
        }

    }
}