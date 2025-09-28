package com.example.firstmobile.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstmobile.data.model.BookDoc
import com.example.firstmobile.databinding.ListBukuBinding

class BookAdapter(private var books: List<BookDoc>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    // ViewHolder untuk menyimpan reference View
    inner class BookViewHolder(val binding: ListBukuBinding) :
        RecyclerView.ViewHolder(binding.root)

    // Membuat ViewHolder baru ketika RecyclerView butuh
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ListBukuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BookViewHolder(binding)
    }

    // Mengembalikan jumlah item
    override fun getItemCount(): Int = books.size

    // Menghubungkan data dengan tampilan (binding data ke UI)
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]

        // Set judul buku
        holder.binding.tvTitle.text = book.title ?: "No Title"

        // Set nama author
        holder.binding.tvAuthor.text =
            book.authorName?.joinToString(", ") ?: "Unknown Author"

        // Set tahun publish
        holder.binding.tvYear.text =
            book.firstPublishYear?.toString() ?: "-"
    }

    // Update data di adapter
    fun setData(newBooks: List<BookDoc>) {
        books = newBooks
        notifyDataSetChanged()
    }
}