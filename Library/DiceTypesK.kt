package library

/**
 * Created by barakis on 9/14/16.
 */
enum class DiceTypesK constructor(val value : Int)
{
    D3(3),
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20),
    D100(100);

    companion object {
        fun isAllowed(dice: Int) : Boolean {
            val allowed = arrayOf(3,4,6,8,10,12,20,100)

            for (x in allowed)
            {
                if (dice == x) return true
            }

            return false
        }
    }
}