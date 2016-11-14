package library

import java.util.*

/**
 * Created by barakis on 10/3/16.
 */
class Exploded(private val D : Int) : IDie
{
    override val explode: Boolean
        get() = true

    override val size: Int
        get() = D

    override var totalRolled: Int = 0

    override fun RollDie()
    {
        val rnd = Random()

        var roll : Int

        do
        {
            roll = rnd.nextInt(size) + 1
            totalRolled += roll

        }while(roll == size)
    }


    constructor(D : DiceTypesK) : this(D.value)
}