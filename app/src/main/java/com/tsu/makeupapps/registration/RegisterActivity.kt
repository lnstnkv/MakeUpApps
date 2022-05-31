package com.tsu.makeupapps.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.tsu.makeupapps.R
import com.tsu.makeupapps.databinding.ActivityMainBinding
import com.tsu.makeupapps.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater) }
    private val imagePicker = ImagePicker(activityResultRegistry, this) { imageUri ->
        binding.imageViewAvatar.load(imageUri)

    }
    private val viewModel by lazy {
        ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        binding.imageViewAvatar.clipToOutline = true
        binding.buttonSelect.setOnClickListener {
            binding.imageViewAvatar.clipToOutline = true
            imagePicker.pickImage()
            binding.buttonSelect.setText(R.string.delete_photo)
        }
        binding.button.setOnClickListener {
            viewModel.checkEmail(binding.editTextEmailAddressReg.text.toString())
            viewModel.samePassword(  binding.editTextTextPassworReg.text.toString(), binding.editTextTextPasswordTwice.text.toString())
        }

    }

    private fun initView()  = with(binding){
        viewModel.isErrorEmail.observe(this@RegisterActivity) { isErrorEmail ->
            if (isErrorEmail == false) {
                Toast.makeText(this@RegisterActivity, R.string.error_email, Toast.LENGTH_LONG)
                    .show()
            }

        }
        viewModel.isErrorSamePassword.observe(this@RegisterActivity) { isErrorPassword ->
            if (isErrorPassword == false) {
                Toast.makeText(this@RegisterActivity, R.string.error_pwd, Toast.LENGTH_LONG)
                    .show()
            }
        }
        viewModel.isErrorPassword.observe(this@RegisterActivity) { isErrorPassword ->
            if (isErrorPassword == true) {
                Toast.makeText(this@RegisterActivity, R.string.error_pwd_len, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}