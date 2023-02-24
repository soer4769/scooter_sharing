/*
 * MIT License
 *
 * Copyright (c) [year] [fullname]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dk.itu.moapd.scootersharing.skas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.android.material.snackbar.Snackbar
import dk.itu.moapd.scootersharing.skas.databinding.ActivityMainBinding

/**
 * The main class for a app object
 *
 * @author søren kastrup (skas@itu.dk)
 * @constructor Creates a new activity object
 */
class UpdateRideActivity : AppCompatActivity() {
    // A set of private constants used in this class.
    companion object {
        private val TAG = UpdateRideActivity::class.qualifiedName
    }

    // GUI variables.
    private val scooter : Scooter = Scooter (" " ," ", 0)

    /**
     * Called when a new UpdateRideActivity object is created
     * @return none
     * */
    override fun onCreate (savedInstanceState : Bundle ?) {
        WindowCompat.setDecorFitsSystemWindows(window,false)
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // When the ride button is pressed
        binding.startRideButton.setOnClickListener {
            if (binding.editTextName.text.isNotEmpty() && binding.editTextLocation.text.isNotEmpty()){
                // Update the object attributes.
                scooter.name = binding.editTextName.text.toString().trim()
                scooter.location = binding.editTextLocation.text.toString().trim()
                scooter.timestamp = System.currentTimeMillis()

                // Reset the text fields and update the UI.
                binding.editTextName.text.clear()
                binding.editTextLocation.text.clear()

                // Shows a snackbar message on the screen
                Snackbar.make(binding.root, "Ride started using Scooter(name=${scooter.name}, location=${scooter.location})", Snackbar.LENGTH_LONG).show();
            }
        }
    }
}