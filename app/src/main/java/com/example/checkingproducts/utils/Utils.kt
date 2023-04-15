package com.example.checkingproducts.utils

import android.content.Context

/**
 * Small function to retrieve TAG and avoid unnecessary declarations on each class
 * */
inline fun <reified T> T.TAG(): String = T::class.java.simpleName

fun Context.readFileFromAssets(filePath: String): String {
    return resources.assets.open(filePath).bufferedReader().use {
        it.readText()
    }
}