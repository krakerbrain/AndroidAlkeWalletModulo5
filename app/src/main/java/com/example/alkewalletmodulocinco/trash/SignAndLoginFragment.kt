//package com.example.alkewalletmodulocinco.view.fragments
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import com.example.alkewalletmodulocinco.R
//import com.example.alkewalletmodulocinco.databinding.FragmentSignAndLoginBinding
//
//class SignAndLoginFragment : Fragment() {
//    private var _binding: FragmentSignAndLoginBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentSignAndLoginBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val isLogin = arguments?.getBoolean("isLogin", true) ?: true
//
//        val fragment: Fragment =  if (isLogin) {
//            binding.tituloArriba.text = getString(R.string.logea_y_empeza_a)
//            binding.tituloAbajo.text = getString(R.string.transferir)
//            LoginFragment()
//        }else{
//            binding.tituloArriba.text = getString(R.string.registrarse_y)
//            binding.tituloAbajo.text = getString(R.string.empezar_a_transferir)
//            SignUpFragment()
//        }
//
//        childFragmentManager.beginTransaction()
//            .replace(R.id.formContainer, fragment)
//            .commit()
//    }
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}