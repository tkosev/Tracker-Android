package com.example.tracker.presentation.ui.camera.states

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tracker.R
import com.example.tracker.presentation.ui.camera.CameraManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PictureTakenState(cameraManager: CameraManager) : PictureState(cameraManager) {

    override fun getView(container: ViewGroup): View =
        LayoutInflater.from(container.context).inflate(R.layout.view_picture_taken_state, null)

    override fun handle() {
        //Cancel button
        (cameraManager.context() as Activity).findViewById<FloatingActionButton>(R.id.view_picture_taken_cancel)
            .setOnClickListener {
                cameraManager.setState(TakePictureState(cameraManager))
            }

        //Confirm button
        (cameraManager.context() as Activity).findViewById<FloatingActionButton>(R.id.view_picture_taken_send)
            .setOnClickListener {
                cameraManager.setState(TakePictureState(cameraManager))
            }
    }
}