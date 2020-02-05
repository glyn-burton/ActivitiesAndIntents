package com.example.activitiesandintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import kotlinx.android.synthetic.main.activity_emi.*
import kotlin.math.pow


class EMIActivity : AppCompatActivity() {

    lateinit var principalAmt:SeekBar
    lateinit var monthPayment:SeekBar
    lateinit var monthInterest:SeekBar

    var principal = 0
    var monthlypayment = 0
    var monthlyinterest = 0
    var resultAmt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emi)

        principalAmt = findViewById(R.id.sbPrincipal) as SeekBar

        principalAmt.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
            {
                tvPrincipal.text = progress.toString()
                principal = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        monthPayment = findViewById(R.id.sbMonthlyInstallments) as SeekBar

        monthPayment.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
            {
                tvMonthlyInstallments.text = progress.toString()
                monthlypayment = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        monthInterest = findViewById(R.id.sbMonthlyInterestRate) as SeekBar

        monthInterest.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
            {
                tvMonthlyInterestRate.text = progress.toString()
                monthlyinterest = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })



    }






    fun emiCalc(view: View) {
        var P = principal.toDouble()
        var R = monthlyinterest/100.toDouble()
        var N = monthlypayment.toDouble()
        Log.d("TAG",principal.toString())

        resultAmt = ((P * R * (1 + R).pow(N) / (1 + R).pow(N - 1)).toInt())

        tvResultScreen.text = resultAmt.toString()


    }


    /*
    The mathematical formula for calculating EMIs is: EMI = [P x R x (1+R)^N]/[(1+R)^N-1]
    where P stands for the loan amount or principal, R is the interest rate per month
    [if the interest rate per annum is 11%, then the rate of interest will be 11/(12 x 100)],
    and N is the number of monthly instalments.




     */
}
