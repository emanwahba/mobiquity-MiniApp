package com.mobiquity.miniapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mobiquity.miniapp.model.remote.CatalogService
import com.mobiquity.miniapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCatalogService(retrofit: Retrofit): CatalogService =
        retrofit.create(CatalogService::class.java)
}