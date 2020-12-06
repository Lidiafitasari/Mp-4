package com.lidiafitasari.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_explicit_intent.*

class ExplicitIntentActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME_PRODUK = "extra_name_produk"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_STOK = "extra_stok"
        const val EXTRA_DESKRIPSI = "deskripsi"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)

        txt_nama_produk.text = intent.getStringExtra(EXTRA_NAME_PRODUK)
        txt_price.text = intent.getStringExtra(EXTRA_PRICE)
        txt_stok.text = intent.getStringExtra(EXTRA_STOK)
        txt_deskripsi.text = intent.getStringExtra(EXTRA_DESKRIPSI)

        btn_back.setOnClickListener {
            val backItem = Intent(this@ExplicitIntentActivity, MainActivity::class.java)
            startActivity(backItem)
        }
    }
}