package kr.co.irobo.advice.common

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class DisposableViewModel : ViewModel() {
    protected val dispose = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        dispose.dispose()
    }
}