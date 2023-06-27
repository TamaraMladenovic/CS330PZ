package com.example.cs330pz.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.cs330pz.common.Constants
import com.example.cs330pz.data.local.BazaDatabase
import com.example.cs330pz.data.remote.MestoApi
import com.example.cs330pz.data.repository.DogadjajiRepositoryImpl
import com.example.cs330pz.data.repository.MestoRepositoryImpl
import com.example.cs330pz.data.repository.ProblemiRepositoryImpl
import com.example.cs330pz.domain.repository.DogadjajiRepository
import com.example.cs330pz.domain.repository.MestoRepository
import com.example.cs330pz.domain.repository.ProblemiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppConfig {

    @Provides
    @Singleton
    fun provideMestoApi(): MestoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MestoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMestoRepository(api: MestoApi): MestoRepository {
        return MestoRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        BazaDatabase::class.java,
        "baza.db"
    ).createFromAsset("database/baza.db").build()

    @Provides
    @Singleton
    fun provideDao(database: BazaDatabase) = database.dogadjajDao()

    @Provides
    @Singleton
    fun provideContext(application: Application):Context{
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideDogadjajiRepository(db: BazaDatabase): DogadjajiRepository {
        return DogadjajiRepositoryImpl(db.dogadjajDao())
    }

    @Provides
    @Singleton
    fun provideProblemRepository(db: BazaDatabase): ProblemiRepository {
        return ProblemiRepositoryImpl(db.dogadjajDao())
    }

}