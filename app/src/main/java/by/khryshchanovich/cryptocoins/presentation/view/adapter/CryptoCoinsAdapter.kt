package by.khryshchanovich.cryptocoins.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo
import by.khryshchanovich.cryptocoins.databinding.ItemCryptocoinsBinding
import by.khryshchanovich.cryptocoins.presentation.utils.*
import com.bumptech.glide.Glide

class CryptoCoinsAdapter(private val listCryptoCoins: List<CryptoCoinsInfo>) :
    RecyclerView.Adapter<CryptoCoinsAdapter.CryptoCoinsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCoinsViewHolder {
        val binding =
            ItemCryptocoinsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoCoinsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listCryptoCoins.size
    }

    override fun onBindViewHolder(holder: CryptoCoinsViewHolder, position: Int) {
        holder.bind(listCryptoCoins[position])
    }

    class CryptoCoinsViewHolder(private val binding: ItemCryptocoinsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cryptoCoinsInfo: CryptoCoinsInfo) {
            with(binding) {
                nameTextView.text = cryptoCoinsInfo.name
                symbolTextView.text = setFormattedSymbol(cryptoCoinsInfo, binding)
                priceTextView.text = setFormattedPrice(cryptoCoinsInfo, binding)
                percentChange1hTextView.text =
                    setFormattedPercentChange1h(cryptoCoinsInfo, binding)
                setFormattedTextColorPercentChange1h(cryptoCoinsInfo, binding)
                Glide.with(binding.root)
                    .load(setFormattedUrl(cryptoCoinsInfo, binding))
                    .into(cryptoCoinsImageView)
            }
        }
    }
}