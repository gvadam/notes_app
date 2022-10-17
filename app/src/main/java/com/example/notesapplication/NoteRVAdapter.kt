package com.example.notesapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(val context: Context,
                    val noteClickInterface: NoteClickInterface,
                    val noteClickDeleteInterface: NoteClickDeleteInterface)
    : RecyclerView.Adapter<NoteRVAdapter.ViewHolder>(){

   private val allNotes = ArrayList<Note>()

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val noteTV = itemView.findViewById<TextView>(R.id.idRVNoteTitle)
       val timeTV = itemView.findViewById<TextView>(R.id.idTVTimeStamp)
       val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.noteTV.setText(allNotes.get(position).noteTitle)
        holder.timeTV.setText("Last Updated: " + allNotes.get(position).timeStamp)
        holder.deleteIV.setOnClickListener{
            noteClickDeleteInterface.onDeleteIconClick(allNotes.get(position))
        }
        holder.itemView.setOnClickListener{
            noteClickInterface.onNoteClick(allNotes.get(position))
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}
interface NoteClickDeleteInterface {
    fun onDeleteIconClick(note: Note)
}
interface NoteClickInterface {
    fun onNoteClick(note: Note)
}