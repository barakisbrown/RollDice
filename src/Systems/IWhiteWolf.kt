package Systems

import library.DiceTypesK

/**
 * Created by barakis on 11/14/16.
 */
interface IWhiteWolf
{
    val type: DiceTypesK
    val targetNumber : Int
    var isExploding : Boolean
    var explodingTargetNumber : Int
    var totalSuccess : Int

}