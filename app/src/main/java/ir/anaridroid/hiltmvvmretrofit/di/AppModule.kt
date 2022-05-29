package ir.anaridroid.hiltmvvmretrofit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.anaridroid.hiltmvvmretrofit.api.ApiService
import ir.anaridroid.hiltmvvmretrofit.helper.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providerBaseUrl() = Constants.BASE_URL


    @Provides
    fun provideRetrofitInstance(BASE_URL :String) :ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}