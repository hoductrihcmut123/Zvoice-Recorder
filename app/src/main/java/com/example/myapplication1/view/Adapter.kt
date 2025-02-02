package com.example.myapplication1.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.utils.OnItemClickListener
import com.example.myapplication1.R
import com.example.myapplication1.database.model.AudioRecordModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Adapter(private var records : ArrayList<AudioRecordModel>, var listener: OnItemClickListener) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener{
        var tvFilename : TextView = itemView.findViewById(R.id.tvFilename)
        var tvDuration : TextView = itemView.findViewById(R.id.tvDuration)
        var tvTimestamp : TextView = itemView.findViewById(R.id.tvTimestamp)

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            {
                listener.onItemClickListener(position)
            }
        }

        override fun onLongClick(v: View?): Boolean {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            {
                listener.onItemLongClickListener(position)
            }
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position != RecyclerView.NO_POSITION){
            val record = records[position]

            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val date = Date(record.timestamp.toLong() * 1000L)
            val strDate = sdf.format(date)

            holder.tvFilename.text = record.filename
            holder.tvTimestamp.text = strDate
            holder.tvDuration.text = record.duration
        }
    }

    override fun getItemCount(): Int {
        return records.size
    }
}