package org.kashish.facetoons.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import org.kashish.facetoons.fragment.AboutAppFragment
import org.kashish.facetoons.fragment.FAQFragment
import org.kashish.facetoons.fragment.CameraFragment
import org.kashish.facetoons.fragment.DashboardFragment
import org.kashish.facetoons.fragment.GalleryFragment
import org.kashish.facetoons.R
import org.kashish.facetoons.util.DrawerLocker
import org.kashish.facetoons.util.SessionManager

class MainPage : AppCompatActivity(),DrawerLocker {

    override fun setDrawerEnabled(enabled: Boolean) {
        val lockMode = if (enabled)
            DrawerLayout.LOCK_MODE_UNLOCKED
        else
            DrawerLayout.LOCK_MODE_LOCKED_CLOSED

        drawerLayout.setDrawerLockMode(lockMode)
        actionBarDrawerToggle.isDrawerIndicatorEnabled = enabled
    }


    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    var previousMenuItem: MenuItem? = null
    lateinit var sessionManager: SessionManager
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var sharedPrefs: SharedPreferences
    lateinit var frameLayout: FrameLayout
    lateinit var coordinatorLayout: CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)


        sessionManager = SessionManager(this@MainPage)
        sharedPrefs = this@MainPage.getSharedPreferences(
            sessionManager.PREF_NAME,
            sessionManager.PRIVATE_MODE
        )

        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        frameLayout = findViewById(R.id.frame)
        coordinatorLayout = findViewById(R.id.coordinator)

        /*This method is also user created to setup the toolbar*/
        setupToolbar()

        /*This is method is created to display the home fragment inside the activity by default*/
        displayHome()

        /*User created method to handle the action bar drawer toogle*/
        setupActionBarToggle()


        /*Below we handle the click listeners of the menu items inside the navigation drawer*/
        navigationView.setNavigationItemSelectedListener {

            /*Unchecking the previous menu item when a new item is clicked*/
            if (previousMenuItem != null) {
                previousMenuItem?.isChecked = false
            }

            /*Highlighting the new menu item, the one which is clicked*/
            it.isCheckable = true
            it.isChecked = true

            /*This sets the value of previous menu item as the current one*/
            previousMenuItem = it


            /*The closing of navigation drawer is delayed to make the transition smooth
            * We delay it by 0.1 second*/
            val mPendingRunnable = Runnable { drawerLayout.closeDrawer(GravityCompat.START) }
            Handler().postDelayed(mPendingRunnable, 100)

            /*The fragment transaction takes care of the different fragments which will be opened and closed*/
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            /*Getting the id of the clicked item to identify which fragment to display*/
            when (it.itemId) {

                /*Opening the Dashboard fragment*/
                R.id.dashboard -> {
                    displayHome()
                    drawerLayout.closeDrawers()
                }

                /*Opening the Gallery fragment*/
                R.id.gallery -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            GalleryFragment()
                        )
                        .commit()
                    supportActionBar?.title="Your Facetoons"
                    drawerLayout.closeDrawers()
                }

                /*Opening the Camera fragment*/
                R.id.camera -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            CameraFragment()
                        )
                        .commit()
                    supportActionBar?.title="Camera"
                    drawerLayout.closeDrawers()
                }

                /*Opening the about app fragment*/
                R.id.about_app -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            AboutAppFragment()
                        )
                        .commit()
                    supportActionBar?.title="About App"
                    drawerLayout.closeDrawers()
                }

                /*Opening the frequently asked questions i.e. FAQ fragment*/
                R.id.faqs -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            FAQFragment()
                        )
                        .commit()
                    supportActionBar?.title="FAQs"
                    drawerLayout.closeDrawers()
                }
                /*R.id.logout -> {

                    /*Creating a confirmation dialog*/
                    val builder = AlertDialog.Builder(this@MainPage)
                    builder.setTitle("Confirmation")
                        .setMessage("Are you sure you want exit?")
                        .setPositiveButton("Yes") { _, _ ->
                            sessionManager.setLogin(false)
                            sharedPrefs.edit().clear().apply()
                            startActivity(Intent(this@MainPage, LoginActivity::class.java))
                            Volley.newRequestQueue(this).cancelAll(this::class.java.simpleName)
                            ActivityCompat.finishAffinity(this)
                        }
                        .setNegativeButton("No") { _, _ ->
                            displayHome()
                        }
                        .create()
                        .show()

                }*/

            }
            return@setNavigationItemSelectedListener true
        }
    }
    /*Since, there are a lot of ways from which Home fragment will open therefore it is better to make a
    * separate method for it.*/
    fun displayHome() {
        val fragment = DashboardFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
        supportActionBar?.title = "Facetoons"
        navigationView.setCheckedItem(R.id.dashboard)
    }

    fun setupActionBarToggle() {
        val actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.openDrawer, R.string.closeDrawer)

        //      {
//            override fun onDrawerStateChanged(newState: Int) {
//                super.onDrawerStateChanged(newState)
//                val pendingRunnable = Runnable {
//                    val inputMethodManager =
//                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                    inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
//                }
//
//                /*delaying the closing of the navigation drawer for that the motion looks smooth*/
//                Handler().postDelayed(pendingRunnable, 50)
//            }
//        }
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
        toolbar.setTitleTextAppearance(this, R.style.PoppinsTextAppearance)
    }



    /*Setting up the opening of navigation drawer*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    /*Adding custom routes from different fragments when we press the back button*/
    override fun onBackPressed() {
        var frag = supportFragmentManager.findFragmentById(R.id.frame)

        when(frag){
            !is DashboardFragment -> displayHome()

            else -> super.onBackPressed()
        }
    }

}