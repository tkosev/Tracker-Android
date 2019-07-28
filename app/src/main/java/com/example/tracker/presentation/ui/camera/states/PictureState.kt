package com.example.tracker.presentation.ui.camera.states

import android.view.View
import android.view.ViewGroup
import com.example.tracker.presentation.ui.camera.CameraManager

abstract class PictureState(protected val cameraManager: CameraManager) {

    abstract fun getView(container: ViewGroup): View

    abstract fun handle()
}