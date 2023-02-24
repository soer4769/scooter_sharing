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

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import dk.itu.moapd.scootersharing.skas.databinding.ActivityMainBinding

/**
 * The main class for a app object
 *
 * @author søren kastrup (skas@itu.dk)
 * @constructor Creates a new activity object
 */
class MainActivity : AppCompatActivity() {
    // A set of private constants used in this class.
    companion object {
        private lateinit var adapter: ListRidesAdapter
        lateinit var ridesDB: RidesDB
    }

    /**
     * Called when a new MainActivity object is created
     * @return none
     */
    override fun onCreate (savedInstanceState : Bundle ?) {
        WindowCompat.setDecorFitsSystemWindows(window,false)
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ridesDB = RidesDB.get(this)

        binding.startRideButton.setOnClickListener {
            val intent = Intent(baseContext, StartRideActivity::class.java)
            startActivity(intent)
        }

        binding.updateRideButton.setOnClickListener {
            val intent = Intent(baseContext, UpdateRideActivity::class.java)
            startActivity(intent)
        }

        binding.listRidesButton.setOnClickListener {
            adapter = ListRidesAdapter(this,R.layout.list_rides, ridesDB.getRidesList())
            binding.listRidesView.adapter = adapter
        }
    }
}