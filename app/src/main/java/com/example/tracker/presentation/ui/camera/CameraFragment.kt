package com.example.tracker.presentation.ui.camera

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tracker.R
import com.example.tracker.presentation.ui.camera.states.PictureState
import com.example.tracker.presentation.ui.camera.states.TakePictureState
import com.otaliastudios.cameraview.CameraView
import kotlinx.android.synthetic.main.camera_fragment.*

class CameraFragment : Fragment(), CameraManager {


    private lateinit var state: PictureState

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.camera_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Go to the Start state:
        setState(TakePictureState(this))
    }

    override fun onResume() {
        super.onResume()
        activityCaptureImageCamera.start()
    }

    override fun onPause() {
        super.onPause()
        activityCaptureImageCamera.stop()
    }


    override fun setState(state: PictureState) {
        this.state = state
        activityCaptureImageStateContent.apply {
            removeAllViews()
            addView(state.getView(activityCaptureImageStateContent))
        }

        state.handle()
    }

    override fun context(): Context? = context


    override fun getCameraView(): CameraView = activityCaptureImageCamera
}
