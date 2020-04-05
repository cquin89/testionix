package com.losingtimeapps.testionix.presentation

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.losingtimeapps.testionix.R
import com.losingtimeapps.testionix.data.remote.DataRepositoryImp
import com.losingtimeapps.testionix.domain.usecase.GetDataUseCase
import com.losingtimeapps.testionix.presentation.schedule.ScheduleImp
import com.losingtimeapps.testionix.util.NetworkModule.Companion.provideService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        putFullScreenFlag()
        initComponent()
        initVisualComponent()
        initObserver()


    }

    private fun initVisualComponent() {
        customMenuView1.setData(getString(R.string.title1), R.string.icon1)
        customMenuView2.setData(getString(R.string.title2), R.string.icon2)
        customMenuView3.setData(getString(R.string.title3), R.string.icon3)
        customMenuView4.setData(getString(R.string.title4), R.string.icon4)
        customMenuView5.setData(getString(R.string.title5), R.string.icon5)
        customMenuView6.setData(getString(R.string.title6), R.string.icon6)
        customMenuView1.setOnClickListener {
            getRutDialog()
        }

    }

    private fun initComponent() {
        val getDataUseCase = GetDataUseCase(
            DataRepositoryImp(provideService()),
            ScheduleImp()
        )
        mainViewModel =
            ViewModelProviders.of(this as MainActivity, MainViewModelFactory(getDataUseCase))
                .get(MainViewModel::class.java)

    }

    private fun initObserver() {
        mainViewModel.onGetDataObserver.observe(this, Observer {
            if (it.result.items.isNotEmpty() && it.result.items.size >= 2) {
                val item = it.result.items[2]
                showDataDialog(
                    item.name,
                    item.detail.email,
                    item.detail.phoneNumber
                )
            }
        })

        mainViewModel.onErrorObservable.observe(this, Observer {
            Log.e("Error", "Error: ${it.message}")
        })
    }

    private fun getRutDialog() {
        val txtUrl = EditText(this)

        txtUrl.hint = "Rut"

        AlertDialog.Builder(this)
            .setTitle("Ingrese Rut")
            .setView(txtUrl)
            .setPositiveButton(
                "Aceptar"
            ) { _, _ ->
                val rut = txtUrl.text.toString()
                mainViewModel.getUseData(rut)
            }
            .setNegativeButton(
                "Cancelar"
            ) { _, _ -> }
            .show()
    }

    private fun showDataDialog(name: String, email: String, number: String) {

        AlertDialog.Builder(this)
            .setTitle("Informacion de $name ")
            .setMessage("Email: $email\nNumero: $number")
            .setPositiveButton(
                "Ok"
            ) { _, _ ->

            }
            .show()
    }

    private fun putFullScreenFlag() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}
