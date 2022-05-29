package ir.anaridroid.hiltmvvmretrofit.repository

import ir.anaridroid.hiltmvvmretrofit.api.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllBook() = apiService.getAllBook()
}