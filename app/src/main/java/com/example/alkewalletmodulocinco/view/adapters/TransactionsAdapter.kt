package com.example.alkewalletmodulocinco.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkewalletmodulocinco.R
import com.example.alkewalletmodulocinco.databinding.ItemTransactionBinding
import com.example.alkewalletmodulocinco.model.Transaction

class TransactionsAdapter(private val transactions: List<Transaction>) :
    RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(private val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(transaction: Transaction) {

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
        holder.bind(transactions[position])
    }

    override fun getItemCount(): Int {
        val size = transactions.size
        return size
    }
}
