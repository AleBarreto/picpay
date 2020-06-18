package costa.barreto.picpay.features.contact.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(val id: Int, val name: String, val img: String, val username: String) :
    Parcelable