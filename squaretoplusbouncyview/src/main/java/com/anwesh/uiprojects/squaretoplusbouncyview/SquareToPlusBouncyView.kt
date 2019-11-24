package com.anwesh.uiprojects.squaretoplusbouncyview

/**
 * Created by anweshmishra on 24/11/19.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Canvas

val nodes : Int = 5
val lines : Int = 4
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val scGap : Float = 0.02f
val foreColor : Int = Color.parseColor("#4CAF50")
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()
fun Float.cosify() : Float = 1f - Math.cos(Math.PI / 2 + (this) * (Math.PI / 2)).toFloat()

fun Canvas.drawVerticalHorizontalLine(i : Int, scale : Float, size : Float, paint : Paint) {
    val sci : Float = scale.divideScale(i, lines)
    val sf : Float = sci.sinify()
    val sc : Float = sci.divideScale(1, 2).cosify()
    save()
    rotate(90f * i)
    drawLine(0f, 0f, 0f, -size * sf, paint)
    save()
    translate(0f, -size * sc)
    drawLine(-size, 0f, size, 0f, paint)
    restore()
    restore()
}

fun Canvas.drawVHLNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(gap * (i + 1), h / 2)
    for (j in 0..(lines - 1)) {
        drawVerticalHorizontalLine(i, scale, size, paint)
    }
    restore()
}

class SquareToPlusBouncyView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}