package uz.salimovdeveloper.retrofitpost.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import uz.salimovdeveloper.retrofitpost.models.MyTodoGetResponse
import uz.salimovdeveloper.retrofitpost.models.MyTodoPostRequest

interface RetrofitService {

    @GET("plan")
    fun getAllTodo():Call<List<MyTodoGetResponse>>

    @POST("plan/")
    fun addAllTodo(myTodoPostRequest: MyTodoPostRequest):MyTodoGetResponse
}