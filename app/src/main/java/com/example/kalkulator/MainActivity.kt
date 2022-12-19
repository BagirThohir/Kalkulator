package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_hitung.setOnClickListener{
            if(et_angka1.text.toString() == ""){
                et_angka1.error = "Angka 1 Harus di-ketik"
                return@setOnClickListener
            }

            if(et_angka2.text.toString() == ""){
                et_angka2.error = "Angka 2 Harus di-ketik"
                return@setOnClickListener
            }

            val nilai_angka1 = et_angka1.text.toString().toInt()
            val nilai_angka2 = et_angka2.text.toString().toInt()

            tv_hasil.text = do_hitung_hasil(nilai_angka1,nilai_angka2)
        }
    }

    private fun do_hitung_hasil(nilai1:Int,nilai2:Int):String{
        var hitung_hasil:Int = 0
        val pilih_operator = sp_operator.selectedItem.toString()

        when(pilih_operator){
            "x" -> hitung_hasil = nilai1 * nilai2
            "/" -> hitung_hasil = nilai1 / nilai2
            "+" -> hitung_hasil = nilai1 + nilai2
            "-" -> hitung_hasil = nilai1 - nilai2
            else -> {
                Toast.makeText(this,"Pilihlah Operator",Toast.LENGTH_SHORT) .show()
            }
        }

        val result_hasil = hitung_hasil
        return result_hasil.toString()
    }
}