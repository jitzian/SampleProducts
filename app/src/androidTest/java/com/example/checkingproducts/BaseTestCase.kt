package com.example.checkingproducts

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)  // To indicate that we've to run it with AndroidJUnit runner
open class BaseTestCase {

    @get: Rule// compose rule is required to get access to the composable component
    val composeTestRule = createComposeRule()

}