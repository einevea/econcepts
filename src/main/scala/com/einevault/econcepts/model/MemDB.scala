/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Einevea
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

package com.einevault.econcepts.model

import java.util
import java.util.{Locale, UUID}

import com.einevault.econcepts.domain.Media
import spray.http.MediaType

/**
 * Temporal memory database for testing, using mutable structures for simplicity
 * Created by einevea on 02/06/15.
 */
object MemDB {


  val concepts : util.HashMap[UUID, Concept] = new util.HashMap()
  val labels : util.HashMap[UUID, Label] = new util.HashMap()
  val cIDToLabelsID : util.HashMap[UUID, List[UUID]]  = new util.HashMap()
  val descriptions : util.HashMap[UUID, Description]  = new util.HashMap()

  def description(uUID: UUID, locale: Locale): Option[Description] = ???
  def descriptions(uUID: UUID, locale: Locale): List[Description] = ???
  def mainMedia(uUID: UUID, locale: Locale): Option[Media] = ???
  def medias(uUID: UUID, locale: Locale): List[Media] = ???
  def mainMedia(uUID: UUID, locale: Locale, mediaType: MediaType): Option[Media] = ???
  def medias(uUID: UUID, locale: Locale, mediaType: MediaType): List[Media] = ???
  def mainLabel(uUID: UUID, locale: Locale): Option[Label] = ???
  def labels(uUID: UUID, locale: Locale): List[Label] = ???
}
