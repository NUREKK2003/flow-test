package com.lexmasterteam.flows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val flow = flow<String>{
            for(i in 1..10){
                emit("Hello World")
                delay(1000L)
            }
        }
        GlobalScope.launch {
            flow.buffer().collect{
                println(it)
                delay(2000L)
            }
        }*/
        val flow = flow{
            for(i in 1..10){
                emit(i)
                delay(1000L)
            }
        }
        GlobalScope.launch {
            flow.buffer().filter{
                it % 2 ==0
            }.map{
                    it * it
            }.collect{
                println(it)
                delay(2000L)
            }
            }
        }


    }

