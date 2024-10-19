package ru.illidan.composition.domain.entity

data class GameResult  (
    val winner: Boolean,
    val countOfRightAnswers: Int, // сколько правильных ответов
    val countOfQuestion: Int, // на сколько ответил вопросов
    val gameSettings: GameSettings
)