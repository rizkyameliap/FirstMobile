package com.example.firstmobile

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstmobile.data.model.BookDoc
import com.example.firstmobile.databinding.ActivityDaftarBukuBinding
import com.example.firstmobile.ui.adapter.BookAdapter
import com.example.firstmobile.ui.adapter.OnBookClickListener
import com.example.firstmobile.viewmodel.MainViewModel
import com.example.pemmobpertama.ui.fragment.BookDetailFragment
import java.io.File.separator

class DaftarBukuActivity : AppCompatActivity(), OnBookClickListener {

    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = BookAdapter( emptyList(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        viewModel.books.observe(this) {
            adapter.setData(it)
        }
        viewModel.fetchBooks(query = "kotlin programming")
    }

    override fun onBookClick(book: BookDoc) {
        book.let { b->
            BookDetailFragment(
                 b.title?:"-",
                 b.authorName?.joinToString ( separator= "," ) ?: "Unknown Author",
                 "${b.firstPublishYear}",
                 b.coverId?:0
            ).show(supportFragmentManager,  BookDetailFragment::class.java.simpleName)
        }
    }
}

