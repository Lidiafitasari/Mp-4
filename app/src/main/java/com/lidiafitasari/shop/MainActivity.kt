package com.lidiafitasari.shop

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.lidiafitasari.shop.model.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result2.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    companion object{
        const val REQUEST_CODE = 100
        const val EXTRA_COLOR = "extra_color"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_simple_intent.setOnClickListener {
            val simpleIntent = Intent(this@MainActivity, SimpleActivity::class.java)
            startActivity(simpleIntent)
        }

        btn_intent_with_data.setOnClickListener {
            val dataIntent = Intent(this@MainActivity, ExplicitIntentActivity::class.java)
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_NAME_PRODUK, "wardah")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_PRICE, "250.000")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_STOK, "150")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_DESKRIPSI, "paket wardah")
            startActivity(dataIntent)
        }

        btn_intent_parcelable.setOnClickListener {
            val parcelIntent = Intent(this@MainActivity, ParcleActivity::class.java)
            val user = User("wardah", "250.000", "150", "paket wardah")
            parcelIntent.putExtra(ParcleActivity.EXTRA_USER, user)
            startActivity(parcelIntent)
        }

        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "0895634444775"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
            intent.putExtra("sms_body", "hello customer")
            startActivity(intent)
        }

        btn_intent_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode==200){
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("color", color.toString())
            view_result.setBackgroundColor(Color.parseColor(color.toString()))
        }
    }
}