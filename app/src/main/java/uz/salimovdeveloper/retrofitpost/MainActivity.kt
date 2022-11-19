package uz.salimovdeveloper.retrofitpost

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import uz.salimovdeveloper.retrofitpost.databinding.ActivityMainBinding
import uz.salimovdeveloper.retrofitpost.databinding.ItemDialogBinding
import uz.salimovdeveloper.retrofitpost.models.MyTodoPostRequest
import uz.salimovdeveloper.retrofitpost.retrofit.ApiClient

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
        val dialog = AlertDialog.Builder(this).create()
        val itemDialogBinding = ItemDialogBinding.inflate(layoutInflater)
        dialog.setView(itemDialogBinding.root)

        itemDialogBinding.apply {
            btnSave.setOnClickListener {
                val myTodoPostRequest = MyTodoPostRequest(
                    dialogSpinner.selectedItem.toString(),
                    dialogMatn.text.toString(),
                    dialogDate.text.toString(),
                    dialogName.text.toString()
                )

                ApiClient.getRetrofitService().addAllTodo(myTodoPostRequest)
            }
        }

        dialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        postData()
        return super.onOptionsItemSelected(item)
    }

    private fun getData() {
        TODO("Not yet implemented")
    }
}