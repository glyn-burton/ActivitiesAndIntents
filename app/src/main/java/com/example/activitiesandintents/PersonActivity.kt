package com.example.activitiesandintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_person.*

class PersonActivity : AppCompatActivity() {

    var personList :ArrayList<Person> = ArrayList<Person>()
    lateinit var passedPerson: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        passedPerson = intent
    }


    fun createPerson(view: View) {

        when(view.id){

            R.id.btnCreatePerson -> {
                val intent = Intent(this,PersonResultActivity::class.java)
                intent.putParcelableArrayListExtra("newPerson", personList)
                startActivityForResult(intent,2001)



            }

            R.id.btnSeeList -> {


            }




        }


    }
}
