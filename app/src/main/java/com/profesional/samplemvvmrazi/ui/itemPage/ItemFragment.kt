package com.profesional.samplemvvmrazi.ui.itemPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.profesional.samplemvvmrazi.R
import com.profesional.samplemvvmrazi.databinding.FragmentItemBinding
import com.profesional.samplemvvmrazi.di.AppInjection
import com.profesional.samplemvvmrazi.utils.Result
import com.profesional.samplemvvmrazi.utils.ext.observe
import javax.inject.Inject


class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemBinding

    private val arg: ItemFragmentArgs by navArgs()

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    val homeViewModell: ItemViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ItemViewModel::class.java).also {
            it.itemIDd = arg.itemmId
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppInjection.of(context).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentItemBinding>(
            inflater,
            R.layout.fragment_item,
            container,
            false
        ).apply {
            homeViewModel = homeViewModell
            var isToolbarShown = false

            toolbar.setOnClickListener { it.findNavController().navigateUp() }

            plantDetailScrollview.setOnScrollChangeListener(
                NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->

                    val shouldShowToolbar = scrollY > toolbar.height

                    if (isToolbarShown != shouldShowToolbar) {
                        isToolbarShown = shouldShowToolbar

                        appbar.isActivated = shouldShowToolbar

                        toolbarLayout.isTitleEnabled = shouldShowToolbar
                    }
                }
            )

        }

        observe(homeViewModell.planet, ::setData)
        setHasOptionsMenu(true)
        return binding.root

    }

    private fun setData(result: Result<ItemModel>) {
        when (result) {
            is Result.Success<ItemModel> -> {
                binding.isGone = false
                binding.apply {
                    itemm = result.data
                    executePendingBindings()
                }

            }
            is Result.Failure<ItemModel> -> binding.isGone = false

            is Result.Loading -> binding.isGone = true


        }
    }


}




