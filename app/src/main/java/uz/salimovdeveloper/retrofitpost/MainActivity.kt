package uz.salimovdeveloper.retrofitpost

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.salimovdeveloper.retrofitpost.adapters.RvAdapter
import uz.salimovdeveloper.retrofitpost.databinding.ActivityMainBinding
import uz.salimovdeveloper.retrofitpost.databinding.ItemDialogBinding
import uz.salimovdeveloper.retrofitpost.models.MyTodoGetResponse
import uz.salimovdeveloper.retrofitpost.models.MyTodoPostRequest
import uz.salimovdeveloper.retrofitpost.retrofit.ApiClient

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

        postData()
    }

    private fun getData() {
        ApiClient.getRetrofitService().getAllTodo()
            .enqueue(object : Callback<List<MyTodoGetResponse>> {
                override fun onResponse(
                    call: Call<List<MyTodoGetResponse>>,
                    response: Response<List<MyTodoGetResponse>>
                ) {
                    if (response.isSuccessful){
                        rvAdapter = RvAdapter(response.body()!!)
                        binding.myRecyc.adapter = rvAdapter
                    }
                }

                override fun onFailure(call: Call<List<MyTodoGetResponse>>, t: Throwable) {
                    Toast.makeText(
                        this@MainActivity,
                        "Internet bilan muammo!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        postData()
        return super.onOptionsItemSelected(item)
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
                    .enqueue(object : Callback<MyTodoGetResponse> {
                        override fun onResponse(
                            call: Call<MyTodoGetResponse>,
                            response: Response<MyTodoGetResponse>
                        ) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    this@MainActivity,
                                    "${response.body()?.sarlavha} saqlandi",
                                    Toast.LENGTH_SHORT
                                ).show()
                                getData()
                            }
                        }

                        override fun onFailure(call: Call<MyTodoGetResponse>, t: Throwable) {
                            Toast.makeText(
                                this@MainActivity,
                                "Internet bilan muammo bor",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
            }
        }

        dialog.show()
    }


}