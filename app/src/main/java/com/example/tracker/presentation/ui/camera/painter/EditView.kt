package com.example.tracker.presentation.ui.camera.painter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

abstract class EditView : View {

    private var isEdited: Boolean = false

    protected var color: Int = 0
    protected var size: Float = 0f
    protected var type: Int = 0
    protected lateinit var paint: Paint

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)



    override fun onTouchEvent(event: MotionEvent): Boolean {
        val isConsumed = onTouch(event)
        if (isConsumed) {
            isEdited = true
        }
        return isConsumed
    }

    fun undo() {
        isEdited = false
        invalidate()
    }

    protected abstract fun onTouch(event: MotionEvent): Boolean

    protected abstract fun clear()

    abstract fun finish(bitmap: Bitmap)

    fun isEdited(): Boolean {
        return isEdited
    }
}