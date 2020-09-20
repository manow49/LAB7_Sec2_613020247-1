package com.example.lab7dialogrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*

class MainActivity : AppCompatActivity() {
    val  studentList = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentData()
        recycle_view.adapter = StudentAdapter(this.studentList, applicationContext)
        recycle_view.layoutManager = LinearLayoutManager(applicationContext)
    }
    fun studentData() {
        studentList.add(Student("613020629-7", "pym", 21))
        studentList.add(Student("613021036-9", "ton", 23))
    }
    fun addStudent(view: View){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout,null)
        val myBuilder = AlertDialog.Builder(this)
        myBuilder.setView(mDialogView)

        val mAlertDialog = myBuilder.show()
        mAlertDialog.btnAdd.setOnClickListener(){
            studentList.add(
                Student(
                    mAlertDialog.edt_id.text.toString(),
                    mAlertDialog.edt_name.text.toString(),
                    mAlertDialog.edt_age.text.toString().toInt()
                )
            )
            recycle_view.adapter?.notifyDataSetChanged()
            Toast.makeText(
                applicationContext,
                "The Student is added successfully",
                Toast.LENGTH_LONG
            ).show()
            mAlertDialog.btnCancel.setOnClickListener()  {
                mAlertDialog.dismiss()
            }
        }

    }

}