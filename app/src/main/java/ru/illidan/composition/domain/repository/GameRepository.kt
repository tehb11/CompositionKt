package ru.illidan.composition.domain.repository

import ru.illidan.composition.domain.entity.GameSettings
import ru.illidan.composition.domain.entity.Level
import ru.illidan.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}