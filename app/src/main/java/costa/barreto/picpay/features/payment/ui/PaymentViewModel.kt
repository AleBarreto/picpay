package costa.barreto.picpay.features.payment.ui

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import costa.barreto.picpay.features.contact.model.Contact

class PaymentViewModel : ViewModel(), LifecycleObserver {

    val contact = MutableLiveData<Contact>()
    val controllerEnable = MutableLiveData<Boolean>()

    fun onAfterTextChange(s: Editable) {
        controllerEnable.value = !s.toString().isNullOrBlank()
    }

}