package edu.fullerton.cpsc411.assignment_2

import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class mainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }




    }


    // inflate fragment to match with layout and container


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }




    // implemented on view created for calculation and save the instance state

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // two functions for calcuation
        fun cal(mib: kotlin.Double?, mbp: kotlin.Double?): kotlin.Double? {

            return mib!! * Math.pow(2.0, 20.0) * 8.0 / (mbp!! * Math.pow(10.0, 6.0))
        }

        fun roundOff(final_output: kotlin.Double?): String {

            return String.format(Locale.US, "%.1f", final_output)

        }
        // extention function for output
        fun TextView.finalOutput(){
            val input1 = mib_input.text
            val input2 = mbps_input.text
            if(input1.isNotEmpty() && input2.isNotEmpty()){
                val finalCal = cal(java.lang.Double.parseDouble(input1.toString()),java.lang.Double.parseDouble(input2.toString()))

                val f = roundOff(finalCal) + " Seconds"

                this.text = f
            }
            else{
                this.text = "0"

            }
        }
        // text on change for any new input value and keeping recalculate the ouput
        fun EditText.setWatcher() {
            this.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    output.finalOutput()
                }

            })
        }
        mbps_input.setWatcher()
        mib_input.setWatcher()
    }



    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment mainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                mainFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}

