package cz.cvut.fit.adametim.spacex_crew.features.crew.presentation

import androidx.recyclerview.widget.DiffUtil
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import cz.cvut.fit.adametim.spacex_crew.databinding.CrewMemberItemBinding
import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember

class CrewAdapter()
    : ListAdapter<CrewMember, CrewAdapter.CrewMemberHolder>(CrewDiffCallback()) {

    /*init {
            stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
        }*/

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrewAdapter.CrewMemberHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CrewAdapter.CrewMemberHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class CrewMemberHolder(private val binding: CrewMemberItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(crewMember: CrewMember) {
            TODO("Not yet implemented")
            /*binding.txtName.text = crewMember.name
            binding.txtStatus.text = crewMember.status
            binding.txtAgency.text = crewMember.agency
            binding.txtWikipedia.text = crewMember.wikipedia
            binding.txtNumberOfLaunches.text = crewMember.numberOfLaunches
            Glide.with(binding.root)
                .load(crewMember.imageUrl)
                .into(binding.imgAvatar)*/
        }
    }

    private class CrewDiffCallback : DiffUtil.ItemCallback<CrewMember>() {

        override fun areItemsTheSame(oldItem: CrewMember, newItem: CrewMember): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CrewMember, newItem: CrewMember): Boolean {
            return oldItem == newItem
        }
    }
}