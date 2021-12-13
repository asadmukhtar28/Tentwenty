package com.asad.tentwenty.ui.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel


/**
 * Abstract Activity which binds [ViewModel] [VM] and [ViewDataBinding] [VB]
 */
abstract class BaseActivity<VM : ViewModel, VB : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int,
) : AppCompatActivity() {
    protected abstract val viewModel: VM
    protected lateinit var bindings: VB
    protected lateinit var context: Context
    protected lateinit var progressBar: AlertDialog

    protected abstract fun getBindingVariable(): Int

    open fun initUi() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        bindings = DataBindingUtil.setContentView(this, layoutResId)
        bindings.setVariable(getBindingVariable(), viewModel)
        bindings.lifecycleOwner = this
        initUi()
    }

   /* override fun goBack() {
        onBackPressed()
    }

    override fun showSuccessMessage(successMessage: String?) {
        successMessage?.let {
            showShortToast(it)
        }
    }

    override fun showErrorMessage(error: String?) {
        if (error != null) {
            showShortToast(error)
        }
    }

    protected open fun onSessionExpired() {
    }

    override fun showProgressBar() {
        if (this::progressBar.isInitialized) {

            if (!progressBar.isShowing) {
                progressBar.show()
            }

        } else {
            progressBar = MaterialAlertDialogBuilder(this, R.style.AlertDialogTheme).also {
                it.setView(R.layout.dialog_progress)
                it.background = ColorDrawable(Color.TRANSPARENT)
                it.setCancelable(false)
                it.create()
            }.show()
        }
    }

    override fun hideProgressBar() {
        if (this::progressBar.isInitialized) {
            if (progressBar.isShowing) {
                progressBar.dismiss()
            }
        }
    }*/
}
