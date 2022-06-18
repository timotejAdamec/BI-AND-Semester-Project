package cz.cvut.fit.adametim.spacex_crew.features.company.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import cz.cvut.fit.adametim.spacex_crew.R
import cz.cvut.fit.adametim.spacex_crew.databinding.FragmentCompanyBinding
import cz.cvut.fit.adametim.spacex_crew.databinding.FragmentCrewBinding
import cz.cvut.fit.adametim.spacex_crew.features.crew.presentation.CrewAdapter
import cz.cvut.fit.adametim.spacex_crew.features.crew.presentation.CrewState
import cz.cvut.fit.adametim.spacex_crew.features.crew.presentation.CrewViewModel
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
        // TODO bind all texts etc
        /*viewLifecycleOwner.lifecycleScope.launch {
            viewModel.companyStateStream.collect { state ->
                progressBar.isVisible = state is CrewState.Loading
                when (state) {
                    is CrewState.Loading -> {}
                    is CrewState.Loaded -> {
                        adapter.submitList(state.crew)
                        pagerCrewMembers.setCurrentItem(3, false)
                        pagerCrewMembers.setCurrentItem(0, true)
                    }
                    is CrewState.Error -> {
                        Snackbar.make(
                            binding.root,
                            R.string.crew_error_loading_msg,
                            Snackbar.LENGTH_SHORT)
                            .show()
                        Log.e(this.javaClass.simpleName,
                            "Error loading resources = " + state.throwable.message, state.throwable)
                    }
                }
            }
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}