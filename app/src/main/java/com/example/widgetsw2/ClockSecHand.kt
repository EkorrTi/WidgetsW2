package com.example.widgetsw2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import java.time.LocalTime
/**
 * View corresponding to the second hand of the clock
 */
class ClockSecHand(context: Context, attrs: AttributeSet): View(context, attrs) {
    //private val ringPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rectPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val runnable = Runnable { invalidate() }
    private val delayMillis = 1000

    init {
        //ringPaint.style = Paint.Style.STROKE
        //ringPaint.strokeWidth = 10f
        //ringPaint.color = Color.BLACK
        rectPaint.style = Paint.Style.FILL
        rectPaint.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val sec = LocalTime.now().second
        val secAngle = sec * 6f
        // Update every second
        Log.i("Second Angle", "Second - $sec, Angle - $secAngle")

        val centerX = width/2f
        val centerY = height/2f
        canvas?.rotate(secAngle,centerX,centerY)
        // Ring
        /*val radius = (width - 100f)/2f
        canvas?.drawCircle(centerX,centerY,radius,ringPaint)*/

        // Second Hand
        val rectL = centerX - 5f
        val rectR = centerX + 5f
        val rectT = centerY - 120f
        val rectB = centerY + 40f
        canvas?.drawRect(rectL,rectT,rectR,rectB,rectPaint)

        handler.postDelayed(runnable, delayMillis.toLong())
    }
}