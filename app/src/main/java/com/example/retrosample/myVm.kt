package com.example.retrosample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class myVm(var myrepo:repo):ViewModel() {
    var dataforview: MutableLiveData<Todos> = MutableLiveData()

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {

            var resp = myrepo.getTodosR()
           if( resp.isSuccessful){
               Log.d("HIII","success")
               dataforview.postValue(resp.body())
           }

        }


    }
}
