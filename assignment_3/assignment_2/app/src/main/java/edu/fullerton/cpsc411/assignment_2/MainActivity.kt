package edu.fullerton.cpsc411.assignment_2
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val fr = supportFragmentManager.beginTransaction()
            fr.replace(R.id.Fragment_holder, mainFragment())
            fr.commit()
        }
    }
}










