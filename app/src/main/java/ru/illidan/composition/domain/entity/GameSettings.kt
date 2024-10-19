package ru.illidan.composition.domain.entity

data class GameSettings (
    val maxSumValue: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswers: Int, // процент правильных ответов для победы
    val gameTimeInSeconds: Int
)