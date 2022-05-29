package ir.anaridroid.hiltmvvmretrofit.api

import ir.anaridroid.hiltmvvmretrofit.models.Book
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("allBook.php")
    suspend fun getAllBook() :Response<List<Book>>
}