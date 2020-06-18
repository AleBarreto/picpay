package costa.barreto.picpay

import costa.barreto.picpay.features.contact.model.Contact
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://careers.picpay.com/tests/mobdev/"

private val retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

interface UserApiService {

    @GET("users")
    fun getContacts(): Call<List<Contact>>

}

object UserApi {
    val retrofitService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}
