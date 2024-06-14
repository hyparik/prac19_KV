package com.example.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CrimeFragment : Fragment() {
    lateinit var  crime: Crime
    lateinit var titleField: EditText
    lateinit var dateButton: Button
    lateinit var solvedCheckBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_crime_fragment, container, false)
        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_date) as Button
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox
        dateButton.apply {
            text = crime.date.toString()
            isEnabled = false
        }
        return  view
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher{
            override fun beforeTextChanged(sequence: CharSequence?,
                                           start: Int, count: Int,
                                           after: Int) {}

            override fun onTextChanged(sequence: CharSequence?,
                                       start: Int, before: Int,
                                       count: Int) {
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {

            }
        }
        titleField.addTextChangedListener(titleWatcher)
        solvedCheckBox.apply { setOnCheckedChangeListener{_, isChecked -> crime.isSolved = isChecked}}
    }

}