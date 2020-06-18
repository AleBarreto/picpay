package costa.barreto.picpay

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText


fun EditText.textChange(textChange: (String) -> Unit) {

    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            textChange(s.toString())
        }
    })

}


//val mapType = HashMap<String, String>()
//mapType["visa"] = "^4[0-9]{6,}$"
//mapType["MasterCard"] = "^5[1-5][0-9]{5,}$"
//mapType["American Express"] = "^3[47][0-9]{5,}$"
//mapType["Diners Club"] = "^3(?:0[0-5]|[68][0-9])[0-9]{4,}$"
//mapType["Discover"] = "^6(?:011|5[0-9]{2})[0-9]{3,}$"
//mapType["JCB"] = "^(?:2131|1800|35[0-9]{3})[0-9]{3,}$"