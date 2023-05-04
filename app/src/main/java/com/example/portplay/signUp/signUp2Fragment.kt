package com.example.portplay.signUp

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.portplay.R
import com.example.portplay.databinding.FragmentSignUp2Binding

class signUp2Fragment : SignUpFragment<FragmentSignUp2Binding>(R.layout.fragment_sign_up2) {
    val viewModel: SignUpViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel

        binding.hdSignUp2.setNavigationClickListener {
            gotoPrev()
        }

        binding.next.setOnClickListener {
            hideKeyboard()
            if (viewModel.inputPasswordCheck()) {
                gotoNext()
            }
            else{
                YoYo.with(Techniques.Shake)
                    .duration(500)
                    .repeat(0)
                    .playOn(binding.txtSign2Eror)
                binding.edtSignUp2Email.backgroundTintList = ColorStateList.valueOf(Color.rgb(250,49,49))
                binding.txtSign2Eror.visibility = View.VISIBLE
            }
        }
    }
    override val currentPage: Int = 2
}