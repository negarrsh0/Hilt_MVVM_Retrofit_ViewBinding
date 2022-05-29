package ir.anaridroid.hiltmvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.anaridroid.hiltmvvmretrofit.adapter.BookAdapter
import ir.anaridroid.hiltmvvmretrofit.databinding.ActivityMainBinding
import ir.anaridroid.hiltmvvmretrofit.viewmodel.BookViewModel
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bookAdapter: BookAdapter
    private val viewModel : BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRV()
    }

    private fun setUpRV() {

        bookAdapter = BookAdapter()
        binding.recyclerView.apply {
            adapter = bookAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        viewModel.responseBook.observe(this,{ listBook ->
            bookAdapter.tvShow = listBook
        })
    }
}