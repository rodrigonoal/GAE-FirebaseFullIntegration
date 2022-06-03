package br.com.siecola.androidproject04.product

import androidx.databinding.InverseMethod
import android.util.Log

object PriceConverter {
    @InverseMethod("stringToPrice")
    @JvmStatic
    fun priceToString(newValue: Double): String {
        return "$ " + "%.2f".format(newValue)
    }
    @JvmStatic
    fun stringToPrice(newValue: String): Double {
        var price = 0.0
        try {
            price = newValue.removePrefix("$").trim().toDouble()
        } catch (e: NumberFormatException) {
            Log.e("PriceConverter", " Failed to convert price")
        }
        return price
    }
}
