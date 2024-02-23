package com.example.dodoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//
//interface ButtonClickListener{
//    fun onButtonClick(item: ItemsViewModel)
//}

class CustomAdapter(private val originalList: List<ItemsViewModel>, private val buttonClickListener: ButtonClickListener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface ButtonClickListener {
        fun onButtonClick(item: ItemsViewModel)
    }

    //making filteredList to show views by filter
    private var filteredList: List<ItemsViewModel> = originalList


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = filteredList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.TextName.text = ItemsViewModel.Nametext
        holder.TextDesc.text = ItemsViewModel.DescText
        holder.Button.text = ItemsViewModel.ButtonText


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return filteredList.size
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val TextName: TextView = itemView.findViewById(R.id.nameText)
        val TextDesc: TextView = itemView.findViewById(R.id.descrtpText)
        val Button: Button = itemView.findViewById(R.id.button)

        init {
            Button.setOnClickListener {
                buttonClickListener.onButtonClick(originalList[adapterPosition])
            }

        }

    }
    //function for filter a data
    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            originalList
        } else {
            originalList.filter { it.Nametext.contains(query, ignoreCase = true) || it.DescText.contains(query, ignoreCase = true)}
        }
        notifyDataSetChanged()
    }
}

