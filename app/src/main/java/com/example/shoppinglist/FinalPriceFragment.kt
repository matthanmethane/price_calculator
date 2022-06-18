package com.example.shoppinglist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shoppinglist.databinding.FragmentFinalPriceBinding
import java.math.RoundingMode
import java.text.DecimalFormat


class FinalPriceFragment : Fragment(R.layout.fragment_final_price) {
    lateinit var binding: FragmentFinalPriceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFinalPriceBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etPrice.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                calculateFinalPrice()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

    }
    private fun calculateFinalPrice(){
        var finalPrice = 0.00
        val df = DecimalFormat("0.00").also {it.roundingMode = RoundingMode.HALF_UP}
        val etPriceText = binding.etPrice.text.toString()
        if(etPriceText!="" && etPriceText!="."){
            val price = binding.etPrice.text.toString().toDouble()
            val gst = binding.etGst.text.toString().toInt()
            val service = binding.etService.text.toString().toInt()
            finalPrice = price + price*(gst+service)/100
        }
        binding.tvFinalPrice.text = "Final Price: S$${df.format(finalPrice)}"
    }

}