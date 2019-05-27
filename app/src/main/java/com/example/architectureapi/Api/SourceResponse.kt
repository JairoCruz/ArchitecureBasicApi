package com.example.architectureapi.Api

import com.example.architectureapi.Model.Source
import com.google.gson.annotations.SerializedName

data class SourceResponse(
    @SerializedName("sources")
    val sources: List<Source> = emptyList()
)