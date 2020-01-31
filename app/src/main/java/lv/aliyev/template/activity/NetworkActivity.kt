package lv.aliyev.template.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.example_activity.*
import lv.aliyev.template.R
import lv.aliyev.template.activity.models.Example
import lv.aliyev.template.activity.viewmodel.ExampleViewModel


open class NetworkActivity : LoadingActivity() {

  // fun execute(request: LiveData<Example>, complete: Complete) {
  //     loading(true)
  //     request.observe(this, Observer {
  //         complete.start()
  //         loading(false)
  //     })
  // }

  // fun silent(request: LiveData<Example>, complete: Complete) {
  //     request.observe(this, Observer {
  //         complete.start()
  //     })
  // }

}

