package com.example.tracker.presentation.ui.camera

import android.content.Context
import com.example.tracker.presentation.ui.camera.states.PictureState
import com.otaliastudios.cameraview.CameraView

interface CameraManager {

    fun setState(state: PictureState)

    fun getCameraView(): CameraView

    fun context() : Context?

}