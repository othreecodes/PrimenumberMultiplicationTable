package com.davidmadethis.primenumbermultiplicationtable.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.davidmadethis.primenumbermultiplicationtable.data.Constants
import com.davidmadethis.primenumbermultiplicationtable.data.Generator
import com.davidmadethis.primenumbermultiplicationtable.data.nthPrime

class MainViewModel : ViewModel() {
    fun generateNumbers() {

         primenumbers.postValue(Generator.primesUpTo(nthPrime(Constants.PRIME_NUMBER_COUNT)).toMutableList())

    }

    val primenumbers: MutableLiveData<MutableList<Int>>  = MutableLiveData<MutableList<Int>>()

    val multiplicationTable: MutableList<Int> = mutableListOf()


    fun getMultiplicationTable(numbers:MutableList<Int>): MutableList<Int> {
        val row = numbers
        row.add(0,1)
        multiplicationTable.clear()



        primenumbers.value!!.forEach {

            for (x in row)
            multiplicationTable.add(x*it)
        }

        Log.e("val ", multiplicationTable.toString())
        return multiplicationTable
    }



}
