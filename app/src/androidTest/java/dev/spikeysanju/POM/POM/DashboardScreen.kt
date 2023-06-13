package dev.spikeysanju.POM.POM

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import dev.spikeysanju.expensetracker.R


class DashboardScreen {
    // Screen Elements
    val dashboardTitleFilterOverall = onView(withText("Overall"))

    val dashboardTitleFilterIncome = onView(withText("All Income"))

    val dashboardTitleFilterExpense = onView(withText("All Expense"))

    val addTransactionButton = onView(withId(R.id.btn_add_transaction))

    val noTransactionsText = onView(withId(R.id.empty_state_title))

    val totalBalanceView = onView(withId(R.id.total_balance_view))

    val totalBalanceTitle = onView(withId(R.id.total_balance_title))

    val totalBalanceAmount = onView(withId(R.id.total_balance))

    val transactionCard = onView(withId(R.id.transactionCardView))



    // Helper functions
    fun doAddTransaction() {
        addTransactionButton.perform(ViewActions.click())
    }
}
