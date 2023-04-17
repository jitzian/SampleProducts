package com.example.checkingproducts.ui.screens.main.viewmodel

import com.example.checkingproducts.MainCoroutineRule
import com.example.checkingproducts.data.domain.repository.product.ProductRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val repository = mock<ProductRepository>()
    private lateinit var subject: MainViewModel

    @Before
    fun setup() {
        subject = MainViewModel(repository)
    }

    @Test
    fun `loading state works`() {
        runBlockingTest {
            whenever(repository.getProducts()).thenReturn(emptyList())
            assertTrue(subject.state.value.isLoading)
            assertTrue(subject.state.value.data.isEmpty())
        }
    }

}