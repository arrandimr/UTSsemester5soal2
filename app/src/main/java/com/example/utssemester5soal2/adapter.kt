package com.example.utssemester5soal2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_fak.view.*

class adapter  (val itemFac: List<datafakultas>, val clickListener: (datafakultas) -> Unit) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_fak, parent, false)
        return PartViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(itemFac[position], clickListener)
    }
    override fun getItemCount() = itemFac.size

    class PartViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(data : datafakultas, clickListener: (datafakultas) -> Unit){
            itemView.gambar_fak.setImageResource(data.imgfak)
            itemView.listnama_fak.text = data.namafak
            itemView.setOnClickListener { clickListener(data) }
        }
    }
}
