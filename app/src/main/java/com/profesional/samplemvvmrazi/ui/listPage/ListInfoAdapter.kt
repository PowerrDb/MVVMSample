package com.profesional.samplemvvmrazi.ui.listPage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.profesional.samplemvvmrazi.databinding.ListItemBinding
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


class ListInfoAdapter:
    ListAdapter<ListModel,ListInfoAdapter.ViewHolder>(diffCallback) {

    private lateinit var binding: ListItemBinding
    private val onItemClickSubject = PublishSubject.create<ListModel>()
    val itemClickEvent: Observable<ListModel> = onItemClickSubject


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       binding =  ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var list = getItem(position)
        holder.bind(list)
    }


    inner class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {

            binding.setClickListener {
                binding.list?.let { list ->
                val directions = FragmentListDirections.actionFragmentListToFragmentItem(list.id.toString())
                    it.findNavController().navigate(directions)
                    onItemClickSubject.onNext(list)
               }
            }
        }
        fun bind(item: ListModel) {
            binding.apply {
                list = item
                executePendingBindings()
            }
        }
    }


    companion object {

        private val diffCallback: DiffUtil.ItemCallback<ListModel> =
            object : DiffUtil.ItemCallback<ListModel>() {

                override fun areItemsTheSame(oldItem: ListModel, newItem: ListModel): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: ListModel, newItem: ListModel): Boolean {
                    return oldItem == newItem
                }
            }
    }
}