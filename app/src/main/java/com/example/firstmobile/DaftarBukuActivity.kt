package com.example.firstmobile

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstmobile.databinding.ActivityDaftarBukuBinding
import com.example.firstmobile.ui.adapter.BookAdapter
import com.example.firstmobile.viewmodel.MainViewModel

class DaftarBukuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = BookAdapter(books = emptyList())

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
}