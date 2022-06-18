package com.example.shoppinglist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.databinding.FragmentDutchPayBinding
import com.example.shoppinglist.databinding.FragmentFinalPriceBinding
import java.math.RoundingMode
import java.text.DecimalFormat


class DutchPayFragment : Fragment(R.layout.fragment_dutch_pay) {
    lateinit var binding: FragmentDutchPayBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDutchPayBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var dutchPayList = mutableListOf(
            DutchPayItem("Person1", 0.00, 0.00)
        )
        val adapter = DutchPayAdapter(dutchPayList)
        binding.rvPersonPrice.adapter = adapter
        binding.rvPersonPrice.layoutManager = LinearLayoutManager(this.context)

        binding.btnCalculate.setOnClickListener {
            dutchPayList.add(DutchPayItem("Person ${dutchPayList.size}", 0.00, 0.00))
            adapter.notifyItemInserted(dutchPayList.size - 1)
        }
    }
}