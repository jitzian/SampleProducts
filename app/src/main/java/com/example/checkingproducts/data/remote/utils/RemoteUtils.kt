package com.example.checkingproducts.data.remote.utils

import android.content.Context

/**
 * Singleton object that will read the mocked response from assets file
 * */
object RemoteUtils {

    var mockedContent: String = ""
    fun readMockedContent(context: Context) {
        val inputStream = context.assets.open("mocks/products.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        mockedContent = String(buffer)
    }

}