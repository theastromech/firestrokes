package com.firestrokes.firestrokes

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.firestrokes.firestrokes.di.appModule

class FireStrokesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidLogger()
            androidContext(this@FireStrokesApplication)
            modules(appModule)
        }
    }
}
