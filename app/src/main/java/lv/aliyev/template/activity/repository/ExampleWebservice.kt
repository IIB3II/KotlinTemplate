package lv.aliyev.template.activity.repository

import lv.aliyev.template.activity.models.Example
import retrofit2.http.GET
import retrofit2.http.Path

interface ExampleWebservice {
    @GET("/todos/{id}") suspend fun getTodo(@Path(value = "id") todoId: Int): Example
}


