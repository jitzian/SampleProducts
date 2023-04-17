package com.example.checkingproducts.ui.common

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import com.example.checkingproducts.BaseTestCase
import com.example.checkingproducts.ui.theme.CheckingProductsTheme
import org.junit.Before
import org.junit.Test

class ArrowBackIconKtTest : BaseTestCase() {

    @Before
    fun setUp() {
        composeTestRule.setContent {    // setting our composable as content for test
            CheckingProductsTheme {
                ArrowBackIcon(onBackClick = {})
            }
        }
    }

    @Test
    fun verify_initial_state() {
        composeTestRule.onNodeWithTag("arrowBackIcon_iconButton_test_TAG").assertIsDisplayed()
    }

}