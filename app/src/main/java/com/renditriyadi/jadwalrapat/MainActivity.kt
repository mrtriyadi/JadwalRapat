package com.renditriyadi.jadwalrapat


import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.renditriyadi.jadwalrapat.databinding.SetDateDialogBinding
import com.renditriyadi.jadwalrapat.databinding.SetTimeDialogBinding
import com.renditriyadi.jadwalrapat.databinding.TambahRapatDialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var tambahRapatBinding : TambahRapatDialogBinding
    private lateinit var setDateBinding: SetDateDialogBinding
    private lateinit var setTimeBinding : SetTimeDialogBinding

    private val rvDaftarRapat: RecyclerView by lazy {
        findViewById(R.id.rv_list_rapat)
    }

    private val btnTambah: Button by lazy {
        findViewById(R.id.btn_tambah)
    }

    private val rapatAdapter: RapatAdapter by lazy {
        RapatAdapter()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDaftarRapat.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        rvDaftarRapat.adapter = rapatAdapter

        val dataRapat = Database.daftarRapat
        rapatAdapter.addDaftarRapat(dataRapat)

        btnTambah.setOnClickListener {
            openDialogTambah()
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun openDialogTambah() {
        tambahRapatBinding = TambahRapatDialogBinding.inflate(layoutInflater)
        val dialogTambahRapat = AlertDialog.Builder(this)
            .apply {
                setView(tambahRapatBinding.root)
            }
            .create()



        tambahRapatBinding.btnSetDate.setOnClickListener {
            setDateBinding = SetDateDialogBinding.inflate(layoutInflater)
            val dialogSetDate = AlertDialog.Builder(this)
                .apply{
                    setView(setDateBinding.root)
                }
                .create()

            setDateBinding.btnSetDate.setOnClickListener {

                val tanggal = setDateBinding.dtTambahRapat.dayOfMonth.toString()+"-"+
                        (setDateBinding.dtTambahRapat.month+1).toString()+"-"+setDateBinding.dtTambahRapat.year.toString()

                tambahRapatBinding.etTanggalTerpilih.setText(tanggal)
                dialogSetDate.dismiss()

            }
            dialogSetDate.show()
        }

        tambahRapatBinding.btnSetTime.setOnClickListener {
            setTimeBinding = SetTimeDialogBinding.inflate(layoutInflater)
            val dialogSetTime = AlertDialog.Builder(this)
                .apply {
                    setView(setTimeBinding.root)
                }
                .create()
            setTimeBinding.btnSetTime.setOnClickListener {
                val waktu = setTimeBinding.dtSetTime.hour.toString()+":"+setTimeBinding.dtSetTime.minute.toString()
                tambahRapatBinding.etWaktuTerpilih.setText(waktu)
                dialogSetTime.dismiss()


            }
            dialogSetTime.show()
        }

        tambahRapatBinding.btnCancel.setOnClickListener{
            dialogTambahRapat.dismiss()
        }

        tambahRapatBinding.btnTambah.setOnClickListener{
            TODO()
        }
        dialogTambahRapat.show()
    }
}