package it.unical.demacs.pierluigi.finted_android.infrastructure

typealias MultiValueMap = Map<String, List<String>>

fun collectionDelimiter(collectionFormat: String) = when (collectionFormat) {
    "csv" -> ","
    "tsv" -> "\t"
    "pipes" -> "|"
    "ssv" -> " "
    else -> ""
}

val defaultMultiValueConverter: (item: Any?) -> String = { item -> "$item" }

fun <T : Any?> toMultiValue(items: List<T>, collectionFormat: String, map: (item: Any?) -> String = defaultMultiValueConverter): List<String> {
    return when (collectionFormat) {
        "multi" -> items.map(map)
        else -> listOf(items.map(map).joinToString(separator = collectionDelimiter(collectionFormat)))
    }
}