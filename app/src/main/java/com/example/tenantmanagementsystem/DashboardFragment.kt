package com.example.tenantmanagementsystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tenantmanagementsystem.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    // _binding can be null (no view yet, or view destroyed)
    private var _binding: FragmentDashboardBinding? = null
    // binding is a shortcut we only use while the view exists
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Read from the shared list of tenants
        val tenantCount = TenantRepository.tenants.size
        val totalRent = TenantRepository.totalRent()
        binding.tenantCountTextView.text = "Tenants\n$tenantCount"
        binding.totalRentTextView.text = "Total rent\nKSh %,.0f".format(totalRent)
    }

    // The view is destroyed: let go of it so memory can be freed
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}