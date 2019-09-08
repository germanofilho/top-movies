package com.germanofilho.app.core.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.germanofilho.app.core.helper.Resource

abstract class BaseViewModel : ViewModel(){

    protected fun <T> MutableLiveData<Resource<T>>.success(data: T?) {
        postValue(Resource.success(data))
    }

    protected fun <T> MutableLiveData<Resource<T>>.error(e: Exception?) {
        value = Resource.error(e)
    }

    protected fun <T> MutableLiveData<Resource<T>>.loading(boolean: Boolean?) {
        value = Resource.loading(boolean)
    }

}