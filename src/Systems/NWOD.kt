package Systems

import library.Dice
import library.DiceTypesK
import library.IDie

/**
 * Created by barakis on 11/14/16.
 */
class NWOD(private val size : Int, private val exploded : Boolean = false, private val explodeTN : Int = 0) : IWhiteWolf
{
    override val type: DiceTypesK
        get() = DiceTypesK.D10

    override val targetNumber: Int
        get() = 8

    override var isExploding: Boolean = exploded

    override var explodingTargetNumber: Int = explodeTN

    override var totalSuccess : Int = 0

    val Size : Int = size

    var onesRolled : Int = 0

    var isFail : Boolean = false

    private val Dice : Array<IDie> = Array<IDie>(Size,{Dice(DiceTypesK.D10)})

    fun RollDice()
    {

    }

}