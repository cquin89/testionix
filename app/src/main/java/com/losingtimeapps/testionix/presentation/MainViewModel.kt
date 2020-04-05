package com.losingtimeapps.testionix.presentation


import androidx.lifecycle.ViewModel
import com.losingtimeapps.testionix.domain.model.DataModel
import com.losingtimeapps.testionix.domain.usecase.GetDataUseCase
import com.losingtimeapps.testionix.util.SingleLiveEvent
import com.losingtimeapps.testionix.util.Utils.Companion.desEncryption
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {

    var onGetDataObserver = SingleLiveEvent<DataModel>()
    var onErrorObservable = SingleLiveEvent<Throwable>()
    var testMode: Boolean = false
    private val compositeDisposable = CompositeDisposable()


    fun getUseData(rut: String) {
        compositeDisposable.add(
            getDataUseCase.invoke(if (!testMode) desEncryption(rut) else rut).subscribe(
                {
                    onGetDataObserver.postValue(it)

                }, {
                    onErrorObservable.postValue(it)
                }
            ))

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        // Dispose All your Subscriptions to avoid memory leaks
    }

}
