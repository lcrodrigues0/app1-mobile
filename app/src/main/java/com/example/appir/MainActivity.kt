package com.example.appir

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bntCalcular.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.bnt_calcular) {
            val salarioTxt = binding.salarioEt.text.toString() ?: "0"
            val gastoTxt = binding.gastosEt.text.toString() ?: "0"

            val salario = salarioTxt.toDouble();
            val gasto = gastoTxt.toDouble();

            val ir = calculaIR(salario, gasto);

            binding.irValueTv.text = "R$ $ir";
        }

    }

    fun calculaIR(salario: Double, gasto: Double) : Double{
        var ir = 0.0

        if (salario <= 0 )
        // TODO: tratar

        Log.d("teste", salario.toString())

        ir = when (salario) {
            in 0.0..1903.98 -> 0.0;
            in 1903.98..2826.65 -> salario * (7.5/100) - gasto;
            in 2826.66..3751.05 -> salario * (15.0/100) - gasto;
            in 3751.05..4664.68 -> salario * (22.5/100) - gasto;
            else -> salario * (27.5/100) - gasto;
        }

        if (ir < 0.0) return 0.0;

        return ir;
    }
}