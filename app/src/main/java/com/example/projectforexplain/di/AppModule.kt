package com.example.projectforexplain.di

import com.example.projectforexplain.BuildConfig.BASE_URL
import com.example.projectforexplain.data.remote.image.ImageApiService
import com.example.projectforexplain.data.remote.image.ImageRepository
import com.example.projectforexplain.data.remote.video.VideoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(client : OkHttpClient):Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(client).build()
    }

    @Provides
    fun provideClient():OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient()
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ImageApiService {
        return retrofit.create(ImageApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideRepository(apiService: ImageApiService): ImageRepository {
        return ImageRepository(apiService)
    }
    @Provides
    @Singleton
    fun provideRepositoryVideo(apiService: ImageApiService): VideoRepository {
        return VideoRepository(apiService)
    }

}