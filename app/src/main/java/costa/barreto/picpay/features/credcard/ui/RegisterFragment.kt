package costa.barreto.picpay.features.credcard.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.orhanobut.hawk.Hawk
import costa.barreto.picpay.databinding.RegisterCardFragmentBinding
import costa.barreto.picpay.features.contact.model.Contact
import costa.barreto.picpay.features.payment.PaymentActivity


class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var binding: RegisterCardFragmentBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Hawk.init(activity).build();

        binding = RegisterCardFragmentBinding.inflate(inflater, container, false)

        viewModel =
            ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        this.lifecycle.addObserver(viewModel)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveCard.setOnClickListener {
            if (viewModel.saveCredCard()) {
                val intent = Intent(activity, PaymentActivity::class.java)
                val contact = activity?.intent?.getParcelableExtra<Contact>("contact")
                intent.putExtra("contact", contact)
                startActivity(intent)
                activity?.finish()
            } else {
                //error in save credCard
            }
        }

    }

}