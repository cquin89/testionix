package com.losingtimeapps.testionix.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.jraska.livedata.TestObserver
import com.losingtimeapps.testionix.InjectorHelper
import com.losingtimeapps.testionix.data.remote.DataService
import com.losingtimeapps.testionix.domain.model.DataModel
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PresentationTest {


    @get:Rule
    val rule = InstantTaskExecutorRule()


    private lateinit var viewModel: MainViewModel

    @Mock
    lateinit var dataService: DataService


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        InjectorHelper.dataService = dataService

        viewModel = InjectorHelper.injectMainViewModel()
        viewModel.testMode = true
    }

    @Test
    fun when_getDataSuccess_expectData() {

        Mockito.`when`(
            dataService.getData("FyaSTkGi8So=")
        ).thenReturn(Observable.just(DataModel()))
        viewModel.getUseData("1-9")
        val testSubscriber = viewModel.onGetDataObserver.test()

        testSubscriber.awaitValue()
        testSubscriber.assertHasValue()
    }

    private fun <T> LiveData<T>.test(): TestObserver<T> {
        return TestObserver.test(this)
    }
}
