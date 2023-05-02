package com.streamliner.trackingapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.GoogleMap
import com.streamliner.trackingapp.R
import com.streamliner.trackingapp.databinding.FragmentRunBinding
import com.streamliner.trackingapp.databinding.FragmentTrackingBinding
import com.streamliner.trackingapp.services.TrackingService
import com.streamliner.trackingapp.ui.viewmodels.MainViewModel
import com.streamliner.trackingapp.utils.Consts.ACTION_START_OR_RESUME_SERVICE
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TrackingFragment: Fragment(R.layout.fragment_tracking) {

    val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentTrackingBinding? = null
    private val binding get() = _binding!!

    private var map: GoogleMap? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTrackingBinding.bind(view)
        binding.mapView.onCreate(savedInstanceState)
        binding.btnToggleRun.setOnClickListener {
            sendCommandToService(ACTION_START_OR_RESUME_SERVICE)
        }

        binding.mapView.getMapAsync {
            map = it
        }
    }

    private fun sendCommandToService(action: String) {
        Intent(requireContext(), TrackingService::class.java).also {
            it.action = action
            requireContext().startService(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onDestroy() {
        try {
            binding.mapView.onDestroy()
        } catch (e: Exception) {
            Timber.e("TrackingFragment onDestroy error %s", e)
        }
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }
}