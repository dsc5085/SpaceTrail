package dc.spacetrail.gameplay

abstract class Situation() {
    abstract val description: String
    open val options = listOf<Option>()
}