package cz.cvut.fit.adametim.spacex_crew.features.crew.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import cz.cvut.fit.adametim.spacex_crew.R
import cz.cvut.fit.adametim.spacex_crew.databinding.FragmentCrewBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CrewFragment : Fragment() {

    private var _binding: FragmentCrewBinding? = null
    private val binding get() = _binding!!

    private val adapter = CrewAdapter()
    // TODO
    //private val viewModel by viewModel<CrewMemberViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bind()
    }

    private fun FragmentCrewBinding.bind() {
        //pagerCrewMembers.layoutManager = LinearLayoutManager(context)
        pagerCrewMembers.adapter = adapter

        // TODO
        /*viewLifecycleOwner.lifecycleScope.launch {
            viewModel.charactersStateStream.collect { state ->
                progressBar.isVisible = state is CrewState.Loading
                when (state) {
                    is CrewState.Loading -> {}
                    is CrewState.Loaded -> {
                        adapter.submitList(state.characters)
                        pagerCrewMembers.setCurrentItem(5, false)
                        pagerCrewMembers.setCurrentItem(0, true)
                    }
                    is CrewState.Error -> {
                        Snackbar.make(
                            binding.root,
                            R.string.crew_error_loading_msg,
                            Snackbar.LENGTH_SHORT)
                            .show()
                        Log.e(this.javaClass.simpleName,
                            "Error loading resources", state.throwable)
                    }
                }
            }
        }*/
    }
}