package com.standardfunction

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG = "StandardFunctions"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        letFun()

        nestingLetFun()

        runFunction()

        letAndRunFunction()

        alsoFun()

        letVsAlsoFun()

        applyFun()

        alsoVsApplyFun()

        withFun()

    }

    private fun letFun() {
        val str = "Kotlin Standard Functions"
        str.let { Log.d(TAG, it) }
        Log.d(TAG, str)

        //Prints
        //KotlinStandardFunctions
        //KotlinStandardFunctions
    }

    private fun nestingLetFun() {
        var x1 = 1
        val y1 = 1

        x1 = x1.let { it + 1 }.let {
            val result = it + y1
            result
        }

        Log.d(TAG, x1.toString())

        //Prints
        //2
    }

    private fun runFunction() {
        var str = "Kotlin Standard Functions"
        Log.d(TAG, str)

        str = run {
            val result = "Run function Execution"
            result
        }

        Log.d(TAG, str)

        //Prints
        //Kotlin Standard Functions
        //Run function Execution

    }

    private fun letAndRunFunction() {
        var str: String? = null

        str?.let { Log.d(TAG, str) } ?: run {
            Log.d(TAG, "str is getting null and assign it to default value.")
            str = "Welcome"
        }

        Log.d(TAG, str)

        //Prints
        //str is getting null and assign it to default value.
        //Welcome
    }

    private fun alsoFun() {
        var m = 1
        m = m.also { it + 1 }.also { it + 1 }

        Log.d(TAG, m.toString())

        //Prints
        //1
    }

    private fun letVsAlsoFun() {
        val person = Person("John", "Kotlin")

        val let = person.let { it.tutorial = "Android" }
        val also = person.also { it.tutorial = "Android" }

        println(let)
        println(also)
        println(person)

        //Prints
        //kotlin.Unit
        //Person(name=John, tutorial=Android)
        //Person(name=John, tutorial=Android)
    }


    private fun applyFun() {
        val person = Person("John", "Kotlin")

        person.apply { this.tutorial = "Java" }
        println(person)

        //Prints
        //Person(name=John, tutorial=Java)

    }

    private fun alsoVsApplyFun() {
        val person = Person("John", "Kotlin")

        person.apply { tutorial = "Java" }
        println(person)

        person.also { it.tutorial = "Android" }
        println(person)

        //Prints
        //Person(name=John, tutorial=Java)
        //Person(name=John, tutorial=Android)

    }

    data class Person(var name: String, var tutorial: String)

    private fun withFun() {
        val person = Person("John", "Kotlin")

        with(person)
        {
            name = "No Name"
            tutorial = "Kotlin tutorials"
        }

        println(person)

        //Prints
        //Person(name=No Name, tutorial=Kotlin tutorials)
    }

}