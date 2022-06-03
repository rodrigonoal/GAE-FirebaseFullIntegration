package br.com.siecola.androidproject04.productdetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.siecola.androidproject04.persistence.Product

private const val TAG = "ProductDetailViewModel"

class ProductDetailViewModel(private val code: String): ViewModel() {
    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product>
        get() = _product


    init {
        getProduct()
    }

    private fun getProduct() {

    }

    override fun onCleared() {
        Log.i(TAG, "onCleared")
        super.onCleared()
    }

}