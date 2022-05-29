package ir.anaridroid.hiltmvvmretrofit.models

data class Book (
    val id: Int,
    val bookName: String,
    val category: String,
    val coverDesigner: String,
    val editor: String,
    val file_url: String,
    val genre: String,
    val writer: String)