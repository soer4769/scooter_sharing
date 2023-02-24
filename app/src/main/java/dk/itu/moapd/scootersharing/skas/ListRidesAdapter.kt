package dk.itu.moapd.scootersharing.skas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListRidesAdapter(context: Context, private var resource: Int, data: List<Scooter>) :
    ArrayAdapter<Scooter>(context, R.layout.list_rides, data) {

    private class ViewHolder(view: View) {
        val name: TextView = view.findViewById(R.id.scooter_name)
        val location: TextView = view.findViewById(R.id.scooter_location)
        val timestamp: TextView = view.findViewById(R.id.scooter_timestamp)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: ViewHolder
        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(resource, parent, false)
            viewHolder = ViewHolder(view)
        } else
            viewHolder = view.tag as ViewHolder
        val dummy = getItem(position)
        viewHolder.name.text = dummy?.name
        viewHolder.location.text = dummy?.location
        viewHolder.timestamp.text = dummy?.timestamp.toString()
        view?.tag = viewHolder
        return view!!
    }
}