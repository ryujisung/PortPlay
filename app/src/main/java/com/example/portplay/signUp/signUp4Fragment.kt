package com.example.portplay.signUp

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.portplay.R
import com.example.portplay.databinding.FragmentSignUp3Binding
import com.example.portplay.databinding.FragmentSignUp4Binding


class signUp4Fragment : SignUpFragment<FragmentSignUp4Binding>(R.layout.fragment_sign_up4) {
    val viewModel: SignUpViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel

        binding.hdSignUp3.setNavigationClickListener {
            gotoPrev()
        }

        binding.next.setOnClickListener {
            hideKeyboard()
            if (viewModel.inputCheckNameNickName()) {
                if(viewModel.sigininAndSignup()) {
                    gotoNext()
                }
            }
            else{
                YoYo.with(Techniques.Shake)
                    .duration(500)
                    .repeat(0)
                    .playOn(binding.txtSign3Eror)
                binding.edtSignUp3Email.backgroundTintList = ColorStateList.valueOf(Color.rgb(250,49,49))
                binding.txtSign3Eror.visibility = View.VISIBLE
            }
        }
    }
    override val currentPage: Int = 4
}