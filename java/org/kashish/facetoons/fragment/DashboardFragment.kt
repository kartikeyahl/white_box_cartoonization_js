package org.kashish.facetoons.fragment

import android.os.Bundle
import android.os.Process
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.kashish.facetoons.R
import java.util.*
import kotlin.system.exitProcess

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_dashboard, container, false)



        return view
    }

    override fun onStart() {
        super.onStart()

        val ttb = AnimationUtils.loadAnimation(activity,
            R.anim.ttb
        )
        val stb = AnimationUtils.loadAnimation(activity,
            R.anim.stb
        )
        val btt1 = AnimationUtils.loadAnimation(activity,
            R.anim.btt1
        )
        val btt2 = AnimationUtils.loadAnimation(activity,
            R.anim.btt2
        )
        val btt3 = AnimationUtils.loadAnimation(activity,
            R.anim.btt3
        )
        val btt4 = AnimationUtils.loadAnimation(activity,
            R.anim.btn_exit
        )

        val headerTitle = activity?.findViewById(R.id.headertitle) as? TextView
        val subtitle = activity?.findViewById(R.id.subtitle) as? TextView
        val icCards = activity?.findViewById(R.id.ic_cards) as? ImageView
        val Facetoons = activity?.findViewById(R.id.resultOne) as? LinearLayout
        val Camera = activity?.findViewById(R.id.resultTwo) as? LinearLayout
        val Gallery = activity?.findViewById(R.id.resultThree) as? LinearLayout
        val btnExitApp = activity?.findViewById(R.id.btn_exit_app) as? Button

        headerTitle?.startAnimation(ttb)
        subtitle?.startAnimation(ttb)
        icCards?.startAnimation(stb)
        Facetoons?.startAnimation(btt1)
        Camera?.startAnimation(btt2)
        Gallery?.startAnimation(btt3)
        btnExitApp?.startAnimation(btt4)

        btnExitApp?.setOnClickListener {
            run {
                Process.killProcess(Process.myPid())
                exitProcess(1)
            }
        }
    }
}


