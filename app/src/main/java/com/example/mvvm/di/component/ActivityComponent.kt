package com.example.mvvm.di.component



import com.example.mvvm.di.ActivityScope
import com.example.mvvm.di.module.ActivityModule
import com.example.mvvm.ui.topheadline.TopHeadlineActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: TopHeadlineActivity)

}