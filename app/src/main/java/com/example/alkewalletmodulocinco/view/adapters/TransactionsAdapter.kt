package com.example.alkewalletmodulocinco.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkewalletmodulocinco.R
import com.example.alkewalletmodulocinco.databinding.ItemTransactionBinding
import com.example.alkewalletmodulocinco.model.Transaction

class TransactionsAdapter(private val transactions: List<Transaction>) :
    RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {

    init {
        // Log the size of the transactions list
        Log.d("TransactionsAdapter", "Number of transactions: ${transactions.size}")
    }

    inner class TransactionViewHolder(private val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(transaction: Transaction) {
            // Log the transaction being bound
            Log.d("TransactionsAdapter", "Binding transaction: $transaction")
            binding.nameTextView.text = transaction.concept
            binding.dateTextView.text = transaction.date
            binding.amountTextView.text = if (transaction.type == "Pago") "-${transaction.amount}" else "+${transaction.amount}"

            // Cambiar el icono dependiendo del tipo de transacción
            val iconResource = if (transaction.type == "Pago") R.drawable.request_icon_azul else R.drawable.send_icon_amarillo
            binding.transactionTypeIcon.setImageResource(iconResource)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        Log.d("TransactionsAdapter", "onBindViewHolder position: $position")
        holder.bind(transactions[position])
    }

    override fun getItemCount(): Int {
        val size = transactions.size
        Log.d("TransactionsAdapter", "getItemCount: $size")
        return size
    }
}
