package com.example.tracker.presentation.ui.camera.states

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tracker.R
import com.example.tracker.presentation.ui.camera.CameraManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.otaliastudios.cameraview.CameraListener

class TakePictureState(cameraManager: CameraManager) : PictureState(cameraManager) {

    override fun getView(container: ViewGroup): View =
        LayoutInflater.from(container.context).inflate(R.layout.view_take_picture, null)

    override fun handle() {
        // Attach the camera listener:
        cameraManager.getCameraView().addCameraListener(object : CameraListener() {
            override fun onPictureTaken(jpeg: ByteArray?) {
                super.onPictureTaken(jpeg)
                // Picture is taken go to the conversion state:
                cameraManager.setState(PictureConversionState(cameraManager))
            }
        })

        (cameraManager.context() as Activity).findViewById<FloatingActionButton>(R.id.activity_capture_image_take_picture)
            .setOnClickListener {
                cameraManager.getCameraView().captureSnapshot()
            }

    }
}