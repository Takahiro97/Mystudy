package com.example.mydata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.io.File
import java.io.BufferedReader

const val EXTRA_MESSAGE="com.example.mydata.MASSAGE"

class MainActivity : AppCompatActivity() {
    private val fileName="datafile.txt"
    val dataEdit=findViewById(R.id.dataEdit) as EditText
    val dataText=findViewById(R.id.dataText) as TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        val state = DataState(1, "name")
        dataText.text=state.name
    }
    //changeボタンの処理　　"(view:View)"を記述するとレイアウトページのonClickにおいて関数の指定が可能
    fun sendMessage(view: View){
        val message=dataEdit.text.toString()
        val intent = Intent(this, SubActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE,message)
        }
        startActivity(intent)
    }
    //saveボタンの処理
    fun saveMessage(view:View){
        val message=dataEdit.text.toString()
        if(!message.isEmpty()){
            saveFile(fileName, message)
            dataText.text="save"
        }else{
            dataText.text="no_text"
        }
    }
    fun readMessage(view:View){
        val str = readFiles(fileName)
        if (str != null) {
            dataText.text = str
        } else {
            dataText.text ="no_text"
        }
    }
    //ファイル保存
    fun saveFile(file:String, str:String){
        File(applicationContext.filesDir, file).writer().use {
            it.write(str)
        }
    }
    fun readFiles(file:String):String?{
        val readFile=File(applicationContext.filesDir, file)
        if(!readFile.exists()){
            Log.d("debug","No file exists")
            return null
        }else{
            return readFile.bufferedReader().use(BufferedReader::readText)
        }
    }
}