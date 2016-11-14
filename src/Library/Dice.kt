package library

import java.util.*

/**
 * Created by barakis on 10/3/16.
 */

open class Dice(private var side : Int) : IDie
{
    override val explode: Boolean
        get() = false

    override val size: Int
        get() = side

    override var totalRolled : Int = 0

    override fun RollDie()
    {
        val rnd = Random()

        totalRolled = rnd.nextInt(size) + 1
    }

    constructor(D : DiceTypesK) : this(D.value)
}