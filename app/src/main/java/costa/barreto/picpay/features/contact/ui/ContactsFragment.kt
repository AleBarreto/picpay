package costa.barreto.picpay.features.contact.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.orhanobut.hawk.Hawk
import costa.barreto.picpay.databinding.ContactsFragmentBinding
import costa.barreto.picpay.features.contact.AdapterContact
import costa.barreto.picpay.features.contact.model.Contact
import costa.barreto.picpay.features.credcard.CredCardActivity
import costa.barreto.picpay.features.payment.PaymentActivity
import costa.barreto.picpay.textChange

class ContactsFragment : Fragment() {

    companion object {
        fun newInstance() = ContactsFragment()
    }

    private lateinit var binding: ContactsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: ContactsViewModel =
            ViewModelProviders.of(this).get(ContactsViewModel::class.java)

        binding = ContactsFragmentBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        this.lifecycle.addObserver(viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Hawk.init(activity).build();

        //Setup Recyclerview
        val adapterContact = AdapterContact(emptyList()) {
            if (Hawk.contains("cred_card_pref")) {
                callActivity(it, PaymentActivity::class.java)
            } else {
                callActivity(it,CredCardActivity::class.java)
            }
        }
        binding.recyclerviewContacts.adapter = adapterContact

        //Filter list contacts
        binding.edSearch.textChange {
            adapterContact.filter.filter(it)
        }

    }

    private fun callActivity(user: Contact, javaCls: Class<*>) {
        val intent = Intent(activity, javaCls)
        intent.putExtra("contact", user)
        startActivity(intent)
    }

}
