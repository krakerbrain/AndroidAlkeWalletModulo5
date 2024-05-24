package com.example.alkewalletmodulocinco.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TransactionRepository {

    private val transactions = mutableListOf<Transaction>()

    init {
        // Simulando datos de transacciones
        val sdf = SimpleDateFormat("MMM dd, hh:mm a", Locale.getDefault())
        transactions.add(Transaction(1000, "Compra en línea", sdf.format(Date()), "Pago", 123456, 1, 987654))
        transactions.add(Transaction(500, "Depósito", sdf.format(Date()), "Ingreso", 123457, 1, 0))
        transactions.add(Transaction(300, "Transferencia", sdf.format(Date()), "Pago", 123458, 2, 987654))
        transactions.add(Transaction(1300, "Estufa", sdf.format(Date()), "Pago", 123458, 1, 987654))
    }

    fun getTransactions(userId: Int): List<Transaction> {
        // Filtrar transacciones por userId
        return transactions.filter { it.userID.toInt().toLong() == userId.toLong() }
    }
}
