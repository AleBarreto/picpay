package costa.barreto.picpay.features.credcard.model

data class CredCard(
    val cardNumber: String,
    val name: String,
    val cvv: Int,
    val value: Double,
    val expiryDate: String,
    val destinationUserId: Int
)