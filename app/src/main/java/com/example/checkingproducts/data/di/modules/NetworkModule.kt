package com.example.checkingproducts.data.di.modules

import com.example.checkingproducts.data.remote.RestApi
import com.example.checkingproducts.data.remote.utils.RemoteUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //Scope of the injected component
class NetworkModule {

    @Provides
    @Singleton //Scope of the instance
    fun providesRetrofit(): RestApi {

        val interceptor = Interceptor { chain ->
            val uri = chain.request().url.toUri().toString()
            val responseString =
                getMockResponse(uri) // Helper function to read the mock response from the file
            val response = Response.Builder()
                .code(200)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .body(responseString.toResponseBody("application/json".toMediaTypeOrNull()))
                .build()
            response
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestApi::class.java)
    }

    // Helper function to read the mock response from the file
    private fun getMockResponse(uri: String): String {
        return RemoteUtils.mockedContent
    }
}

