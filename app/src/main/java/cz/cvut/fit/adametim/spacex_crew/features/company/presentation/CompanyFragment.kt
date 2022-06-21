package cz.cvut.fit.adametim.spacex_crew.features.company.presentation

import android.Manifest
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import cz.cvut.fit.adametim.spacex_crew.R
import cz.cvut.fit.adametim.spacex_crew.databinding.FragmentCompanyBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompanyFragment : Fragment() {
    private var _binding: FragmentCompanyBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<CompanyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompanyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bind()
    }

    private fun FragmentCompanyBinding.bind() {
        generalSubtitle.paintFlags = generalSubtitle.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        statsSubtitle.paintFlags = statsSubtitle.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.companyStateStream.collect { state ->
                progressBar.isVisible = state is CompanyState.Loading
                when (state) {
                    is CompanyState.Loading -> {}
                    is CompanyState.Loaded -> {
                        txtSummary.text = state.company.summary
                        txtName.text = state.company.name
                        txtFounder.text = state.company.founder
                        txtWebsite.text = state.company.website
                        txtHqAddress.text = state.company.hqAddress + ","
                        txtHqCity.text = state.company.hqCity + ","
                        txtHqState.text = state.company.hqState
                        txtEmployees.text = state.company.employees.toString()
                        txtVehicles.text = state.company.vehicles.toString()
                        txtNumberOfLaunchSites.text = state.company.numberOfLaunchSites.toString()
                        txtNumberOfTestSites.text = state.company.numberOfTestSites.toString()
                    }
                    is CompanyState.Error -> {
                        Snackbar.make(
                            binding.root,
                            getString(R.string.company_error_loading_msg),
                            Snackbar.LENGTH_SHORT
                        )
                            .show()
                        Log.e(
                            this.javaClass.simpleName,
                            "Error loading resources = " + state.throwable.message, state.throwable
                        )
                    }
                }
            }
        }

        applyButton.setOnClickListener {
            applyButtonOnClick()
        }
    }

    private fun applyButtonOnClick() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
            AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.call_permission_title))
                .setMessage(getString(R.string.call_permission_msg))
                .setPositiveButton(getString(R.string.ok)) { _, _ ->
                    requestPermission()
                }
                .setNegativeButton(getString(R.string.no_upper_case), null)
                .show()
        } else {
            requestPermission()
        }
    }

    private val callPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (permissions[Manifest.permission.CALL_PHONE] == true) {
                dialSpaceXPhoneNumber()
            } else {
                permissionDenied()
            }
        }

    private fun requestPermission() {
        callPermissionLauncher.launch(
            arrayOf(
                Manifest.permission.CALL_PHONE,
            )
        )
    }

    private fun permissionDenied() {
        Snackbar.make(
            requireView(),
            getString(R.string.call_permission_denied_msg),
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun dialSpaceXPhoneNumber() {
        val intent = Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:123456789")
        }
        if (activity?.let { intent.resolveActivity(it.packageManager) } != null) {
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}