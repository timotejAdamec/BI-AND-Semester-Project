package cz.cvut.fit.adametim.spacex_crew

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import cz.cvut.fit.adametim.spacex_crew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /*private val topLevelDestinationIds = setOf(
        R.id.crew_fragment,
        R.id.company_fragment
    )
    private val destinationIdsWithoutBottomNavigation = setOf(
        R.id.crew_member_fragment
    )*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}