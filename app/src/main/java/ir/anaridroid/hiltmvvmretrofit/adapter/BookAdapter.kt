package ir.anaridroid.hiltmvvmretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.anaridroid.hiltmvvmretrofit.databinding.BookLayoutAdapterBinding
import ir.anaridroid.hiltmvvmretrofit.models.Book

class BookAdapter : RecyclerView.Adapter<BookAdapter.MyViewHolder>() {
    class MyViewHolder (val binding: BookLayoutAdapterBinding):RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object :DiffUtil.ItemCallback<Book>(){
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return newItem == oldItem
        }
    }
    private val differ = AsyncListDiffer(this,diffCallback)
    var tvShow :List<Book>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(BookLayoutAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val booklist =tvShow[position]

        holder.binding.apply {
            textView.text = booklist.bookName
        }

    }

    override fun getItemCount(): Int=tvShow.size


}