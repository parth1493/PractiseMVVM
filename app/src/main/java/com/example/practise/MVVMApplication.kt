package com.example.practise

import android.app.Application
import com.example.practise.data.db.AppDatabase
import com.example.practise.data.network.MyApi
import com.example.practise.data.network.NetworkConnectionInterceptor
import com.example.practise.data.repositories.QuotesRepository
import com.example.practise.data.repositories.UserRepository
import com.example.practise.ui.auth.AuthViewModelFactory
import com.example.practise.ui.home.profile.ProfileViewModelFactory
import com.example.practise.ui.home.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }

    }

}