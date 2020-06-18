package costa.barreto.picpay.features.credcard

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

//Reference https://receitasdecodigo.com.br/android/como-inserir-mascara-em-um-edittext-no-android
class MaskWatcher(private val editText: EditText, private val mask: String) : TextWatcher {
    var isUpdating = false
    var old = ""
    override fun afterTextChanged(s: Editable) {}
    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        val str: String = unmask(s.toString()).toString()
        var mascara = ""
        if (isUpdating) {
            old = str
            isUpdating = false
            return
        }
        var i = 0
        for (m in mask.toCharArray()) {
            if (m != '#' && str.length > old.length) {
                mascara += m
                continue
            }
            mascara += try {
                str[i]
            } catch (e: Exception) {
                break
            }
            i++
        }
        isUpdating = true
        editText.setText(mascara)
        editText.setSelection(mascara.length)
    }

    fun unmask(s: String): String? {
        return s.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
            .replace("[/]".toRegex(), "")
            .replace("[(]".toRegex(), "").replace("[ ]".toRegex(), "").replace("[:]".toRegex(), "")
            .replace("[)]".toRegex(), "")
    }
}
