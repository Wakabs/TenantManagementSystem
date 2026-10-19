package com.example.tenantmanagementsystem

// An object has exactly one instance, shared by the whole app
object TenantRepository {
    val tenants = mutableListOf<Tenant>()

    fun addTenant(tenant: Tenant) {
        tenants.add(tenant)
    }

    // Convert each rent to a number; invalid text counts as 0.0 instead of crashing
    fun totalRent(): Double {
        return tenants.sumOf { it.rent.toDoubleOrNull() ?: 0.0 }
    }
}