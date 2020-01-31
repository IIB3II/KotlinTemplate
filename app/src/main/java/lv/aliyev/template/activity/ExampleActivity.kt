package lv.aliyev.template.activity

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.example_activity.*
import lv.aliyev.template.R
import lv.aliyev.template.activity.viewmodel.ExampleViewModel
import java.util.concurrent.ThreadLocalRandom

class ExampleActivity: LoadingActivity() {

    private lateinit var viewModel: ExampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_activity)
        setupViewModel()
        setupViews()
    }

    private fun setupViews() {
        mButton.setOnClickListener {
            val random = ThreadLocalRandom.current().nextInt(1, 10)
            execute(viewModel.getTodo2(random), Complete {
                Toast.makeText(this@ExampleActivity, R.string.complete, Toast.LENGTH_LONG).show()
                mText.text = it.titlez;
            });
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(ExampleViewModel::class.java)
    }
}