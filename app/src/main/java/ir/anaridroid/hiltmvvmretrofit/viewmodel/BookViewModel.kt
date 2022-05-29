package ir.anaridroid.hiltmvvmretrofit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.anaridroid.hiltmvvmretrofit.models.Book
import ir.anaridroid.hiltmvvmretrofit.repository.MainRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject
@HiltViewModel
class BookViewModel  @Inject constructor(private val mainRepository: MainRepository) :ViewModel() {

    private val _response = MutableLiveData<List<Book>>()
    val responseBook : LiveData<List<Book>>
        get() = _response
    init {
        getAllBook()
    }

    private fun getAllBook() =viewModelScope.launch {
        mainRepository.getAllBook().let { response ->
        if (response.isSuccessful){
            _response.postValue(response.body())
            Log.d("TAG", "getAllBook: ${response.body()}")
        }else{
            Log.d("TAG", "getAllBook: ${response.message()}")
        }

        }
    }

}