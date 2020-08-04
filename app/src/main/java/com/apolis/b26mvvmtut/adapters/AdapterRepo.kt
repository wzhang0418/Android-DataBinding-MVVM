package com.apolis.b26mvvmtut.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.apolis.b26mvvmtut.model.GithubRepository
import com.hb.b26mvvmtut.databinding.RowRepoAdapterBinding

class AdapterRepo(val context: Context) : RecyclerView.Adapter<AdapterRepo.MyViewHolder>() {

    private val listItems = ArrayList<GithubRepository>()

    fun setData(list: List<GithubRepository>){
        listItems.clear()
        listItems.addAll(list)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(private val binding: RowRepoAdapterBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: GithubRepository){
            binding.item = item
            binding.adapter = this@AdapterRepo
            //binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRepo.MyViewHolder {
        val binding = RowRepoAdapterBinding.inflate(LayoutInflater.from(parent.context))
        val layoutParams = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
        )
        binding.root.layoutParams = layoutParams
        return MyViewHolder(binding)
    }

    override fun getItemCount() = listItems.size

    override fun onBindViewHolder(holder: AdapterRepo.MyViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    fun onItemClicked(item: GithubRepository){
        Toast.makeText(context, "${item.name}", Toast.LENGTH_LONG).show()
    }
}