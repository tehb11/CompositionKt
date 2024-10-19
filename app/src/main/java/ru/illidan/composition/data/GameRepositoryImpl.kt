package ru.illidan.composition.data

import ru.illidan.composition.domain.entity.GameSettings
import ru.illidan.composition.domain.entity.Level
import ru.illidan.composition.domain.entity.Question
import ru.illidan.composition.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class GameRepositoryImpl: GameRepository {

    private val MIN_SUM_VALUE = 2
    private val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE,maxSumValue+1) // генерируем максимальное число
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum) // видимое число
        val options = HashSet<Int>() // чтобы небыло одинаковых вариантов ответов используем HashSet (то же самое что Set - JS)
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE) // от какого числа будем подбирать варианты
        val to = min(maxSumValue - 1, rightAnswer + countOfOptions)
        while(options.size < countOfOptions){
            options.add(Random.nextInt(from,to))
        }
         return Question(sum, visibleNumber, options.toList()) // options.toList() - чтоб привести к нужному типу
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> {
                GameSettings(10,3,50,8)
            }
            Level.EASY -> {
                GameSettings(10,10,70,60)
            }
            Level.NORAML -> {
                GameSettings(20,20,80,40)
            }
            Level.HARD -> {
                GameSettings(30,30,90,40)
            }
        }
    }


}