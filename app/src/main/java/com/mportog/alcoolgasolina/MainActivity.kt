package com.mportog.alcoolgasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalculate(view: View){
        val alcoolPrice = edit_alcool_price.text.toString()
        val gasolinePrice = edit_gasoline_price.text.toString()

        if ( validateFields(alcoolPrice, gasolinePrice)){
        calculateBestPrice(alcoolPrice, gasolinePrice)
        }
        else{
            fuelResult.setText("Preencha ambos os preços !")
        }

    }

    fun validateFields(alcool : String, gasoline : String) : Boolean{
        var isValid : Boolean = true

        if(alcool == null || alcool.equals("")){
            isValid = false
        }
        else if (gasoline == null || gasoline.equals("")) {
            isValid = false
        }
        return isValid
    }


    fun calculateBestPrice(alcool : String, gasoline : String){
        val alcoolPrice = alcool.toDouble()
        val gasolinePrice = gasoline.toDouble()
        var gas = ""

        if((alcoolPrice/gasolinePrice)>=0.7) {
            gas = "Gasoina"
        }else {
            gas = "Álcool"
        }

        fuelResult.setText("Melhor abastecer com $gas")

        }
    }
