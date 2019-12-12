package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //declare modeile-level variable
    private lateinit var countViewModel : CountViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MVVC" ,"OnCreate")

        //initialize the ViewModel
        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        //add an observer
        countViewModel.count.observe(
            this,
            androidx.lifecycle.Observer {
                if(it.equals(10)) goodLuck()
            }
        )

        textViewCounter.text = countViewModel.count.value.toString()

        buttonPlus.setOnClickListener{
            countViewModel.increment()
            textViewCounter.text = countViewModel.count.value.toString()
        }

        buttonMinus.setOnClickListener {
            countViewModel.decrement()
            textViewCounter.text = countViewModel.count.value.toString()

        }
    }

     override fun onDestroy(){
        Log.d("MVVC","onDestroy")
         super.onDestroy()
    }
    override fun onResume(){
        Log.d("MVVC", "onResume")
        super.onResume()

    }
    private fun goodLuck(){
        Toast.makeText(this,"Good Luck!!!",Toast.LENGTH_SHORT).show()
    }


}
