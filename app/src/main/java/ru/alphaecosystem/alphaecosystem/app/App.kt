package ru.alphaecosystem.alphaecosystem.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.alphaecosystem.alphaecosystem.di.dataModule
import ru.alphaecosystem.alphaecosystem.di.domainModule
import ru.alphaecosystem.alphaecosystem.di.presentationModule


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                presentationModule,
                domainModule,
                dataModule,
            )
        }
    }
}