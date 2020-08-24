package com.android.english.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment
import com.android.english.R

class DiFragment : DialogFragment() {
    private var word: String? = null
    fun newInstance(message: String?, word: String?): DiFragment {
        this.word = word
        val f = DiFragment()
        val args = Bundle()
        args.putString(ARG_MESSAGE, message)
        f.setArguments(args)
        return f
    }

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_di, container, false)
        val mTextView = rootView.findViewById<View>(R.id.tviWord) as TextView
        val buttonAceptar =
            rootView.findViewById<View>(R.id.btn_agree) as Button
        mTextView.text = word
        getDialog()!!.setTitle("Dialog")
        buttonAceptar.setOnClickListener { dismiss() }
        return rootView
    }

    companion object {
        protected const val ARG_MESSAGE = "message"
    }
}
