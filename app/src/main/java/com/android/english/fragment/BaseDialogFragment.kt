package com.android.english.fragment

import android.app.DialogFragment
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.annotation.Nullable

class BaseDialogFragment : DialogFragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(
        view: View,
        @Nullable savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        //sendGoogleAnalytics();
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
        //mTdpApplication = (TdpApplication)getActivity().getApplication();
        //mTracker = mTdpApplication.getTracker();
    }
}
