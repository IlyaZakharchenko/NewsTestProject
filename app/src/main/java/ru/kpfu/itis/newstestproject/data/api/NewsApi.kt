package ru.kpfu.itis.newstestproject.data.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kpfu.itis.newstestproject.data.model.pojo.NewsList
import ru.kpfu.itis.newstestproject.data.model.pojo.SourceList

interface NewsApi {

    @GET("sources")
    fun getSources(): Observable<SourceList>

    @GET("top-headlines")
    fun getNewsBySource(@Query("sources") sourceId: String?): Observable<NewsList>
}