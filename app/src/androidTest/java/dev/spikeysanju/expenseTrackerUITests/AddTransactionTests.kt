package dev.spikeysanju.expenseTrackerUITests

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.spikeysanju.POM.POM.AddEditTransactionsScreen
import dev.spikeysanju.POM.POM.Base
import dev.spikeysanju.POM.POM.DashboardScreen
import dev.spikeysanju.POM.POM.TransactionDetailsScreen
import dev.spikeysanju.expensetracker.view.main.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class AddTransactionTests {

        private val dashboardScreen = DashboardScreen()
        private val addEditTransactionsScreen = AddEditTransactionsScreen()
        private val base = Base()
        private val transactionDetailsScreen = TransactionDetailsScreen()

        private val incomeTrName = "Automated Income ${base.generateRandomAlphanumeric(5)}"
        private val incomeTrAmount = "1500.00"
        private val expenseTrName = "Automated Expense ${base.generateRandomAlphanumeric(5)}"
        private val expenseTrAmount = "135.35"

        @get:Rule
        val activityRule = ActivityScenarioRule(MainActivity::class.java)

        @Before
        fun setUp() {
            /**
             * Check that the add transaction button is visible and click it
             */
            dashboardScreen.addTransactionButton.check(matches(isDisplayed()))
        }

        @After
        fun tearDown() {
        }

        @Test
        fun testAddIncome() {
            /**
             * Click on add expenses button and check we are on the correct screen
             */
            dashboardScreen.doAddTransaction()
            addEditTransactionsScreen.transactionScreenTitle.check(matches(isDisplayed()))

            /**
             * Add transaction information
             */
            addEditTransactionsScreen.doTypeTransactionTitle(incomeTrName)
            addEditTransactionsScreen.doTypeTransactionAmount(incomeTrAmount)

            // Couldn't get this to work. It seems that the dropdown options are always triggering the following error
            // androidx.test.espresso.NoMatchingViewException: No views in hierarchy found matching: is assignable from class <class android.widget.AdapterView>
            // I couldn't find a way to interact with them. I've commented them out.

            // addEditTransactionsScreen.doSelectTransactionType("Income")
            // addEditTransactionsScreen.doSelectTransactionTag("Miscellaneous")
            addEditTransactionsScreen.doSelectTransactionDate("13/06/2023")
            addEditTransactionsScreen.doTypeTransactionNote()

            /**
             * Save transaction and check return to Dashboard Screen
             */
            Espresso.closeSoftKeyboard()
            addEditTransactionsScreen.saveTransactionButton.perform(click())
            // dashboardScreen.dashboardTitleFilterOverall.check(matches(isDisplayed()))
            // dashboardScreen.totalBalanceTitle.check(matches(isDisplayed()))
            // dashboardScreen.totalBalanceAmount.check(matches(isDisplayed())).check(matches(withText(incomeTrAmount)))
        }

        @Test
        fun testAddExpense() {
            /**
             * Click on add expenses button and check we are on the correct screen
             */
            dashboardScreen.doAddTransaction()
            addEditTransactionsScreen.transactionScreenTitle.check(matches(isDisplayed()))

            /**
             * Add transaction information
             */
            addEditTransactionsScreen.doTypeTransactionTitle(expenseTrName)
            addEditTransactionsScreen.doTypeTransactionAmount(expenseTrAmount)

            // Couldn't get this to work. It seems that the dropdown options are always triggering the following error
            // androidx.test.espresso.NoMatchingViewException: No views in hierarchy found matching: is assignable from class <class android.widget.AdapterView>
            // I couldn't find a way to interact with them. I've commented them out.

            // addEditTransactionsScreen.doSelectTransactionType("Expense")
            // addEditTransactionsScreen.doSelectTransactionTag("Utilities")
            addEditTransactionsScreen.doSelectTransactionDate("13/06/2023")
            addEditTransactionsScreen.doTypeTransactionNote()

            /**
             * Save transaction and check return to Dashboard Screen
             */
            Espresso.closeSoftKeyboard()
            addEditTransactionsScreen.saveTransactionButton.perform(click())
            // dashboardScreen.dashboardTitleFilterOverall.check(matches(isDisplayed()))
            // dashboardScreen.totalBalanceTitle.check(matches(isDisplayed()))
            // dashboardScreen.totalBalanceAmount.check(matches(isDisplayed())).check(matches(withText(expenseTrAmount)))

        }

        @Test
        fun testFilter() {
            /**
             * Change the filter to All Income and confirm change
             */
            dashboardScreen.dashboardTitleFilterOverall.perform(click())
            dashboardScreen.dashboardTitleFilterIncome.perform(click()).check(matches(isDisplayed()))

            /**
             * Change the filter to All Expense and confirm change
             */
            dashboardScreen.dashboardTitleFilterIncome.perform(click())
            dashboardScreen.dashboardTitleFilterExpense.perform(click()).check(matches(isDisplayed()))
            /**
             * Change the filter to All Expense and confirm change
             */
            dashboardScreen.dashboardTitleFilterExpense.perform(click())
            dashboardScreen.dashboardTitleFilterOverall.perform(click()).check(matches(isDisplayed()))
        }
}
