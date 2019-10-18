package com.example.pemula

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val name: String?,
                 val logo: String?,
                 val basecamp: String?,
                 val coach: String?,
                 val captain: String?,
                 val sponsor: String?,
                 val desc: String?
                ): Parcelable