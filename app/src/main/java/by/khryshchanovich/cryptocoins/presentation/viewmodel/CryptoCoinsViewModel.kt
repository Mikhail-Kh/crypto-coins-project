package by.khryshchanovich.cryptocoins.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo
import by.khryshchanovich.core.domain.interactors.cryptocoins.GetCryptoCoinsUseCaseImpl
import by.khryshchanovich.core.domain.interactors.cryptocoins.RemoveCryptoCoinsUseCaseImpl
import by.khryshchanovich.core.domain.interactors.cryptocoins.SaveCryptoCoinsUseCaseImpl
import by.khryshchanovich.core.domain.interactors.cryptocoins.ShowCryptoCoinsUseCaseImpl
import by.khryshchanovich.cryptocoins.presentation.utils.isNetworkConnected
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CryptoCoinsViewModel @Inject constructor(
    private val app: Application,
    private var getCryptoCoinsUseCase: GetCryptoCoinsUseCaseImpl,
    private var saveCryptoCoinUseCase: SaveCryptoCoinsUseCaseImpl,
    private var removeCryptoCoinUseCase: RemoveCryptoCoinsUseCaseImpl,
    private var showCryptoCoinUseCase: ShowCryptoCoinsUseCaseImpl
) : AndroidViewModel(app) {

    private val _cryptoCoinsListFromDb = MutableLiveData<List<CryptoCoinsInfo>>()
    val cryptoCoinsListFromDb: LiveData<List<CryptoCoinsInfo>>
        get() = _cryptoCoinsListFromDb

    private val _errorBus = MutableLiveData<String>()
    val errorBus: LiveData<String>
        get() = _errorBus

    init {
        CoroutineScope(Dispatchers.IO).launch {
            if (isNetworkConnected(app))
                removeCryptoCoinUseCase.invoke()
            try {
                val listCryptoCoins = getCryptoCoinsUseCase.invoke()
                saveCryptoCoinUseCase.invoke(listCryptoCoins)
                val listCryptoCoinsFromDb = showCryptoCoinUseCase.invoke()
                _cryptoCoinsListFromDb.postValue(listCryptoCoinsFromDb)
            } catch (e: Exception) {
                _errorBus.postValue(e.message)
            }
        }
    }
}