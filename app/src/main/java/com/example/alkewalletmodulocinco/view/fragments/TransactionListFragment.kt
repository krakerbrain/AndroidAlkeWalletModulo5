package com.example.alkewalletmodulocinco.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alkewalletmodulocinco.R
import com.example.alkewalletmodulocinco.model.TransactionRepository
import com.example.alkewalletmodulocinco.view.adapters.TransactionsAdapter

class TransactionListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var transactionsAdapter: TransactionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_transactions_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Obtener las transacciones del repositorio
        val transactions = TransactionRepository().getTransactions(userId = 1)
        Log.d("Transactions", transactions.toString())

        // Inicializar el adaptador del RecyclerView
        transactionsAdapter = TransactionsAdapter(transactions)
        recyclerView.adapter = transactionsAdapter

        // Asegurarse de que el RecyclerView tenga múltiples elementos
        Log.d("TransactionsAdapter", "ItemCount: ${transactionsAdapter.itemCount}")

        return view
    }
}
