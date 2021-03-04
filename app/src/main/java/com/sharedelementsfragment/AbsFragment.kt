package com.sharedelementsfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.SharedElementCallback
import androidx.fragment.app.Fragment
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import androidx.transition.TransitionListenerAdapter

abstract class AbsFragment : Fragment() {

    abstract fun getName() : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.move)
        sharedElementReturnTransition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.move)

        val name = getName()
        val sharedElementEnterTransition = sharedElementEnterTransition as? Transition
        if (sharedElementEnterTransition != null) {
            sharedElementEnterTransition.addListener(object : TransitionListenerAdapter(){
                override fun onTransitionEnd(transition: Transition) {
                    super.onTransitionEnd(transition)
                    Log.e("sharedE", "$name sharedElementEnterTransition onTransitionEnd()")
                }
            })
        } else {
            Log.e("sharedE", "$name sharedElementEnterTransition noTransition()")
        }

        val sharedElementReturnTransition = sharedElementReturnTransition as? Transition
        if (sharedElementReturnTransition != null) {
            sharedElementReturnTransition.addListener(object : TransitionListenerAdapter(){
                override fun onTransitionEnd(transition: Transition) {
                    super.onTransitionEnd(transition)
                    Log.e("sharedE", "$name sharedElementReturnTransition onTransitionEnd()")
                }
            })
        } else {
            Log.e("sharedE", "$name sharedElementReturnTransition noTransition()")
        }


        val enterTransition = enterTransition as? Transition
        if (enterTransition != null) {
            enterTransition.addListener(object : TransitionListenerAdapter(){
                override fun onTransitionEnd(transition: Transition) {
                    super.onTransitionEnd(transition)
                    Log.e("sharedE", "$name enterTransition onTransitionEnd()")
                }
            })
        } else {
            Log.e("sharedE", "$name enterTransition noTransition()")
        }


        val returnTransition = returnTransition as? Transition
        if (returnTransition != null) {
            returnTransition.addListener(object : TransitionListenerAdapter(){
                override fun onTransitionEnd(transition: Transition) {
                    super.onTransitionEnd(transition)
                    Log.e("sharedE", "$name returnTransition onTransitionEnd()")
                }
            })
        } else {
            Log.e("sharedE", "$name returnTransition noTransition()")
        }

        val exitTransition = exitTransition as? Transition
        if (exitTransition != null) {
            exitTransition.addListener(object : TransitionListenerAdapter(){
                override fun onTransitionEnd(transition: Transition) {
                    super.onTransitionEnd(transition)
                    Log.e("sharedE", "$name exitTransition onTransitionEnd()")
                }
            })
        } else {
            Log.e("sharedE", "$name exitTransition noTransition()")
        }

        val reenterTransition = reenterTransition as? Transition
        if (reenterTransition != null) {
            reenterTransition.addListener(object : TransitionListenerAdapter(){
                override fun onTransitionEnd(transition: Transition) {
                    super.onTransitionEnd(transition)
                    Log.e("sharedE", "$name reenterTransition onTransitionEnd()")
                }
            })
        } else {
            Log.e("sharedE", "$name reenterTransition noTransition()")
        }

        setExitSharedElementCallback(object : SharedElementCallback(){
            override fun onSharedElementEnd(
                sharedElementNames: MutableList<String>?,
                sharedElements: MutableList<View>?,
                sharedElementSnapshots: MutableList<View>?
            ) {
                super.onSharedElementEnd(sharedElementNames, sharedElements, sharedElementSnapshots)
                Log.e("sharedE", "$name setExitSharedElementCallback onSharedElementEnd()")
            }

            override fun onSharedElementStart(
                sharedElementNames: MutableList<String>?,
                sharedElements: MutableList<View>?,
                sharedElementSnapshots: MutableList<View>?
            ) {
                super.onSharedElementStart(
                    sharedElementNames,
                    sharedElements,
                    sharedElementSnapshots
                )
                Log.e("sharedE", "$name setExitSharedElementCallback onSharedElementStart()")
            }
            override fun onSharedElementsArrived(
                sharedElementNames: MutableList<String>?,
                sharedElements: MutableList<View>?,
                listener: OnSharedElementsReadyListener?
            ) {
                super.onSharedElementsArrived(sharedElementNames, sharedElements, listener)
                Log.e("sharedE", "$name setExitSharedElementCallback onSharedElementsArrived()")
            }
        })

        setEnterSharedElementCallback(object : SharedElementCallback(){
            override fun onSharedElementEnd(
                sharedElementNames: MutableList<String>?,
                sharedElements: MutableList<View>?,
                sharedElementSnapshots: MutableList<View>?
            ) {
                super.onSharedElementEnd(sharedElementNames, sharedElements, sharedElementSnapshots)
                Log.e("sharedE", "$name setEnterSharedElementCallback onSharedElementEnd()")
            }

            override fun onSharedElementStart(
                sharedElementNames: MutableList<String>?,
                sharedElements: MutableList<View>?,
                sharedElementSnapshots: MutableList<View>?
            ) {
                super.onSharedElementStart(
                    sharedElementNames,
                    sharedElements,
                    sharedElementSnapshots
                )
                Log.e("sharedE", "$name setEnterSharedElementCallback onSharedElementStart()")
            }
            override fun onSharedElementsArrived(
                sharedElementNames: MutableList<String>?,
                sharedElements: MutableList<View>?,
                listener: OnSharedElementsReadyListener?
            ) {
                super.onSharedElementsArrived(sharedElementNames, sharedElements, listener)
                Log.e("sharedE", "$name setEnterSharedElementCallback onSharedElementsArrived()")
            }
        })
    }

    override fun onResume() {
        super.onResume()
        val name = getName()
        Log.e("sharedE", "$name onResume()")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        val name = getName()
        Log.e("sharedE", "$name onViewStateRestored()")
    }

}