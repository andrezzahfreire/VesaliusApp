package com.example.vesalius

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SalaViewModel : ViewModel() {

    var name = MutableLiveData<String>()
    var desc = MutableLiveData<String>()

}