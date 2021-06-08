package by.khryshchanovich.cryptocoins.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo
import by.khryshchanovich.cryptocoins.presentation.App
import by.khryshchanovich.cryptocoins.R
import by.khryshchanovich.cryptocoins.databinding.ActivityMainBinding
import by.khryshchanovich.cryptocoins.presentation.view.adapter.CryptoCoinsAdapter
import by.khryshchanovich.cryptocoins.presentation.viewmodel.CryptoCoinsViewModel
import javax.inject.Inject

class CryptoCoinsActivity : AppCompatActivity() {
    @Inject
    lateinit var cryptoCoinsViewModel: CryptoCoinsViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeInjector()
        observeData()
    }

    private fun initializeInjector() {
        val app = applicationContext as App
        val appComponent = app.getAppComponent()
        appComponent.initializeCryptoCoinsActivity(this)
    }

    private fun observeData() {
        cryptoCoinsViewModel.cryptoCoinsListFromDb.observe(this, Observer {
            initializeView(it)
        })
        cryptoCoinsViewModel.errorBus.observe(this, Observer {
            showError()
        })
    }

    private fun initializeView(listCryptoCoinsInfo: List<CryptoCoinsInfo>) {
        with(binding) {
            with(cryptoCoinsRecyclerView) {
                layoutManager = LinearLayoutManager(this@CryptoCoinsActivity)
                adapter = CryptoCoinsAdapter(listCryptoCoinsInfo)
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show()
    }
}