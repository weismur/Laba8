package com.example.lab8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buttonClick(v: View){
        val sideA:EditText = findViewById(R.id.sideA)
        val sideB:EditText = findViewById(R.id.sideB)
        val sideC:EditText = findViewById(R.id.sideC)
        val text:TextView = findViewById(R.id.solution)
        var flag:Boolean = false
        val spinner:Spinner = findViewById(R.id.spinner)
        val selected:String = spinner.selectedItem.toString();
        if(sideA.text.toString() == "" || sideB.text.toString() == "" || sideC.text.toString() == ""){
            text.text = "Ошибка ввода"
            flag = true;
        }
        else{
            for (char in sideA.text){
                if(char !in '0'..'9') {
                    text.text = "Ошибка ввода"
                    flag = true;
                }
            }
            if (!flag){
                for (char in sideB.text){
                    if(char !in '0'..'9') {
                        text.text = "Ошибка ввода"
                        flag = true;
                    }
                }
            }
            if (!flag){
                for (char in sideC.text){
                    if(char !in '0'..'9') {
                        text.text = "Ошибка ввода"
                        flag = true;
                    }
                }
            }
        }
        if (!flag){
            text.text = when(selected){
                "Сумма длины ребер" -> "Ответ: ${sideA.text.toString().toInt() * 4+sideB.text.toString().toInt() * 4+sideC.text.toString().toInt() * 4}"
                "Площадь поверхности" -> "Ответ: ${2*((sideA.text.toString().toInt()*sideB.text.toString().toInt())+(sideB.text.toString().toInt()*sideC.text.toString().toInt())+(sideA.text.toString().toInt()*sideC.text.toString().toInt()))}"
                else -> "Ответ: ${sideA.text.toString().toInt()*sideB.text.toString().toInt()*sideC.text.toString().toInt()}"
            }

        }
    }
}