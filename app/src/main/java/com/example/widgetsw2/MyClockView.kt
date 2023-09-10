package com.example.widgetsw2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyClockView(context: Context, attrs: AttributeSet): View(context, attrs) {
    private val ringPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rectPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        ringPaint.style = Paint.Style.STROKE
        ringPaint.strokeWidth = 10f
        ringPaint.color = Color.BLACK
        rectPaint.style = Paint.Style.FILL
        rectPaint.color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // Ring
        val centerX = width/2f
        val centerY = height/2f
        val radius = (width - 100f)/2f
        canvas?.drawCircle(centerX,centerY,radius,ringPaint)

        // Rect
        // Doesn't draw properly :(
        val rectW = 50f
        val rectH = 10f
        val rectR = centerX + radius
        val rectL = rectR - rectW
        val rectT = centerY - (rectH/2)
        val rectB = centerY + (rectH/2)
        canvas?.drawRect(rectL,rectR,rectT,rectB,rectPaint)
    }
}