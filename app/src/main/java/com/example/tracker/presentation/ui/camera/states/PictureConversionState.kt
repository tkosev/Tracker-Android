package com.example.tracker.presentation.ui.camera.states

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tracker.presentation.ui.camera.CameraManager


class PictureConversionState(cameraManager: CameraManager, val data: ByteArray?) : PictureState(cameraManager) {

    override fun getView(container: ViewGroup): View =
        LayoutInflater.from(container.context).inflate(com.example.tracker.R.layout.view_convertion_state, null)

    override fun handle() {
        //TODO run async
        val imageBitmap = BitmapFactory.decodeByteArray(data, 0, data!!.size)
        cameraManager.setState(PictureTakenState(cameraManager, imageBitmap))
    }
}