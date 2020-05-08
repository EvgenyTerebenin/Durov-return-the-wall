package com.terebenin.durov_return_the_wall.presentation.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.terebenin.durov_return_the_wall.BuildConfig
import com.terebenin.durov_return_the_wall.R
import com.terebenin.durov_return_the_wall.presentation.ui.global.VkApplication.Companion.prefs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    NewsfeedFragment.newInstance()
                )
                .commitNow()
        }

        //FIXME удалить код перед релизом
        if (BuildConfig.DEBUG) {
            Toast.makeText(this, prefs.accessToken.token, Toast.LENGTH_SHORT).show()
        }
    }

}
