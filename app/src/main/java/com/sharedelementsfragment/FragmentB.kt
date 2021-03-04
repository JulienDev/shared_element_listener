package com.sharedelementsfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentB : AbsFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transitionView = requireView().findViewById<View>(R.id.view_transition)
        transitionView.setOnClickListener {
            (activity as MainActivity).goToC(transitionView)
        }
    }

    override fun getName() = "FB"

}