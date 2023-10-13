package com.example.ejemplorecycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorecycle.databinding.ItemContactoBinding


class ContactosAdapter(private val contactos :List<Contacto>, private val contactoPulsadoListener: ContactoPulsadoListener)
    :RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemContactoBinding)
        : RecyclerView.ViewHolder(binding.root){
            var expand: Boolean = true;
            fun bind(contacto:Contacto){
                var iniciales :String = ""

                var lista=listOf(binding.Nombre.text.split(" "))

                for(iniciales in lista){

                }

                binding.Imagen.setOnClickListener(object: View.OnClickListener{
                    override fun onClick(p0: View?) {
                        if(!expand){
                            binding.Nombre.text = iniciales
                            expand = true
                        }else{
                            binding.Nombre.text = contacto.nombre
                            binding.Tlfno.text = contacto.tfno
                            expand = false
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
        holder.bind(contactos[position])
        holder.itemView.setOnClickListener {contactoPulsadoListener.contactoPulsado(contactos[position])}
    }
}