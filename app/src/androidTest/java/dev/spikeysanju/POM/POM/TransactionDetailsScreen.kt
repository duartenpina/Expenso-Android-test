package dev.spikeysanju.POM.POM

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import dev.spikeysanju.expensetracker.R


class TransactionDetailsScreen {
    // Screen Elements
    private val deleteButton = onView(withId(R.id.action_delete))

    // Helper Functions
    fun doDeleteTransaction() {
        deleteButton.perform(click())
    }
}
