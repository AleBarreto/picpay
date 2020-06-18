package costa.barreto.picpay.features

import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import costa.barreto.picpay.R
import costa.barreto.picpay.features.contact.AdapterItemsContract
import costa.barreto.picpay.features.credcard.MaskWatcher
import costa.barreto.picpay.features.util.CircleTransform

class BindingAdapters {

    companion object {

        @BindingAdapter("items")
        @JvmStatic
        fun setItems(recyclerView: RecyclerView, list: List<*>) {
            recyclerView.adapter.let {
                if (it is AdapterItemsContract) {
                    it.replaceItems(list)
                }
            }
        }

        @BindingAdapter("imageCircleUrl")
        @JvmStatic
        fun setImage(img: ImageView, url: String) {
            Picasso.get().load(url).transform(CircleTransform()).into(img)
        }

        @BindingAdapter("maskField")
        @JvmStatic
        fun setMask(editText: EditText, mask: String) {
            editText.addTextChangedListener(MaskWatcher(editText, mask))
        }

        @BindingAdapter("colorTextController")
        @JvmStatic
        fun setColorText(view: TextView, flag: Boolean) {
            if (flag) {
                view.setTextColor(ContextCompat.getColor(view.context, R.color.enableForm))
            } else {
                view.setTextColor(ContextCompat.getColor(view.context, R.color.disableFrom))
            }
        }

        @BindingAdapter("backgroundButtonController")
        @JvmStatic
        fun setBackgroundButton(button: Button, flag: Boolean) {
            if (flag){
                button.background = ContextCompat.getDrawable(button.context,R.drawable.back_button_add_card)
            }else{
                button.background = ContextCompat.getDrawable(button.context,R.drawable.back_button_disable)
            }
        }

    }

}