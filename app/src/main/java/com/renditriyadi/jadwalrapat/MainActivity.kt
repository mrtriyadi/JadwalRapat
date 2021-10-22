package com.renditriyadi.jadwalrapat

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renditriyadi.jadwalrapat.databinding.LayoutCustomDialogBinding

class MainActivity : AppCompatActivity() {
    private val dialogBinding : LayoutCustomDialogBinding

    private val rvDaftarRapat: RecyclerView by lazy {
        findViewById(R.id.rv_list_rapat)
    }

    private val btnTambah: Button by lazy {
        findViewById(R.id.btn_tambah)
    }

    private val rapatAdapter: RapatAdapter by lazy {
        RapatAdapter()
    }

    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("data_rapat", Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDaftarRapat.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        rvDaftarRapat.adapter = rapatAdapter

        val dataRapat = Database.daftarRapat
        rapatAdapter.addDaftarRapat(dataRapat)
        val preferencesEditor = sharedPreferences.edit()

        btnTambah.setOnClickListener {
            openDialogTambah()
        }

    }

    private fun openDialogTambah() {
        dialogBinding = LayoutCustomDialogBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .apply {
                setView(dialogBinding.root)
            }
            .create()

        if (pemenang=="SERI"){
            dialogBinding.tvMenang.isVisible=false
            dialogBinding.tvPemenang.text="SERI"
        }else{
            dialogBinding.tvMenang.isVisible=true
            dialogBinding.tvPemenang.text=pemenang
        }
        dialogBinding.btnMainLagi.setOnClickListener{
            dialog.dismiss()
            clearChoice()
        }
        dialogBinding.btnMenu.setOnClickListener{
            val intent= Intent(this, Menu::class.java)
            intent.putExtra(Menu.NAME,playerName)
            startActivity(intent)
        }
        dialog.show()
    }
}