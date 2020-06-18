package costa.barreto.picpay.features.credcard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import costa.barreto.picpay.databinding.PrimingFragmentBinding
import costa.barreto.picpay.features.credcard.FragmentChangeListener


class PrimingFragment : Fragment() {

    companion object {
        fun newInstance() = PrimingFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: PrimingFragmentBinding =
            PrimingFragmentBinding.inflate(inflater, container, false)

        binding.btnPriming.setOnClickListener {
            val fc = activity as FragmentChangeListener?
            fc?.replaceFragment(RegisterFragment.newInstance())
        }

        return binding.root
    }

}