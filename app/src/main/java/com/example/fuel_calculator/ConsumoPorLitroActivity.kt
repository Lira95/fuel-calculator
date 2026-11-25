package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConsumoPorLitroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo_por_litro)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Recuperar dados tela anterior
        //findByView
        // Navegar proxima tela
        // Passar dados do preço tela anterior e consumo digitado pelo usuario

        val precoCombustivel = intent.getDoubleExtra("PRECO_COMBUSTIVEL", 0.0)
        val edtConsumoLitro = findViewById<EditText>(R.id.edtConsumoLitro)
        val btnConsumoPorLitro = findViewById<Button>(R.id.btnConsumoLitroProximo)

        btnConsumoPorLitro.setOnClickListener {
            val consumoPorLitroValor = edtConsumoLitro.text.toString().toInt()
            val intent = Intent(this, DistanciaActivity::class.java)
            intent.putExtra("CONSUMO_LITRO", consumoPorLitroValor)
            intent.putExtra("PRECO_LITRO", precoCombustivel)
            startActivity(intent)
        }
    }
}