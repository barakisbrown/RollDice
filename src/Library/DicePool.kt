package library

import java.lang.Math.abs


/**
 * Created by barakis on 11/10/16.
 */

class DicePool(private val numDice : Int, private val type : Int,private val modifier : Int = 0, private val exploded : Boolean = false)
{
    var averageRolled : Int = 0
        get() = (totalRolled / numDice)

    var totalRolled : Int = 0;

    val isExplode : Boolean
        get() = exploded

    lateinit var diePool: Array<IDie>

    init {
        if (exploded)
        {
            diePool = Array<IDie>(numDice, {Exploded(type)})
        }
        else
        {
            diePool = Array<IDie>(numDice, {Dice(type)})
        }
    }

    constructor(dNum : Int, dType : DiceTypesK,dMod : Int, dExplode : Boolean ) : this(dNum,dType.value,dMod,dExplode)

    fun RollDice()
    {
        for (i in 0.. numDice - 1)
        {
            diePool[i].RollDie()
            totalRolled += diePool[i].totalRolled
        }

        totalRolled += modifier
    }

    fun getDiceString() : String
    {
        var str : String = "${numDice}D${type}"
        if (modifier < 0)
            str += " - ${abs(modifier)}"
        else
            str += " + ${modifier}"

        return str
    }
}