package com.example.tracker.presentation.ui.camera.painter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.example.tracker.presentation.ui.camera.painter.Line


class Painter : View {

    var lines = ArrayList<Line>()
    var mPaint = Paint()

    // Don't draw every single pixel.
    // If the finger has has moved less than this distance, don't draw.
    private val touchTolerance = 2f

    // Variables for the latest x,y values,
    // which are the starting point for the next path.
    private var mX: Float = 0.toFloat()
    private var mY: Float = 0.toFloat()
    private var mExtraCanvas: Canvas? = null

    var mPath = Path()

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        initPaint()
    }

    private fun initPaint() {
        mPaint.isAntiAlias = true
        mPaint.strokeWidth = 6f
        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeJoin = Paint.Join.ROUND
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        Log.e("View:" , "onSizeChanged :")

        // Create bitmap, create canvas with bitmap, fill canvas with color.
        // mExtraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        mExtraCanvas = Canvas()
        // mExtraCanvas.drawColor(mBackgroundColor)

        // Calculate the rect a frame around the picture.
        val inset = 40
        // mFrame = Rect(inset, inset, width - inset, height - inset)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mExtraCanvas = canvas
        // Draw the bitmap that has the saved path.
        // canvas.drawBitmap(mExtraBitmap, 0, 0, null);

        // Draw a frame around the picture.
       // canvas.drawRect(mFrame, mPaint);
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x = event?.x
        val y = event?.y

        // Invalidate() is inside the case statements because there are many
        // other types of motion events passed into this listener,
        // and we don't want to invalidate the view for those.
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> touchStart(x!!, y!!)
            MotionEvent.ACTION_MOVE -> {
                touchMove(x!!, y!!)
                invalidate()
            }
            MotionEvent.ACTION_UP -> touchUp()
        }// No need to invalidate because we are not drawing anything.
        // do nothing
        return true
    }

    private fun touchStart(x: Float, y: Float) {
        mPath.moveTo(x, y)
        Log.e("View:" , "touchStart X : $x Y:$y")

        mX = x
        mY = y
    }

    private fun touchMove(x: Float, y: Float) {
        Log.e("View:" , "touchMove X : $x Y:$y")



       // Log.e("View:" , "touchMove X : $dx Y:$dy")

       // if (dx >= touchTolerance || dy >= touchTolerance) {
            // QuadTo() adds a quadratic bezier from the last point,
            // approaching control point (x1,y1), and ending at (x2,y2).
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2)
            mX = x
            mY = y
            // Draw the path in the extra bitmap to save it.
            mExtraCanvas?.drawPath(mPath, mPaint)
            Log.e("View:" , "drawPath X :")

        //}
    }


    private fun touchUp() {
        // Reset the path so it doesn't get drawn again.
        Log.e("View:" , "resetPath X : ")
        mPath.reset()
    }
}