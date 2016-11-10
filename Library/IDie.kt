package library

/**
 * Created by barakis on 11/10/16.
 */

interface IDie
{
    abstract val explode : Boolean
    abstract val size : Int
    abstract var totalRolled : Int
    abstract fun RollDie()
}