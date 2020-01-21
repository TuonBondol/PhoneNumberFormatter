package com.example.phonenumberformatter

import com.google.common.base.Splitter

/****
 *
 * Created by TUON BONDOL Date: 09/01/2020
 *
 */

fun String.formattingPhoneNumberAndRemoveZero(phone: String?): String {
    if (phone == null) {
        return ""
    }
    if (phone.length < 8) {
        return phone
    }


    val tempPhone = phone.replace(" ", "") // Remove all space if find any
    val newPhone = if (tempPhone[0] == '0') {
        tempPhone.removeRange(0, 1)
    } else {
        tempPhone
    }
    val headNumber = "${newPhone[0]}${newPhone[1]}"
    val removeHeadNumber = newPhone.removeRange(0, 2)

    return when (removeHeadNumber.length) {
        6 -> {
            val normalNumberArray = Splitter.fixedLength(3).split(removeHeadNumber)
            var normalNumber = ""
            normalNumberArray.forEach { item ->
                normalNumber += item.plus(" ")
            }
            "$headNumber ${normalNumber.trim()}"
        }
        7 -> {
            val firstNumber = "${removeHeadNumber[0]}${removeHeadNumber[1]}${removeHeadNumber[2]}"
            val secondNumber = removeHeadNumber.removeRange(0, 3)
            "$headNumber $firstNumber $secondNumber"
        }
        else -> {
            "$headNumber $removeHeadNumber"
        }
    }
}