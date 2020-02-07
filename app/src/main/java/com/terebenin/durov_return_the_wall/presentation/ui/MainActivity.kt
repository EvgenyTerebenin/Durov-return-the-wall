package com.terebenin.durov_return_the_wall.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.terebenin.durov_return_the_wall.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
