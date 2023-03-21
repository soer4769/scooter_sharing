package dk.itu.moapd.scootersharing.skas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dk.itu.moapd.scootersharing.skas.databinding.ListRidesBinding

class ListRidesAdapter(private val scooterList: ArrayList<Scooter>) : RecyclerView.Adapter<ListRidesAdapter.ListRidesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRidesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListRidesBinding.inflate(inflater, parent, false)
        return ListRidesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListRidesViewHolder, position: Int) = holder.bind(scooterList[position])

    override fun getItemCount() = scooterList.size

    inner class ListRidesViewHolder(private val binding: ListRidesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(scooter: Scooter){
            binding.scooterName.text = scooter.name
            binding.scooterLocation.text = scooter.location
            binding.scooterTimestamp.text = scooter.timestamp.toString()
        }
    }
}