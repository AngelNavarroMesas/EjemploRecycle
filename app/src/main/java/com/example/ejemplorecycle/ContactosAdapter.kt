package com.example.ejemplorecycle

import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorecycle.databinding.ItemContactoBinding

class ContactosAdapter(private val contactos: List<Contacto>,
                       private val contactoPulsadoListener : ContactoPulsadoListener
) : RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {
    class ViewHolder(private val binding : ItemContactoBinding) : RecyclerView.ViewHolder(binding.root){
        var completo = false
        fun bind (contacto:Contacto){
            if (contacto.genero == "Mujer")
                binding.Imagen.setImageResource(R.drawable.imgmujer)
            var iniciales = ""
            val array = contacto.nombre.split(" ")
            for (nombre : String in array){
                iniciales += nombre[0]
            }
            Log.d("inicial", iniciales)
            binding.Tlfno.text = ""
            binding.Nombre.text = ""
            binding.Iniciales.text = iniciales
            binding.Imagen.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    if (completo.equals(false)){
                        binding.Nombre.text = contacto.nombre
                        binding.Tlfno.text = contacto.tfno
                        completo = true
                    }else{
                        binding.Iniciales.text = iniciales
                        binding.Nombre.text = ""
                        binding.Tlfno.text = ""
                        completo = false
                    }
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int{
        return contactos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transition = TransitionInflater.from(holder.itemView.context).inflateTransition(android.R.transition.fade)

        TransitionManager.beginDelayedTransition(holder.itemView as ViewGroup?, transition)
        holder.bind(contactos[position])
        holder.itemView.setOnClickListener{
            contactoPulsadoListener.contactoPulsado((contactos[position]))
        }
    }
}