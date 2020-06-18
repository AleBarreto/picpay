package costa.barreto.picpay.features.credcard.ui

import android.text.Editable
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orhanobut.hawk.Hawk
import costa.barreto.picpay.features.credcard.model.CredCard

class RegisterViewModel : ViewModel(), LifecycleObserver {

    val credCardNumber = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val date = MutableLiveData<String>()
    val cvv = MutableLiveData<String>()
    val buttonVisible = MutableLiveData<Boolean>()

    init {
        if (Hawk.contains("cred_card_pref")) {
            val credCard = Hawk.get<CredCard>("cred_card_pref")
            credCardNumber.value = credCard.cardNumber
            name.value = credCard.name
            date.value = credCard.expiryDate
            cvv.value = credCard.cvv.toString()
        }
    }

    fun onAfterTextChange(s: Editable) {
        buttonVisible.value =
            (!credCardNumber.value.toString().isNullOrBlank() && !name.value.toString().isNullOrBlank() && !date.value.toString().isNullOrBlank() && !cvv.value.toString().isNullOrBlank())
    }

    fun saveCredCard(): Boolean {
        return Hawk.put(
            "cred_card_pref", CredCard(
                credCardNumber.value.toString(),
                name.value.toString(),
                cvv.value.toString().toInt(),
                0.0,
                date.value.toString(),
                0
            )
        )
    }

}