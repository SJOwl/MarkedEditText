package am.sj.algos

var textEdit = ""

fun main(args: Array<String>) {

}

var added: Int = 0
var removed: Int = 0
var replaced: Int = 0
var beforeReplace: Int = 0
var start: Int = 0

fun beforeTextChanged(s: String, stt: Int, count: Int, after: Int) {
    start = stt
    added = if (count == 0) after else 0
    removed = if (after == 0) count else 0
    replaced = if (count != 0 && after != 0) after else 0 // from $start $count symbols replaced by $after
    beforeReplace = if (replaced != 0) count else 0
}

fun onTextChanged(s: String, strt: Int, before: Int, count: Int) {
    /**
     *      if added 1 symbol
     *        check for "^@|" or " @|" : open new item, show richtext, search for "" and return
     *
     *      if added symbols
     *          if user edited - remove user and create text
     *          else edit text
     *      if removed
     *          if part of user removed - remove user and create text
     *          edit text
     *      if replaced
     *          if part of user - remove user and create text
     *          edit text
     *
     *      concat text parts which are near until have no text together
     *
     *      on click user - set id and set text
     */

    // close item on user click

    if (added == 1) {
        if (s[start] == '@' /*... many conditions */) {
            openUserItem(start)
            queryUser()
        }
    } else {
        if (added != 0) editAdd(s, start, added)
        if (removed != 0) editRemoved(s, start, removed) // if user removed - concat with text
        if (replaced != 0) editReplace(s, start, before, replaced)
    }

    concatTextItems()
    showRich()
}

/**
 * iterate through list and concat neighbor text items
 */
fun concatTextItems() {
    val items = mutableListOf<String>()
    items.add(" x")
    items.add(" y")
    items.add("z")
    items.add(" a")
    items.add(" v")
    val newItems = mutableListOf<String>()
    val wasUnites = mutableListOf<Int>()
    for (i in 0 until items.size) {
        if (i+1 < items.size && items[i + 1].contains(" ") && items[i].contains(" ")) {
            newItems.add("${items[i]}${items[i + 1]}")
            wasUnites.add(i)
            wasUnites.add(i+1)
        }
        if(!wasUnites.contains(i)) newItems.add(items[i])
    }
    print(newItems)
}

fun editAdd(newString: String, start: Int, count: Int) {
    /**
     * find item with this start
     *  if it's user - edit and request it
     * text - add text to it
     * */
}

fun editRemoved(newString: String, start: Int, count: Int) {
    /**
     *  find item where symbols removed
     *  if > 1 items are touched, edit them
     *  if user edited - remove id from it and replace with text item
     *  can remove whole items
     * */
}

fun editReplace(newString: String, start: Int, countWas: Int, countNow: Int) {
    editRemoved(textEdit, start, countWas)
    editAdd(newString, start, countNow)
}

fun showRich() {
    // set spannable to edittext
}

fun queryUser() {

}

fun openUserItem(start: Int) {

}

fun symbolsAdded(before: Int, count: Int): Int {
    return count - before
}

// Hi, @Dmi Che! How are you?