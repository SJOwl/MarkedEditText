package am.sj.algos

var textEdit = ""

fun main(args: Array<String>) {

}

var added: Int = 0
var removed: Int = 0
var replaced: Int = 0
var start: Int = 0

fun beforeTextChanged(s: String, stt: Int, count: Int, after: Int) {
    start = stt
    added = if (count == 0) after else 0
    removed = if (after == 0) count else 0
    replaced = if (count != 0 && after != 0) after else 0 // from $start $count symbols replaced by $after
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

    if (added == 1) {
        if (s[start] == '@' /*... many conditions */) {
            openItem(start)
            queryUser()
        }
    } else {
        if (added != 0) {
            if (editAddToUser(s, start, start + added)) {
                queryUser()
            } else { // edit text item
                editText(s, start, start + added)
            }
        }
        if (removed != 0) {
            if (editRemoveFromUser(s, start, start + removed)) { // if user removed - concat with text
                queryUser()
            } else { // edit text item
                editText(s, start, start + added)
            }
        }
        if (replaced != 0) {

        }
    }

    showRich()
    concatTextItems()
}

fun concatTextItems() {

}

fun editRemoveFromUser(s: String, start: Int, count: Int): Boolean {
    return false
}

fun editText(s: String, start: Int, count: Int) {

}

fun editAddToUser(s: String, start: Int, count: Int): Boolean {
    return false
}

fun showRich() {

}

fun queryUser() {

}

fun openItem(start: Int) {

}


fun symbolsAdded(before: Int, count: Int): Int {
    return count - before
}

// Hi, @Dmi Che! How are you?