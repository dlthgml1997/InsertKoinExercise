package com.ebookfrenzy.insertkoinexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


// typealias 다른 타입으로 쓰고 싶을 때 사용한다..?
// ex) typealias Latitude = Double
class MainActivity : AppCompatActivity() {

    // val latitude : Latitude = 12.2 // Double 형식

    val 칵: 칵테일 by inject {
        parametersOf(1997)
    }

    // val 바 : IBar by inject()
    // val 바 : IBar = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Log.e("TAG", 바.getAllAlcohol().toString())
        Log.e("TAG", 칵.year.toString())
    }
}
