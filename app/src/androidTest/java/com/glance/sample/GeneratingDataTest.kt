/*
 * Copyright (C)  guolin, Glance Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.glance.sample

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.glance.guolindev.sample.model.Magazine
import com.glance.guolindev.sample.model.Reader
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/**
 * Test for generating testing data.
 *
 * @author guolin
 * @since 2020/9/23
 */
@RunWith(AndroidJUnit4::class)
class GeneratingDataTest {

    @Test
    fun saveRecords() {
        val reader1 = Reader("reader1", 10)
        val reader2 = Reader("reader2", 20)
        repeat(150) {
            val magazine = Magazine("magazine${it}".repeat((1..50).random()),
                (1..100).random().toDouble(),
                Date(),
                (1..10).random().toFloat(),
                (100..1000).random(),
                Random().nextBoolean(),
                ByteArray(10))
            reader1.magazines.add(magazine)
            magazine.saveThrows()
        }
        repeat(80) {
            val magazine = Magazine("magazine${it + 150}".repeat((1..50).random()),
                (1..100).random().toDouble(),
                Date(),
                (1..10).random().toFloat(),
                (100..1000).random(),
                Random().nextBoolean(),
                ByteArray(10))
            reader2.magazines.add(magazine)
            magazine.saveThrows()
        }
        reader1.saveThrows()
        reader2.saveThrows()
    }

}