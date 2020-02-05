package com.example.activitiesandintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_person_result.*

class PersonResultActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_result)
        val personList = intent.getParcelableArrayListExtra<Person>("Person")

        PeopleList.text = personList.toString()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when{
            requestCode == 348 && resultCode == 101 ->{

                //personList.add(data?.getParcelableExtra<Person>("Person") as Person)
            }

        }






    }



}
