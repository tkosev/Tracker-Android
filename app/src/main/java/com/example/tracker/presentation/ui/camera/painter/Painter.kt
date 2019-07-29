package com.example.tracker.presentation.ui.camera.painter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import com.example.tracker.R


class Painter : EditView {


    private var lastX: Int = 0
    private var lastY: Int = 0

    var lines = ArrayList<Line>()
    var mPaint = Paint()

    private val touchTolerance = 2f

    private var mX: Float = 0.toFloat()
    private var mY: Float = 0.toFloat()
    private var mExtraCanvas: Canvas? = null

    private lateinit var displayBitmap: Bitmap
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

    fun setBitmap(imageBitmap: Bitmap) {
        this.displayBitmap = imageBitmap
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        Log.e("View:", "onSizeChanged :")

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

        canvas?.apply {
            drawBitmap(displayBitmap, 0.0f, 0.0f, mPaint)
        }

        // Draw a frame around the picture.
        // canvas.drawRect(mFrame, mPaint);
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(event: MotionEvent): Boolean {
        var rtn = false
        val action = event.action

        val x: Int
        val y: Int
        when (action) {
            MotionEvent.ACTION_DOWN -> {
                x = event.x.toInt()
                y = event.y.toInt()
                lastX = x
                lastY = y
                rtn = true
            }
            MotionEvent.ACTION_MOVE -> {
                x = event.x.toInt()
                y = event.y.toInt()

                val paint = Paint()
                paint.color = color
                paint.style = Paint.Style.FILL_AND_STROKE
                paint.strokeWidth = size
                mExtraCanvas?.drawLine(lastX.toFloat(), lastY.toFloat(), x.toFloat(), y.toFloat(), paint)
                paint.strokeWidth = 1f
                mExtraCanvas?.drawCircle(x.toFloat(), y.toFloat(), size / 2, paint)
                lastX = x
                lastY = y


                rtn = true
            }
            MotionEvent.ACTION_UP -> //requestSave()
                rtn = true
        }

        return rtn
    }

    override fun clear() {

    }

    override fun finish(bitmap: Bitmap) {

    }

    private fun touchStart(x: Float, y: Float) {
        mPath.moveTo(x, y)
        Log.e("View:", "touchStart X : $x Y:$y")

        mX = x
        mY = y
    }

    private fun touchMove(x: Float, y: Float) {
        Log.e("View:", "touchMove X : $x Y:$y")

        // Log.e("View:" , "touchMove X : $dx Y:$dy")
        // if (dx >= touchTolerance || dy >= touchTolerance) {
        // QuadTo() adds a quadratic bezier from the last point,
        // approaching control point (x1,y1), and ending at (x2,y2).
        mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2)
        mX = x
        mY = y
        // Draw the path in the extra bitmap to save it.
        mExtraCanvas?.drawPath(mPath, mPaint)
        Log.e("View:", "drawPath X :")
        //}
    }

    private fun touchUp() {
        // Reset the path so it doesn't get drawn again.
        Log.e("View:", "resetPath X : ")
        mPath.reset()
    }
}