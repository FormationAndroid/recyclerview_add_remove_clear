package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
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
                    // TODO : checker si nom et age sont renseignés correctement, sinon afficher Toast

                    val newContact = Contact(
                            dialogView.editName.text.toString(),
                            dialogView.editAge.text.toString().toInt()
                    )

                    // TODO : ajouter newContact dans la liste de l'adapter

                    alertDialog.cancel()
                }

                btnCancel.setOnClickListener {
                    alertDialog.cancel()
                }

            }


            alertDialog.show()


        }


        btnClearList.setOnClickListener {
            // TODO : supprimer toute la liste
        }

    }
}
