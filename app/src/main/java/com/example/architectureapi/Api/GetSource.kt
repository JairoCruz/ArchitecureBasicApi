package com.example.archite

import com.example.architectureapi.Api.Service
import com.example.architectureapi.Api.SourceResponse
import com.example.architectureapi.Model.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


fun getSource(
    service: Service,
    apiKey: String,
    onSuccess: (source: List<Source>) -> Unit,
    onError: (error: String) -> Unit
){

     service.getSources(apiKey).enqueue(
         object : Callback<SourceResponse> {
             override fun onResponse(call: Call<SourceResponse>, response: Response<SourceResponse>) {
                if (response.isSuccessful){
                    val sources = response.body()?.sources ?: emptyList()
                    onSuccess(sources)
                }else{
                    onError(response.errorBody()?.string() ?: "Error Desconocido")
                }
             }

             override fun onFailure(call: Call<SourceResponse>, t: Throwable) {
                 onError(t?.message ?: "Error Desconocido")
             }

         }
     )

}