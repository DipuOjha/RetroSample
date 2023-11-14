package com.example.retrosample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class myVmFactory(var myrepo:repo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return myVm(myrepo) as T
    }

}