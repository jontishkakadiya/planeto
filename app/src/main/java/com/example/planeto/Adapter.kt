package com.example.planeto

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.planeto.databinding.ViewBinding
import java.util.Locale


class Adapter(private var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {
    inner class MyViewHolder(private val binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(planet: PlanetData) {
            binding.title.text = planet.title
            binding.galaxy.text = planet.galaxy
            binding.distance.text = planet.distance
            binding.gravity.text = planet.gravity
        }

        var planetimg = binding.planetImg

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return planet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var dummyImage: Int? = null

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, PlanetDetails::class.java)
            intent.putExtra("planet", planet[position])
            intent.putExtra("planetImage", dummyImage)
            holder.itemView.context.startActivity(intent)
        }
        holder.bind((planet[position]))

        when (planet[position].title!!.lowercase(Locale.getDefault())) {

            "mars" -> {
                dummyImage = R.drawable.mars
            }

            "neptune" -> {
                dummyImage = R.drawable.neptune
            }

            "earth" -> {
                dummyImage = R.drawable.earth
            }

            "moon" -> {
                dummyImage = R.drawable.moon
            }

            "venus" -> {
                dummyImage = R.drawable.venus
            }

            "jupiter" -> {
                dummyImage = R.drawable.jupiter
            }

            "saturn" -> {
                dummyImage = R.drawable.saturn
            }

            "uranus" -> {
                dummyImage = R.drawable.uranus
            }

            "mercury" -> {
                dummyImage = R.drawable.mercury
            }

            "sun" -> {
                dummyImage = R.drawable.sun
            }
        }

        holder.planetimg.setImageResource(dummyImage!!)

    }
}
