object TextUtil {
    fun toPrettyJson(src: Any): String {
        val str = Gson().toJson(src)
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()
        val jp = JsonParser()
        val je: JsonElement = jp.parse(str)

        return gson.toJson(je)
    }

    fun toPrettyJson(str: String): String {
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()
        val jp = JsonParser()
        val je: JsonElement = jp.parse(str)

        return gson.toJson(je)
    }

    fun toHtmlText(htmlStr: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(htmlStr, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(htmlStr)
        }
    }
}
