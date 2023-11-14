package com.example.retrosample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class myAdapter(): RecyclerView.Adapter<myAdapter.myViewHolder>() {
    var mylist = ArrayList<TodosItem>()

class myViewHolder(var itemView: View):RecyclerView.ViewHolder(itemView){
    var tv:TextView = itemView.findViewById(R.id.tv)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.itemsrec,parent,false))
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return mylist.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var l = mylist.get(position)
        holder.tv.text = l.title
       // notifyDataSetChanged()


    }
    fun setList( listrec:ArrayList<TodosItem>){
        mylist.clear()
        mylist.addAll(listrec)
        notifyDataSetChanged()
        Log.d("Hii",listrec.toString())


    }
}