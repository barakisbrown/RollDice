package Systems

import library.Dice
import library.DiceTypesK

/**
 * Rules:
 *    1. roll about 8 = +1 success and roll = 10 +1 success plus re-roll unless Second Chance is active
 *    2. Second Chance : Dice Pool has to be 0. 10 is the only success and dramatic fail is when 1 is rolled
 *                       Only time that rolling a 1 is BAD
 *    3. NWOD all dice can explode if they roll a 10 but certain situation(weapons) can cause the TN to drop to a 9
 */
class NWOD(private val size : Int, private val explodeTN : Int = 0) : IWhiteWolf
{
    override val type: DiceTypesK
        get() = DiceTypesK.D10

    override val targetNumber: Int
        get() = 8

    override var isExploding: Boolean = true

    override var explodingTargetNumber: Int = explodeTN

    override var totalSuccess : Int = 0

    val Size : Int = size

    var isFail : Boolean = false

    var dramaticFail : Boolean = false

    private var Dice : MutableList<Dice> = mutableListOf(Dice(type))

    val dicePool : List<Dice> = Dice.toList()

    init
    {
        val D : Dice = Dice(type)
        when
        {
            size == 0 ->
            {
                Dice.add(D)
            }
            else ->
            {
                (0..Size-1).forEach { i ->
                    Dice.add(D)
                }
            }

        }
    }

    fun RollDice()
    {
        // 2nd Chance Rule
        // NORMAL NWOD RULES BELOW
        when (size) {
            0 -> {
                var D: Dice = Dice(type)
                D.RollDie()
                when {
                    D.totalRolled == 1 -> dramaticFail = true
                    D.totalRolled == 10 -> {
                        do {
                            totalSuccess++
                            D.RollDie()
                        } while (D.totalRolled == 10)
                    }
                }
            }
            else -> Dice.forEach()
            {
                totalSuccess += RollDiceExplode(it)
            }
        }
        if (totalSuccess == 0) isFail = true else isFail = false
    }


    private fun RollDiceExplode(D : Dice) : Int
    {
        D.RollDie()
        var rolled = D.totalRolled
        var results = 0

        when(rolled)
        {
            8 -> results++
            explodingTargetNumber -> {
                results++
                results += RollDiceExplode(D)
            }
            10 -> {
                results++
                results += RollDiceExplode(D)
            }
            else -> return 0
        }

        return results
    }

}