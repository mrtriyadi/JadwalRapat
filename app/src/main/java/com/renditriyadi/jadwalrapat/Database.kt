package com.renditriyadi.jadwalrapat

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.Month

object Database {
    //rapat pertama
    @RequiresApi(Build.VERSION_CODES.O)
    val tanggalRapat1: String = LocalDate.of(2021,Month.NOVEMBER, 21).toString()

    val hariRapat1 = "Senin"

    @RequiresApi(Build.VERSION_CODES.O)
    val waktuRapat1 = LocalTime.of(12,0).toString()

    //rapat kedua
    @RequiresApi(Build.VERSION_CODES.O)
    val tanggalRapat2: String = LocalDate.of(2021,Month.NOVEMBER, 22).toString()

    val hariRapat2 = "Selasa"

    @RequiresApi(Build.VERSION_CODES.O)
    val waktuRapat2 = LocalTime.of(13,0).toString()

    val rapatSatu = DataClassRapat(
        "Rapat PTSL",
        hariRapat1,
        tanggalRapat1,
        waktuRapat1,
        "Ruang Baduy"
    )

    val rapatDua = DataClassRapat(
        "Rapat Monev",
        hariRapat2,
        tanggalRapat2,
        waktuRapat2,
        "Ruang Baduy"
    )

    val daftarRapat = listOf(
        rapatSatu, rapatDua
    )

}