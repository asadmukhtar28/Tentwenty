package com.asad.tentwenty.ui.main.medialibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.asad.tentwenty.databinding.FragmentMediaLibraryBinding

class MediaLibraryFragment : Fragment() {

    private lateinit var mediaLibraryViewModel: MediaLibraryViewModel
    private var _binding: FragmentMediaLibraryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mediaLibraryViewModel =
            ViewModelProvider(this).get(MediaLibraryViewModel::class.java)

        _binding = FragmentMediaLibraryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        mediaLibraryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}