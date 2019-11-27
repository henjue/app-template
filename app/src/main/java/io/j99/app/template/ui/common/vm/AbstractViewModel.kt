package io.j99.app.template.ui.common.vm

import android.app.Application
import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class AbstractViewModel(application: Application) : AndroidViewModel(application) {
    val loadingStatus = MutableLiveData<Boolean>()
    protected val compositeDisposable = CompositeDisposable()
    @CallSuper
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun showLoading() {
        loadingStatus.value = true
    }

    fun hideLoading() {
        loadingStatus.value = false
    }
}