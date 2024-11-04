package com.example.retrofit_datalistformvvm.data


import com.google.gson.annotations.SerializedName

data class ResponseJoks(
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("delivery")
    val delivery: Boolean? = null,
    @SerializedName("error")
    val error: Boolean? = null,
    @SerializedName("flags")
    val flags: Flags? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("joke")
    var joke: String? = null,
    @SerializedName("lang")
    val lang: String? = null,
    @SerializedName("safe")
    val safe: Boolean? = null,
    @SerializedName("type")
    val type: String? = null
) {
    data class Flags(
        @SerializedName("explicit")
        val explicit: Boolean? = null,
        @SerializedName("nsfw")
        val nsfw: Boolean? = null,
        @SerializedName("political")
        val political: Boolean? = null,
        @SerializedName("racist")
        val racist: Boolean? = null,
        @SerializedName("religious")
        val religious: Boolean? = null,
        @SerializedName("sexist")
        val sexist: Boolean? = null
    )
}