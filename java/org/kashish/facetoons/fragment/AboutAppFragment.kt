package org.kashish.facetoons.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Process
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_camera.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.kashish.facetoons.R
import java.util.*
import kotlin.system.exitProcess

class AboutAppFragment : Fragment() {

    lateinit var lytdown: RelativeLayout
    lateinit var btn_gmail: FloatingActionButton
    lateinit var btn_insta: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about_app, container, false)

        lytdown = view.findViewById(R.id.lytdown)
        btn_gmail = view.findViewById(R.id.btngmail)
        btn_insta = view.findViewById(R.id.btninsta)

        btn_gmail.setOnClickListener(View.OnClickListener {

                gotoUrl("community.facetoons@gmail.com")

        })
        btn_insta.setOnClickListener(View.OnClickListener {

                gotoUrl("https://instagram.com/community.facetoons?igshid=1dxnnsci4khfv")

        })

        lytdown.setTranslationY(300f)
        btn_gmail.setTranslationY(300f)
        btn_insta.setTranslationY(300f)

        lytdown.setAlpha(0f)
        btn_gmail.setAlpha(0f)
        btn_insta.setAlpha(0f)

        lytdown.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(400).start()
        btn_gmail.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(1500).start()
        btn_insta.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(1500).start()

        return view
    }
    fun gotoUrl(string: String){
        var uri = Uri.parse(string)
        startActivity(Intent(Intent.ACTION_VIEW,uri))
    }
}