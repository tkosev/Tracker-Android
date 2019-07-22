package com.example.tracker.domain.usecases

import com.example.tracker.domain.common.Transformer
import io.reactivex.Observable

class RegisterUseCase(transformer: Transformer<Boolean>) :UseCase<Boolean>(transformer)  {


    override fun createObservable(data: Map<String, Any>?): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}