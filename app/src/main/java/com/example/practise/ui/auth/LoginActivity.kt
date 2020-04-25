package com.example.practise.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.practise.R
import com.example.practise.data.db.entites.User
import com.example.practise.databinding.ActivityLoginBindingImpl
import com.example.practise.ui.home.HomeActivity
import com.example.practise.utils.hide
import com.example.practise.utils.show
import com.example.practise.utils.snackbar
import com.example.practise.utils.toast
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.android.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel : AuthViewModel = ViewModelProvider(this,factory).get(AuthViewModel::class.java)

        val binding:ActivityLoginBindingImpl = DataBindingUtil.setContentView(this,R.layout.activity_login)

        binding.viewModel = viewModel

        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if(user != null){
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }

    override fun onStarted() {
        progress_bar.show()
        toast("On Started")
    }

    override fun onSuccess(loginRepository: User) {
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}
