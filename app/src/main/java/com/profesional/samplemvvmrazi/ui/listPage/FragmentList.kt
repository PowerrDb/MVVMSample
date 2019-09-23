package com.profesional.samplemvvmrazi.ui.listPage

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.profesional.samplemvvmrazi.R
import com.profesional.samplemvvmrazi.databinding.FragmentListBinding
import com.profesional.samplemvvmrazi.di.AppInjection
import com.profesional.samplemvvmrazi.utils.Result
import com.profesional.samplemvvmrazi.utils.ext.applyIoScheduler
import com.profesional.samplemvvmrazi.utils.ext.observe
import javax.inject.Inject


class FragmentList : Fragment() {
    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory
    val listViewModel: ListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ListViewModel::class.java)
    }
    private lateinit var binding: FragmentListBinding
    private val adapter: ListInfoAdapter by lazy { ListInfoAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AppInjection.of(context).inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(listViewModel.listInfo, ::onGetData)
        init()
    }

    @SuppressLint("CheckResult")
    private fun init() {
        binding.plantList.adapter = adapter
        adapter.itemClickEvent.applyIoScheduler().subscribe {
            //do what ever with viewModel
            // like : ViewModel.someMethod()
        }
    }


    private fun onGetData(list: Result<List<ListModel>>) {
        when (list) {
            is Result.Success<List<ListModel>> -> {
                adapter.submitList(list.data)
                binding.isGone = false

            }
            is Result.Failure<List<ListModel>> -> {
                binding.isGone = false
                Log.e("__fail", list.message.message)
            }
            is Result.Loading -> {
                binding.isGone = true
                Log.e("__load", "loading....")
            }
        }
    }


}
