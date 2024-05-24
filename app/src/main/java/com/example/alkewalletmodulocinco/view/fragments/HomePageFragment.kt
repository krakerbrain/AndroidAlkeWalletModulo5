package com.example.alkewalletmodulocinco.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.alkewalletmodulocinco.R
import com.example.alkewalletmodulocinco.databinding.FragmentHomePageBinding
import com.example.alkewalletmodulocinco.viewmodel.HomePageViewModel

class HomePageFragment : Fragment() {
    private val homePageViewModel: HomePageViewModel by activityViewModels()

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePageViewModel.userData.observe(viewLifecycleOwner) { user ->
            user?.let { userData ->
                val fragment =
                    HeaderHomePageFragment.newInstance(userData.firstName, userData.points.toDouble())
                childFragmentManager.beginTransaction()
                    .replace(R.id.headerContainerHomePage, fragment)
                    .commit()
                // Agregar el TransactionListFragment
                val transactionListFragment = TransactionListFragment()
                childFragmentManager.beginTransaction()
                    .replace(R.id.transactionsContainer, transactionListFragment)
                    .commit()
                binding.enviarDinero.setOnClickListener {
                    findNavController().navigate(R.id.action_homePageFragment_to_enviarDineroFragment)
                }
                binding.ingresarDinero.setOnClickListener {
                    findNavController().navigate(R.id.action_homePageFragment_to_ingresarDineroFragment)
                }
                binding.headerContainerHomePage.profileImg.setOnClickListener {
                    findNavController().navigate(R.id.action_homePageFragment_to_profileFragment)
                }
            }
        }
    }
// enfoque xclase global para persistir datos entre vistas
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

