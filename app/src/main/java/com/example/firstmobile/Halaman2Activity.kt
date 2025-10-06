package com.example.firstmobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstmobile.databinding.ActivityHalaman2Binding

class Halaman2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHalaman2Binding
    private val latitude = "-7.429427"
    private val longitude = "109.338082"
    private val packageMaps = "com.google.android.apps.maps"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalaman2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.layoutPhone.imgIcon.setImageResource(R.drawable.ic_phone)
        binding.layoutPhone.tvLayout.text = getString(R.string.nomor_telepon)

        binding.layoutEmail.imgIcon.setImageResource(R.drawable.ic_email)
        binding.layoutEmail.tvLayout.text = getString(R.string.alamat_email)

        binding.layoutLocation.imgIcon.setImageResource(R.drawable.ic_location)
        binding.layoutLocation.tvLayout.text = getString(R.string.alamat_lokasi)

        binding.layoutIg.imgIcon.setImageResource(R.drawable.ic_himpunan)
        binding.layoutIg.tvLayout.text = getString(R.string.instagram_url)

        binding.menuKoleksiBuku.imgIcon.setImageResource(R.drawable.ic_book)
        binding.menuKoleksiBuku.tvLayout.text = getString(R.string.koleksi_buku)

    }

    private fun initListener() {
        binding.layoutLocation.root.setOnClickListener {
            val gmapsIntentUri = Uri.parse("geo:$latitude,$longitude")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmapsIntentUri)
            mapIntent.setPackage(packageMaps)
            startActivity(mapIntent)
        }

        binding.layoutPhone.root.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:${getString(R.string.nomor_telepon)}")
            startActivity(dialIntent)
        }

        binding.layoutEmail.root.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:${getString(R.string.alamat_email)}")
            startActivity(Intent.createChooser(emailIntent, "Kirim email dengan:"))
        }

        binding.layoutIg.root.setOnClickListener {
            val igIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.instagram_url)))
            startActivity(igIntent)
        }

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.menuKoleksiBuku.root.setOnClickListener {
            val intent = Intent(this, DaftarBukuActivity::class.java)
            startActivity(intent)
        }
    }
}
