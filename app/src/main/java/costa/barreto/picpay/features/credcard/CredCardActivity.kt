package costa.barreto.picpay.features.credcard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.orhanobut.hawk.Hawk
import costa.barreto.picpay.R
import costa.barreto.picpay.features.credcard.ui.PrimingFragment
import costa.barreto.picpay.features.credcard.ui.RegisterFragment
import kotlinx.android.synthetic.main.activity_cred_card.*

class CredCardActivity : AppCompatActivity(), FragmentChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cred_card)
        if (savedInstanceState == null) {
            addFragment()
        }
        setupToolbar()
    }

    private fun setupToolbar() {
        Hawk.init(this).build()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }

    private fun addFragment() {
        if (Hawk.contains("cred_card_pref")) {
            replaceFragment(RegisterFragment.newInstance())
        } else {
            replaceFragment(PrimingFragment.newInstance())
        }
    }

}