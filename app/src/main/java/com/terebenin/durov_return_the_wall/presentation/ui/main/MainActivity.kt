package com.terebenin.durov_return_the_wall.presentation.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.terebenin.durov_return_the_wall.R
import com.terebenin.durov_return_the_wall.data.datasource.storage.Prefs
import com.terebenin.durov_return_the_wall.presentation.ui.global.Application
import com.terebenin.durov_return_the_wall.presentation.ui.global.Application.Companion.accessToken

class MainActivity : AppCompatActivity() {

    private val prefs: Prefs = Prefs(this, Application.gson)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    MainFragment.newInstance()
                )
                .commitNow()
        }

        Toast.makeText(this, accessToken, Toast.LENGTH_SHORT).show()
    }

}
