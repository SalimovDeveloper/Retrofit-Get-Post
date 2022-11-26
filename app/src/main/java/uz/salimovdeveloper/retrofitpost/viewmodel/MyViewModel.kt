package uz.salimovdeveloper.retrofitpost.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.salimovdeveloper.retrofitpost.models.MyTodoGetResponse
import uz.salimovdeveloper.retrofitpost.retrofit.ApiClient

class MyViewModel : ViewModel() {

    private val todoListLiveData = MutableLiveData<List<MyTodoGetResponse>>()

    fun getMyTodo():MutableLiveData<List<MyTodoGetResponse>>{

         ApiClient.getRetrofitService().getAllTodo()
             .enqueue(object : Callback<List<MyTodoGetResponse>>{
                 override fun onResponse(
                     call: Call<List<MyTodoGetResponse>>,
                     response: Response<List<MyTodoGetResponse>>
                 ) {
                     if (response.isSuccessful){
                         todoListLiveData.postValue(response.body())
                     }
                 }

                 override fun onFailure(call: Call<List<MyTodoGetResponse>>, t: Throwable) {
                     todoListLiveData.postValue(emptyList())
                 }
             })

        return todoListLiveData
    }
}