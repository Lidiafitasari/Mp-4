package com.lidiafitasari.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_result2.*
import java.time.Instant

class ResultActivity : AppCompatActivity() {
    companion object{
        const val RESULT_CODE = 200
        const val EXTRA_COLOR = "extra_color"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        btn_result.setOnClickListener {
            if(rg_colors.checkedRadioButtonId !=0) {
            var value = "ffffff"
            when (rg_colors.checkedRadioButtonId) {
                R.id.rad_hitam -> value = "#000000"
                R.id.rad_biru -> value = "#0000ff"
                R.id.rad_hijau -> value = "#00ff00"
                R.id.rad_merah -> value = "#ff0000"
            }
            Log.d("selected Color", value.toString())
            val resultsIntent = Intent()
            resultsIntent.putExtra(EXTRA_COLOR, value)
            setResult(200, resultsIntent)
            finish()
            }
            }
        }
    }