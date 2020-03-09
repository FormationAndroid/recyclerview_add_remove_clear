package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add_contact.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts = mutableListOf<Contact>()
        contacts.add(Contact("John", 42))
        contacts.add(Contact("Maria", 33))

        val adapter = ContactsRecyclerAdapter(contacts)
        recyclerView.adapter = adapter

        btnAddContact.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(this)
            val dialogView: View = layoutInflater.inflate(R.layout.dialog_add_contact, null)
            dialogBuilder.setView(dialogView)
            val alertDialog: AlertDialog = dialogBuilder.create()

            dialogView.apply {

                btnAdd.setOnClickListener {

                    val nameStr = dialogView.editName.text.toString()
                    val ageStr = dialogView.editAge.text.toString()

                    if (nameStr.isEmpty() || ageStr.isEmpty()){
                        Toast.makeText(applicationContext, "Merci de renseigner les champs", Toast.LENGTH_SHORT).show()
                    }
                    else {

                        val newContact = Contact(
                                nameStr,
                                ageStr.toInt()
                        )
                        adapter.addContact(newContact)
                        alertDialog.cancel()
                    }

                }

                btnCancel.setOnClickListener {
                    alertDialog.cancel()
                }

            }


            alertDialog.show()


        }


        btnClearList.setOnClickListener {
            adapter.clearAll()
        }

    }
}
