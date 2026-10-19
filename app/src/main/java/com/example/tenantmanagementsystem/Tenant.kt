package com.example.tenantmanagementsystem
import java.io.Serializable

// ": Serializable" lets a whole Tenant be packed up and sent to another screen
data class Tenant(
    val name: String,
    val phone: String,
    val rent: String
) : Serializable {
    fun summary(): String {
        return "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
    }
}