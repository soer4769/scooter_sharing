package dk.itu.moapd.scootersharing.skas

import android.content.Context
import java.util.Random
import kotlin.collections.ArrayList

class RidesDB (context: Context) {
    private val rides = ArrayList<Scooter>()
    companion object: RidesDBHolder<RidesDB,Context>(::RidesDB)

    init {
        rides.addAll(0, listOf(
            Scooter(" CPH001 ", " ITU ", randomDate()),
            Scooter(" CPH002 ", " Fields ", randomDate()),
            Scooter(" CPH003 ", " Lufthavn ", randomDate())
        ))
    }

    fun getRidesList(): ArrayList<Scooter> {
        return rides
    }

    fun addScooter(scooter: Scooter) {
        rides.add(scooter)
    }

    fun removeScooter(index: Int) {
        rides.removeAt(index)
    }

    fun updateCurrentScooter(scooter: Scooter) {
        rides.last().location = scooter.location
        rides.last().timestamp = scooter.timestamp
    }

    fun getCurrentScooter(): Scooter {
        return rides.last()
    }

    fun getCurrentScooterInfo(): String {
        return rides.last().toString()
    }

    /**
     * Generate a random timestamp in the last 365 days.
     *
     * @return A random timestamp in the last year.
     */
    private fun randomDate(): Long {
        val random = Random()
        val now = System.currentTimeMillis()
        val year = random.nextDouble() * 1000 * 60 * 60 * 24 * 365
        return (now - year).toLong()
    }
}

open class RidesDBHolder<out T: Any, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T) ? = creator
    @Volatile private var instance: T? = null

    fun get (arg: A): T {
        val checkInstance = instance
        if (checkInstance != null)
            return checkInstance

        return synchronized (this) {
            val checkInstanceAgain = instance
            if (checkInstanceAgain != null)
                checkInstanceAgain
            else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}