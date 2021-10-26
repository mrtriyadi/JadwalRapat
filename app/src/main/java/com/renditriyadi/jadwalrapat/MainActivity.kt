package com.renditriyadi.jadwalrapat


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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