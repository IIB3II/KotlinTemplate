package lv.aliyev.template.activity.repository

import com.google.gson.GsonBuilder
import lv.aliyev.template.activity.models.Example
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ExampleRepository {

    val webservice by lazy {
        Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(ExampleWebservice::class.java)
    }

    val webservice2 by lazy {
        Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build().create(ExampleWebservice::class.java)
    }

    suspend fun getTodo(id: Int) = webservice.getTodo(id)

    suspend fun getTodo2(id: Int): Example {
        return webservice2.getTodo(id)
    }

}