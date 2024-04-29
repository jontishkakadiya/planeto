package com.example.planeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.planeto.databinding.ActivityPlanetDetailsBinding

class PlanetDetails : AppCompatActivity() {
    private  lateinit var binding: ActivityPlanetDetailsBinding
    private lateinit var obj:PlanetData
    private var planetImg: Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityPlanetDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        obj = intent.getParcelableExtra<PlanetData>("planet")!!
        planetImg = intent.getIntExtra("planetImage", -1)
        setData(obj, planetImg!!)
    }


    private fun setData(obj:PlanetData, planetImg:Int){

        binding.titleInfo.text = obj.title
        binding.distanceInfo.text = obj.distance+"m km"
        binding.gravityInfo.text = obj.gravity+"m/ss"
        binding.overviewInfo.text = obj.overview
        binding.galaxyInfo.text =obj.galaxy
        binding.planetImgInfo.setImageResource(planetImg)
    }
}