package ru.main;

/**
 * Класс реализует интерфейс Incrementor
 *
 * @author Igor Enikeev
 * @version 1.0
 */
class Incrementor {
    /**
     * @var Int Число, над которым будут производиться все вычисления в классе
     */
    private var number: Int = 0

    /**
     * @var Int Максимально допустимое значение для параметра {@link Incrementor#number}
     *          По умолчанию {@value Int#MAX_VALUE}
     */
    private var maximumNumber: Int = Int.MAX_VALUE

    /**
     * @var Boolean Достигло ли значение свойства {@link Incrementor#number}
     *              максимально допустимого значения {@link Incrementor#maximumNumber}
     */
    private val isMaxNumberReached: Boolean
        get() = number.equals(maximumNumber)

    /**
     * Возвращает текущее число {@link Increment#number}
     *
     * @return Int
     */
    fun getNumber(): Int = number

    /**
     * Увеличивает текущее число {@link Increment#number} на 1
     *
     * Если значение числа {@link Increment#number} достигло максимально возможного значения,
     * указанного в {@link Increment#maximumNumber}, тогда число {@link Increment#number} обнуляется
     */
    fun incrementNumber() {
        if (isMaxNumberReached) {
            resetNumber()
        } else {
            number += 1
        }
    }

    /**
     * Устанавливает максимально допустимое значение {@link Increment#maximumNumber},
     * которое может принимать число {@link Increment#number}
     *
     * Если текущее число {@link Increment#number} больше нового {@link Increment#maximumNumber},
     * тогда обнуляем число {@link Increment#number}
     *
     * @param maximumValue Int Число > 0
     */
    fun setMaximumValue(maximumValue: Int) {
        if (maximumValue < 0) {
            throw IllegalArgumentException("Нельзя установить значение < 0")
        }

        maximumNumber = maximumValue
        if (maximumNumber < number) {
            resetNumber()
        }
    }

    /**
     * Сбрасывает значение числа {@link Increment#number} на дефолтное
     */
    private fun resetNumber() {
        number = 0
    }
}
