package cz.cvut.fit.adametim.spacex_crew

import android.app.Application
import com.google.firebase.crashlytics.FirebaseCrashlytics
import cz.cvut.fit.adametim.spacex_crew.features.company.di.companyModule
import cz.cvut.fit.adametim.spacex_crew.features.crew.di.crewModule
import cz.cvut.fit.adametim.spacex_crew.shared.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(sharedModule + crewModule + companyModule)
        }

        if (!BuildConfig.DEBUG) {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
        }
    }
}