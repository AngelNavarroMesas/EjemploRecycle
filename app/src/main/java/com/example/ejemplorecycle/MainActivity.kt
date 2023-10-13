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
                Contacto("Juan Jameson Jr", "611123456", "Hombre"),
                Contacto("Maria Martinez Mendoza", "678456123", "Mujer"),
                Contacto("Raúl Romero Rodriguez", "611126123", "Hombre"),
                Contacto("Antonio Aguilar Alcantara", "611123456", "Hombre"),
                Contacto("Ana Alvarez Agramonte", "678456123","Mujer"),
                Contacto("Paco Perez Parker", "611126123", "Hombre"),
                Contacto("Juan Jameson Jr", "611123456", "Hombre"),
                Contacto("Maria Martinez Mendoza", "678456123", "Mujer"),
                Contacto("Raúl Romero Rodriguez", "611126123", "Hombre"),
                Contacto("Antonio Aguilar Alcantara", "611123456", "Hombre"),
                Contacto("Ana Alvarez Agramonte", "678456123","Mujer"),
                Contacto("Paco Perez Parker", "611126123", "Hombre"),
                Contacto("Juan Jameson Jr", "611123456", "Hombre"),
                Contacto("Maria Martinez Mendoza", "678456123", "Mujer"),
                Contacto("Raúl Romero Rodriguez", "611126123", "Hombre"),
                Contacto("Antonio Aguilar Alcantara", "611123456", "Hombre"),
                Contacto("Ana Alvarez Agramonte", "678456123","Mujer"),
                Contacto("Paco Perez Parker", "611126123", "Hombre"),
                Contacto("Juan Jameson Jr", "611123456", "Hombre"),
                Contacto("Maria Martinez Mendoza", "678456123", "Mujer"),
                Contacto("Raúl Romero Rodriguez", "611126123", "Hombre"),
                Contacto("Antonio Aguilar Alcantara", "611123456", "Hombre"),
                Contacto("Ana Alvarez Agramonte", "678456123","Mujer"),
                Contacto("Paco Perez Parker", "611126123", "Hombre"),
                Contacto("Juan Jameson Jr", "611123456", "Hombre"),
                Contacto("Maria Martinez Mendoza", "678456123", "Mujer"),
                Contacto("Raúl Romero Rodriguez", "611126123", "Hombre"),
                Contacto("Antonio Aguilar Alcantara", "611123456", "Hombre"),
                Contacto("Ana Alvarez Agramonte", "678456123","Mujer"),
                Contacto("Paco Perez Parker", "611126123", "Hombre")
            ),
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