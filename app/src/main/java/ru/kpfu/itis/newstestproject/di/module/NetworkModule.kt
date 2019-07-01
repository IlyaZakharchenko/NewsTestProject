package ru.kpfu.itis.newstestproject.di.module

import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.kpfu.itis.newstestproject.data.api.NewsApi
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    @Named("newsUrl")
    fun provideNewsUrl(): String = "https://newsapi.org/v2/"

    @Singleton
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor {
        Log.i("Network", it)
    }.apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun httpHeaderInterceptor() = Interceptor { chain ->
        val request = chain
            .request()
            .newBuilder()
            .addHeader("X-Api-Key", "84b9fdcabd684146be53ca176e05a37a")
            .build()

        chain.proceed(request)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, headerInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.MINUTES)
            .connectTimeout(2, TimeUnit.MINUTES)
            .addNetworkInterceptor(loggingInterceptor)
            .addNetworkInterceptor(headerInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(@Named("newsUrl") newsUrl: String, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(newsUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)
}