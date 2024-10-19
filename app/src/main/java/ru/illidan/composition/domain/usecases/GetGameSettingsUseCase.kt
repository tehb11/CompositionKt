package ru.illidan.composition.domain.usecases

import ru.illidan.composition.domain.entity.GameSettings
import ru.illidan.composition.domain.entity.Level
import ru.illidan.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
)
{
    operator fun invoke (
        level: Level
    ): GameSettings {
        return repository.getGameSettings(level)
    }
}