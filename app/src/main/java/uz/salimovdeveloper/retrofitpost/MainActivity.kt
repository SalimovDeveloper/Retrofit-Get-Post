package uz.salimovdeveloper.retrofitpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.salimovdeveloper.retrofitpost.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

        postData()
    }

    private fun postData() {
        TODO("Not yet implemented")
    }

    private fun getData() {
        TODO("Not yet implemented")
    }
}