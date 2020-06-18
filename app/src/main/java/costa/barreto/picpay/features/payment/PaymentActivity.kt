package costa.barreto.picpay.features.payment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import costa.barreto.picpay.R
import costa.barreto.picpay.features.payment.ui.PaymentFragment
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PaymentFragment.newInstance())
                .commitNow()
        }

        setupToolbar()

    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}