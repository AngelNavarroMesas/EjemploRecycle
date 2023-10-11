package com.example.ejemplorecycle

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplorecycle.databinding.ContactosBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contactos = ContactosBinding.inflate(layoutInflater)
       setContentView(contactos.root)

        contactos.vistaContactos.adapter = ContactosAdapter(
            listOf(
                Contacto("Juan", "611123456"),
                Contacto("Maria", "678456123"),
                Contacto("Raúl", "611126123"),
                Contacto("Antonio", "611123456"),
                Contacto("Ana", "678456123"),
                Contacto("Paco", "611126123"),
                Contacto("Juan", "611123456"),
                Contacto("Maria", "678456123"),
                Contacto("Antonio", "611123456"),
                Contacto("Ana", "678456123"),
                Contacto("Paco", "611126123"),
                Contacto("Raúl", "611126123"),
                Contacto("Juan", "611123456"),
                Contacto("Antonio", "611123456"),
                Contacto("Ana", "678456123"),
                Contacto("Paco", "611126123"),
                Contacto("Maria", "678456123"),
                Contacto("Raúl", "611126123"),
                Contacto("Antonio", "611123456"),
                Contacto("Ana", "678456123"),
                Contacto("Paco", "611126123"),
                Contacto("Juan", "611123456"),
                Contacto("Maria", "678456123"),
                Contacto("Raúl", "611126123"),
                Contacto("Antonio", "611123456"),
                Contacto("Ana", "678456123"),
                Contacto("Paco", "611126123")),
            object : ContactoPulsadoListener {
                override fun contactoPulsado(contacto: Contacto) {
                    val dial = Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel:"+contacto.tfno)
                    )
                    startActivity(dial)
                }
            }
        )
    }
}