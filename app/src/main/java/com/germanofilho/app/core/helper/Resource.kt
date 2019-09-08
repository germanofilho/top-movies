package com.germanofilho.app.core.helper

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

data class Resource<out T>(val status: Status, val data: T?, val boolean: Boolean?, val exception: Exception?) {

    enum class Status { SUCCESS, ERROR, LOADING }

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null, null)
        }

        fun <T> error(exception: Exception?): Resource<T> {
            return Resource(Status.ERROR, null, null, exception)
        }

        fun <T> loading(boolean: Boolean?): Resource<T> {
            return Resource(Status.LOADING, null, boolean, null)
        }
    }
}

fun <T> LiveData<Resource<T>>.observeResource(
    owner: LifecycleOwner,
    onSuccess: (T) -> Unit,
    onError: (Exception) -> Unit,
    onLoading: (Boolean) -> Unit) {

    observe(owner, Observer { resource ->
        when (resource.status) {
            Resource.Status.SUCCESS -> {
                resource.data?.let {
                    onSuccess.invoke(it)
                }
            }
            Resource.Status.ERROR -> {
                resource.exception?.let {
                    onError.invoke(it)
                }
            }
            Resource.Status.LOADING -> {
                resource.boolean?.let {
                    onLoading.invoke(it)
                }
            }
        }

    })
}