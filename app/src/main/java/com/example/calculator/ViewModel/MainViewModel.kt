package com.example.calculator.ViewModel

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var count = mutableIntStateOf(0)

    /**
     * set the value of count to the new value
     * @param Int count
     *
     */
    fun setCount(count: Int)
    {
        this.count.intValue = count;
    }
    /**
     * set the value of count to the new value
     * @param Int count
     *
     */
    fun encCount()
    {
        this.count.intValue = this.count.intValue+1;
    }
    /**
     * get the value of count
     * @return Int
     * */
    fun getCount(): Int
    {
        return this.count.intValue
    }
}