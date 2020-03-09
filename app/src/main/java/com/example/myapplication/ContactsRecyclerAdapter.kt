package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsRecyclerAdapter(private val contacts: MutableList<Contact>): RecyclerView.Adapter<ContactsRecyclerAdapter.ContactViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(inflater, parent)
    }

    inner class ContactViewHolder(inflater: LayoutInflater, parent: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_contacts, parent, false)) {

        private val btnDelete: Button = itemView.findViewById(R.id.btnDeleteContact)
        private val textName: TextView = itemView.findViewById(R.id.textName)
        private val textAge: TextView = itemView.findViewById(R.id.textAge)

        fun bind(contact: Contact){
            textName.text = contact.name
            textAge.text = contact.age.toString()

            btnDelete.setOnClickListener { removeContact() }

        }

        private fun removeContact() {
            contacts.removeAt(layoutPosition)
            notifyItemRemoved(layoutPosition)
        }

    }


    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount() = contacts.size

}