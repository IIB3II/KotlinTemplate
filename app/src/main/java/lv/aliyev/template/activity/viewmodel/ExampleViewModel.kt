package lv.aliyev.template.activity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import lv.aliyev.template.activity.models.Example
import lv.aliyev.template.activity.repository.ExampleRepository

class ExampleViewModel : ViewModel() {
    val repository: ExampleRepository = ExampleRepository()

    fun getTodo(id: Int) : LiveData<Example> {
        return liveData(Dispatchers.IO) {
            val retrivedTodo = repository.getTodo(id)
            Thread.sleep(2000)
            emit(retrivedTodo)
        }
    }

    fun getTodo2(id: Int) : LiveData<Example>{
        return liveData(Dispatchers.IO) {
            val retrivedTodo = repository.getTodo(id)
            Thread.sleep(2000)
            emit(retrivedTodo)
        }
    }




}