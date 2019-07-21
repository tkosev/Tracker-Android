package com.example.tracker.domain.usecases
import com.example.tracker.domain.common.Transformer
import com.example.tracker.domain.repository.FireBaseAuthRepo
import io.reactivex.Observable

class LoginUseCase(transformer: Transformer<Boolean>, private val auth: FireBaseAuthRepo) : UseCase<Boolean>(transformer) {

    companion object {
        private const val PARAM_EMAIL = "param:email"
        private const val PARAM_PASSWORD = "param:password"
    }

    fun login(email: String, password: String): Observable<Boolean> {
        val data = HashMap<String, String>()
        data[PARAM_EMAIL] = email
        data[PARAM_PASSWORD] = password
        return observable(data)
    }

    override fun createObservable(data: Map<String, Any>?): Observable<Boolean> {
        val email = data?.get(PARAM_EMAIL) as String?

        val password = data?.get(PARAM_PASSWORD) as String?

        if (password != null && email != null) {
            return auth.loginEmailPassword(email, password).toObservable().map {  true}
        }
        return Observable.error {
            IllegalArgumentException("Credentials must be provided.")
        }
    }
}