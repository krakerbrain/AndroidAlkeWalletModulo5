package com.example.alkewalletmodulocinco.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.alkewalletmodulocinco.R

class HeaderHomePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_header_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString("name") ?: "N/A"
        val balance = arguments?.getDouble("balance") ?: 0.0

        val inicio: TextView = view.findViewById(R.id.inicio)
        val saludo: TextView = view.findViewById(R.id.saludo)
        val balanceTotal: TextView = view.findViewById(R.id.balanceTotal)
        val saldo: TextView = view.findViewById(R.id.saldo)

        // Establecer datos recibidos
        inicio.text = "Inicio"
        saludo.text = "Hola, $name"
        balanceTotal.text = "Balance Total"
        saldo.text = "$$balance"
    }

    companion object {
        fun newInstance(name: String, balance: Double): HeaderHomePageFragment {
            val fragment = HeaderHomePageFragment()
            val args = Bundle()
            args.putString("name", name)
            args.putDouble("balance", balance)
            fragment.arguments = args
            return fragment
        }
    }
}
