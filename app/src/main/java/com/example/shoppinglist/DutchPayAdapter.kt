package com.example.shoppinglist

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.databinding.ItemDutchPayBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class DutchPayAdapter(
    var dutchPayList: MutableList<DutchPayItem>
): RecyclerView.Adapter<DutchPayAdapter.DutchPayViewHodlder>() {
    private lateinit var binding: ItemDutchPayBinding
    inner class DutchPayViewHodlder(val binding: ItemDutchPayBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DutchPayViewHodlder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemDutchPayBinding.inflate(layoutInflater,parent,false)



        return DutchPayViewHodlder(binding)
    }

    override fun onBindViewHolder(holder: DutchPayViewHodlder, position: Int) {
        holder.binding.btnDelete.setOnClickListener {
            dutchPayList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,itemCount-1)
        }
        holder.binding.etPersonPrice.addTextChangedListener(object: TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var finalPrice = 0.00
                val df = DecimalFormat("0.00").also {it.roundingMode = RoundingMode.HALF_UP}
                val etPersonPriceText = holder.binding.etPersonPrice.text.toString()
                if(etPersonPriceText!="" && etPersonPriceText!="."){
                    finalPrice = etPersonPriceText.toDouble() + etPersonPriceText.toDouble()*17/100
                }
                holder.binding.tvPersonFinalPrice.text = "Final Price: S$ ${df.format(finalPrice)}"
            }
            override fun afterTextChanged(p0: Editable?){}
        }

        )
        holder.binding.apply {
            tvPerson.text = "Person $itemCount"
            tvPersonFinalPrice.text = "Final Price: S$ 0.00"
        }
    }

    override fun getItemCount(): Int {
        return dutchPayList.size
    }

}