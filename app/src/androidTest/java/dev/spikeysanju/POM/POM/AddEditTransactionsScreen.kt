package dev.spikeysanju.POM.POM

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import dev.spikeysanju.expensetracker.R

class AddEditTransactionsScreen {
    // Screen elements
    val transactionScreenTitle = Espresso.onView(ViewMatchers.withText("Add Transaction"))

    val transactionTitleInput = Espresso.onView(ViewMatchers.withId(R.id.et_title))

    val transactionAmountnput = Espresso.onView(ViewMatchers.withId(R.id.et_amount))

    val transactionTypeDropdown = Espresso.onView(ViewMatchers.withId(R.id.et_transactionType))

    val transactionTagDropdown = Espresso.onView(ViewMatchers.withId(R.id.et_tag))

    val transactionDateInput = Espresso.onView(ViewMatchers.withId(R.id.et_when))

    val calendarOkButton = Espresso.onView(ViewMatchers.withText("OK"))

    val transactionNoteInput = Espresso.onView(ViewMatchers.withId(R.id.et_note))

    val saveTransactionButton = Espresso.onView(ViewMatchers.withId(R.id.btn_save_transaction))

    // Helper functions
    fun doTypeTransactionTitle(title: String) {
        transactionTitleInput.perform(ViewActions.click())
        transactionTitleInput.perform(ViewActions.typeText(title))
    }

    fun doTypeTransactionAmount(amount: String) {
        transactionAmountnput.perform(ViewActions.click())
        transactionAmountnput.perform(ViewActions.typeText(amount))
    }

    fun doSelectTransactionType(type: String) {
        transactionTypeDropdown.perform(ViewActions.click())
        val trType = Espresso.onView(ViewMatchers.withId(R.id.dropdown_option))
        trType.perform(ViewActions.click())
    }

    fun doSelectTransactionTag(tag: String) {
        transactionTagDropdown.perform(ViewActions.click())
        val trTag = Espresso.onView(ViewMatchers.withId(R.id.dropdown_option))
        trTag.perform(ViewActions.click())
    }

    fun doSelectTransactionDate(date: String) {
        transactionDateInput.perform(ViewActions.typeText(date))
        calendarOkButton.perform(ViewActions.click())
    }

    fun doTypeTransactionNote() {
        transactionNoteInput.perform(ViewActions.typeText("Automated Test Note"))
    }
}
