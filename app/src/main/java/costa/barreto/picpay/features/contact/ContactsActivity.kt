package costa.barreto.picpay.features.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import costa.barreto.picpay.R
import costa.barreto.picpay.features.contact.ui.ContactsFragment

class ContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contacts_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ContactsFragment.newInstance())
                .commitNow()
        }
    }
}
