package com.example.domain

import org.junit.Assert.assertEquals
import org.junit.Test

class ExpressionTest {
    private var expression = Expression()

    @Test
    fun `Expression {피연산자, 연산자} 에서 피연산자가 들어올 경우`() {
        // given
        expression = expression.plus(3)
        expression = expression.plus(Operator.PLUS)

        // when
        expression = expression.plus(3)

        // then
        assertEquals("3 + 3", expression.value())
    }

    @Test
    fun `Expression {피연산자} 에서 피연산자가 들어올 경우`() {
        // given
        expression = expression.plus(3)

        // when
        expression = expression.plus(3)

        // then
        assertEquals("33", expression.value())
    }

    @Test
    fun `Expression {연산자} 에서 피연산자가 들어올 경우 연산자 무시되고 피연산자로 덮어 쓰인다`() {
        // given
        expression = expression.plus(Operator.PLUS)
        // when
        expression = expression.plus(1)

        // then
        assertEquals("1", expression.value())
    }

    @Test
    fun `Expression {피연산자, 연산자} 에서 연산자가 들어올 경우 마지막에 들어온 연산자로 덮어 쓰인다`() {
        // given
        expression = expression.plus(3)
        expression = expression.plus(Operator.PLUS)
        // when
        expression = expression.plus(Operator.MULTI)

        // then
        assertEquals("3 *", expression.value())
    }

    @Test
    fun `Expression {연산자} 에서 연산자가 들어올 경우`() {
        // given
        expression = expression.plus(Operator.PLUS)

        // when
        expression = expression.plus(Operator.MULTI)

        // then
        assertEquals("", expression.value())
    }

    @Test
    fun `Expression {피연산자} 에서 연산자가 들어올 경우`() {
        // given
        expression = expression.plus(3)

        // when
        expression = expression.plus(Operator.MULTI)

        // then
        assertEquals("3 *", expression.value())
    }
}