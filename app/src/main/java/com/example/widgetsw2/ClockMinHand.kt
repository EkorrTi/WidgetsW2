package com.example.widgetsw2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import java.time.LocalTime

class ClockMinHand(context: Context, attrs: AttributeSet): View(context, attrs) {
    private val rectPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val runnable = Runnable { invalidate() }

    init {
        rectPaint.style = Paint.Style.FILL
        rectPaint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val time = LocalTime.now()
        // Update when the next minute comes
        val delayMillis = (60 - time.second) * 1000
        val min = time.minute
        val minAngle = min * 6f
        Log.i("Minute Angle", "Minute - $min, Angle - $minAngle")

        val centerX = width/2f
        val centerY = height/2f
        canvas?.rotate(minAngle,centerX,centerY)

        // Hand
        val rectL = centerX - 5f
        val rectR = centerX + 5f
        val rectT = centerY - 160f
        val rectB = centerY + 40f
        canvas?.drawRect(rectL,rectT,rectR,rectB,rectPaint)

        handler.postDelayed(runnable, delayMillis.toLong())
    }
}