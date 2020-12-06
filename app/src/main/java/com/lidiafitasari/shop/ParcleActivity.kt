package com.lidiafitasari.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lidiafitasari.shop.model.User
import kotlinx.android.synthetic.main.activity_explicit_intent.*

class ParcleActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcle)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        txt_nama_produk.text = user.name_produk
        txt_price.text = user.price
        txt_stok.text = user.stok
        txt_deskripsi.text = user.deskripsi

        btn_back.setOnClickListener {
            val backItem = Intent(this@ParcleActivity, MainActivity::class.java)
            startActivity(backItem)
        }

    }
}