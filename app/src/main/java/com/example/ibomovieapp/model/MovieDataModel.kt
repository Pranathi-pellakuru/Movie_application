package com.example.ibomovieapp.model

import com.google.gson.annotations.SerializedName



data class MovieDataModel (

    @SerializedName("title"           ) var title          : String? = null,
    @SerializedName("type"            ) var type           : String? = null,
    @SerializedName("titlereleased"   ) var titlereleased  : String? = null,
    @SerializedName("image_landscape" ) var imageLandscape : String? = null,
    @SerializedName("image_portrait"  ) var imagePortrait  : String? = null,
    @SerializedName("rating"          ) var rating         : String? = null,
    @SerializedName("quality"         ) var quality        : String? = null,
    @SerializedName("actors"          ) var actors         : String? = null,
    @SerializedName("director"        ) var director       : String? = null,
    @SerializedName("category"        ) var category       : String? = null,
    @SerializedName("imdb"            ) var imdb           : String? = null,
    @SerializedName("runtime"         ) var runtime        : String? = null,
    @SerializedName("netflixid"       ) var netflixid      : String? = null,
    @SerializedName("date_released"   ) var dateReleased   : String? = null,
    @SerializedName("description"     ) var description    : String? = null,
    @SerializedName("language"        ) var language       : String? = null

)