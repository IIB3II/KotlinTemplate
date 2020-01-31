package lv.aliyev.template.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.loading_activity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import lv.aliyev.template.R

open class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.loading_activity)
        supportActionBar?.hide()
    }

    override fun setContentView(resId: Int) {
        LayoutInflater.from(this).inflate(resId, mContentContainer)
    }

    fun loading(show: Boolean) {
        mProgressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    fun addFragment(name: String, fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .addToBackStack(name)
                .add(R.id.mContentContainer, fragment, name)
                .commit()

    }

    fun removeFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
    }

    fun execute(background: Background, complete: Complete<Unit>) {
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                loading(true)
            }
            withContext(Dispatchers.IO) {
                background.start()
            }
            withContext(Dispatchers.Main) {
                loading(false)
                complete.complete(Unit)
            }
        }
    }

    fun silent(background: Background, complete: Complete<Unit>) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                background.start()
            }
            withContext(Dispatchers.Main) {
                complete.complete(Unit)
            }
        }
    }

    fun<T> execute(@NonNull request: LiveData<T>, @NonNull complete: Complete<T>) {
        loading(true)
        request.observe(this, Observer {
            complete.complete(it)
            loading(false)
        })
    }


    fun<T> silent(request: LiveData<T>, complete: Complete<T>) {
        request.observe(this, Observer {
            complete.complete(it)
        })
    }

    interface Background {
        fun start()
        companion object {
            inline operator fun <T> invoke(crossinline op: () -> Unit) =
                    object : Background {
                        override fun start() = op()
                    }
        }
    }

    interface Complete <T>{
        fun complete(result: T)
        companion object {
            inline operator fun <T> invoke(crossinline op: (result: T) -> Unit) =
                    object : Complete<T> {
                        override fun complete(result: T) = op(result)
                    }
        }
    }

}