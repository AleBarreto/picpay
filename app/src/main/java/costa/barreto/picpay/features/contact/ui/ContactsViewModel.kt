package costa.barreto.picpay.features.contact.ui

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import costa.barreto.picpay.UserApi
import costa.barreto.picpay.features.contact.model.Contact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactsViewModel : ViewModel(), LifecycleObserver {
    val contacts = MutableLiveData<List<Contact>>().apply { value = emptyList() }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun load() {
        UserApi.retrofitService.getContacts().enqueue(object : Callback<List<Contact>> {
            override fun onFailure(call: Call<List<Contact>>, t: Throwable) {
                Log.d("ALECOSTA", "getContacts - onFailure = " + t.localizedMessage)
            }

            override fun onResponse(call: Call<List<Contact>>, response: Response<List<Contact>>) {
                if (response.isSuccessful) {
                    response.body()?.let { contacts.value = it }
                } else {
                    Log.d("ALECOSTA", "response failure = " + response.code())
                }

            }
        })
    }


}
