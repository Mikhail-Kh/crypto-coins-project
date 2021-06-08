package by.khryshchanovich.cryptocoins.presentation.utils

import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo
import by.khryshchanovich.cryptocoins.R
import by.khryshchanovich.cryptocoins.databinding.ItemCryptocoinsBinding
import okhttp3.internal.format

fun setFormattedSymbol(
    cryptoCoinsInfo: CryptoCoinsInfo,
    binding: ItemCryptocoinsBinding
): String {
    return binding.root.context.getString(R.string.symbol_holder, cryptoCoinsInfo.symbol)
}

fun setFormattedPrice(
    cryptoCoinsInfo: CryptoCoinsInfo,
    binding: ItemCryptocoinsBinding
): String {
    return if (cryptoCoinsInfo.price < 1) {
        binding.root.context.getString(
            R.string.price_holder,
            format(if (cryptoCoinsInfo.price < 0.0001) "%.8f" else "%.4f", cryptoCoinsInfo.price)
        )
    } else {
        binding.root.context.getString(
            R.string.price_holder, format("%.2f", cryptoCoinsInfo.price)
        )
    }
}

fun setFormattedPercentChange1h(
    cryptoCoinsInfo: CryptoCoinsInfo,
    binding: ItemCryptocoinsBinding
): String {
    return if (cryptoCoinsInfo.percentChange1h < 0) {
        binding.root.context.getString(
            R.string.percentChange1h_holder,
            format("%.2f", cryptoCoinsInfo.percentChange1h)
        )
    } else {
        binding.root.context.getString(
            R.string.percentChange1h_holder,
            format("%.2f", cryptoCoinsInfo.percentChange1h)
        )
    }
}

fun setFormattedTextColorPercentChange1h(
    cryptoCoinsInfo: CryptoCoinsInfo,
    binding: ItemCryptocoinsBinding
) {
    if (cryptoCoinsInfo.percentChange1h < 0) {
        binding.percentChange1hTextView.setTextColor(binding.root.context.getColor(R.color.red))
    } else {
        binding.percentChange1hTextView.setTextColor(binding.root.context.getColor(R.color.green))
    }
}

fun setFormattedUrl(
    cryptoCoinsInfo: CryptoCoinsInfo,
    binding: ItemCryptocoinsBinding
): String {
    return binding.root.context.getString(R.string.image_holder, cryptoCoinsInfo.id)
}