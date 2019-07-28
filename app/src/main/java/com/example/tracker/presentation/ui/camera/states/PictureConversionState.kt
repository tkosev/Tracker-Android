package com.example.tracker.presentation.ui.camera.states

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tracker.R
import com.example.tracker.presentation.ui.camera.CameraManager

class PictureConversionState(cameraManager: CameraManager) : PictureState(cameraManager) {

    override fun getView(container: ViewGroup): View = LayoutInflater.from(container.context).inflate(R.layout.view_convertion_state, null)

    override fun handle() {
        cameraManager.setState(PictureTakenState(cameraManager))
    }
}