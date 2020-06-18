package costa.barreto.picpay.features.payment.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import costa.barreto.picpay.databinding.PaymentFragmentBinding
import costa.barreto.picpay.features.contact.model.Contact
import costa.barreto.picpay.features.credcard.CredCardActivity


class PaymentFragment : Fragment() {

    companion object {
        fun newInstance() = PaymentFragment()
    }
    lateinit var viewModel: PaymentViewModel
    lateinit var binding: PaymentFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PaymentFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProviders.of(this).get(PaymentViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        this.lifecycle.addObserver(viewModel)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contact = activity?.intent?.getParcelableExtra<Contact>("contact")
        viewModel.contact.value = contact

        binding.btnEdit.setOnClickListener {
            val intent = Intent(activity, CredCardActivity::class.java)
            intent.putExtra("contact",contact)
            startActivity(intent)
        }

        binding.btnPayment.setOnClickListener {
            CompletePaymentDialog.newInstance().show(activity?.supportFragmentManager,"TAG")
        }

    }


}