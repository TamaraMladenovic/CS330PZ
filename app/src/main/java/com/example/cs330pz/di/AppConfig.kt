package com.example.cs330pz.di

import androidx.compose.ui.unit.Constraints
import com.example.cs330pz.common.Constants
import com.example.cs330pz.data.remote.MestoApi
import com.example.cs330pz.data.repository.MestoRepositoryImpl
import com.example.cs330pz.domain.repository.MestoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

}