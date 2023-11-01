package com.example.pruebadeiby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.inputmethod.InputMethodManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), android.support.v7.widget.SearchView.OnQueryTextListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchBreed.setOnQueryTextListener(this)
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/hound/images")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    override fun onQueryTextSubmit(query: String): Boolean {
        searchByName(query.toLowerCase())
        return true
    }
    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
    override fun onQueryTextSubmit(query: String): Boolean {
        return true
    }
    lateinit var imagesPuppies:List<String>

    private fun initCharacter(puppies: perros) {
        if(puppies.status == "success"){
            imagesPuppies = puppies.images
        }
        adaptador() = adaptador(imagesPuppies)
        fotop2.setHasFixedSize(true)
        fotop2.layoutManager = LinearLayoutManager(this)
        fotop2.adapter = adaptador
    }

    private fun hideKeyboard(){
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(viewRoot.windowToken, 0)
    }
}