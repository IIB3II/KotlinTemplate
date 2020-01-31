package lv.aliyev.template.activity.models

import com.google.gson.annotations.SerializedName
import retrofit2.Call

//https://jsonplaceholder.typicode.com/todos/1
data class Example (
        val id: Int = 0,
        @SerializedName(value = "title") val titlez: String = "",
        val completed: Boolean = false
)
