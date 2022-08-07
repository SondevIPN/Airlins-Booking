package domain.presentation

import domain.model.Flight

interface Formatter<T> {
    fun format(t: T): String
    fun format(ts: List<T>):String{
        val stringBuilder = StringBuilder()
        ts.forEach {
            stringBuilder.appendLine(format(it))
        }
        return stringBuilder.toString()
    }
}