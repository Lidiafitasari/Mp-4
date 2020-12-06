package com.lidiafitasari.shop.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val name_produk : String,
    val price : String,
    val stok : String,
    val deskripsi : String,
    ) : Parcelable