package edu.fullerton.cpsc411.assignment_2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity() {

    



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // function extention to get intracsation for replace fragment on main

        fun FragmentManager.inTransaction(replace: FragmentTransaction.() -> Unit) {
            val fr = beginTransaction()
            fr.replace()
            fr.commit()
        }

            // checking the instancestate
        if (savedInstanceState == null) {


            /* this is the regular using kotlin without androidx support
            val fr = supportFragmentManager.beginTransaction()
            fr.replace(R.id.Fragment_holder, mainFragment())
            fr.commit()
            */


            // using android ktx with function extention to replace fragment
            supportFragmentManager.inTransaction {
                replace(R.id.Fragment_holder, mainFragment())
            }
        }



    }



}





















