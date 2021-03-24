package com.terebenin.durov_return_the_wall.di

import com.terebenin.durov_return_the_wall.presentation.auth.AuthActivity
import com.terebenin.durov_return_the_wall.presentation.newsfeed.NewsfeedFragment
import dagger.Component

/**
 * Created by evgenyterebenin at 23.03.2021
 */
@Component(modules = [NewsfeedModule::class])
interface AppComponent {

    fun injectsAuthActivity(authActivity: AuthActivity)

    fun injectsNewsfeedFragment(newsfeedFragment: NewsfeedFragment)
}