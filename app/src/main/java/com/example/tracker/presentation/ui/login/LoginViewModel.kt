package com.example.tracker.presentation.ui.login
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.tracker.base.BaseViewModel
import com.example.tracker.common.SingleLiveEvent
import com.example.tracker.domain.Mapper
import com.example.tracker.domain.entities.LoginEntity
import com.example.tracker.domain.usecases.LoginUseCase
import com.example.tracker.presentation.entities.Login

class LoginViewModel(private val loginUseCase: LoginUseCase, private val mapper: Mapper<LoginEntity, Login>) : BaseViewModel() {

    /** User Email*/
    var emailAddress = MutableLiveData<String>()

    /** User Password*/
    var password = MutableLiveData<String>()

    val loginSuccessLiveData: MutableLiveData<Boolean> = MutableLiveData()

    //var viewState: MutableLiveData<PopularMoviesViewState> = MutableLiveData()

    /** Method called when user clicks on login button */
    fun onLoginButtonClick(view: View) {
        addDisposable(
            loginUseCase.login(emailAddress.value!!, password.value!!)
                .subscribe({ success ->
                    loginSuccessLiveData.value = true
                },{ error ->
                    Log.e("Login", "onError: " + error.localizedMessage)

                    when(error.localizedMessage){

                    }
                }, {
                    Log.e("Login", "onComplete")
                })
        )
    }
}