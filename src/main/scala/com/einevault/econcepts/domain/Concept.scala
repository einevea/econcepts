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

package com.einevault.econcepts.domain

import java.net.URI
import java.util.{UUID, Locale}

import spray.http.MediaType

trait Concept extends IsEntity{
  def description(locale: Locale) : Option[Description]

  def mainLabel(locale: Locale) : Option[Label]
  def mainMedia(locale: Locale) : Option[Media]
  def mainMedia(locale: Locale, mediaType: MediaType) : Option[Media]


  def labels(locale: Locale) : List[Label]
  def medias(locale: Locale) : List[Media]
  def medias(locale: Locale, mediaType: MediaType) : List[Media]
}

trait Description extends IsEntity with HasScore with HasLocation with HasAuthor{
  def name : String
}

trait Label extends IsEntity with HasScore with HasLocation with HasAuthor{
  def name : String 
}

trait Media extends IsEntity with HasScore with HasLocation with HasAuthor{
  def uri : URI
  def mediaType : MediaType
}


