package com.asad.tentwenty.data.remote.models.movie

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dates(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int,
    val maximum: String,
    val minimum: String
)