package ru.main;

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable;

class IncrementorTests {
    private lateinit var incrementor: Incrementor

    @BeforeEach
    fun configureSystemUnderTest() {
        incrementor = Incrementor()
    }

    @Test
    fun `number should be 0 at start`() {
        assertThat(incrementor.getNumber()).isEqualTo(0)
    }

    @Test
    fun `number after first increment should be equal to 1`() {
        incrementor.incrementNumber()

        assertThat(incrementor.getNumber()).isEqualTo(1)
    }

    @Test
    fun `number after twice increment should be equal to 2`() {
        incrementor.incrementNumber()
        incrementor.incrementNumber()

        assertThat(incrementor.getNumber()).isEqualTo(2)
    }

    @Test
    fun `error msg if maximum value less than 0`() {
        try {
            incrementor.setMaximumValue(-1)
        }
        catch (e: IllegalArgumentException) {
            assertThat(e.message).isEqualTo("Нельзя установить значение < 0")
        }
    }

    @Test
    fun `set number to 0 when number more than maximum value`() {
        incrementor.setMaximumValue(2)

        incrementor.incrementNumber()
        incrementor.incrementNumber()
        incrementor.incrementNumber()

        assertThat(incrementor.getNumber()).isEqualTo(0)
    }

    @Test
    fun `set number to 0 when maximum value less than number`() {
        incrementor.incrementNumber()
        incrementor.incrementNumber()

        incrementor.setMaximumValue(1)

        assertThat(incrementor.getNumber()).isEqualTo(0)
    }
}
