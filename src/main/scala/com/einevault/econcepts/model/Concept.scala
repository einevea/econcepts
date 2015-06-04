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

import java.util.{Locale, UUID}
import com.einevault.econcepts.domain.{Concept => ConceptI, Description => DescriptionI, Label => LabelI, Media}
import spray.http.MediaType
import spray.json.DefaultJsonProtocol

/**
 * Created by einevea on 02/06/15.
 */
case class Concept(uUID: UUID) extends ConceptI{
  override def description(locale: Locale): Option[Description] =  MemDB.description(uUID, locale)

  override def mainLabel(locale: Locale): Option[Label] = MemDB.mainLabel(uUID, locale)

  override def mainMedia(locale: Locale): Option[Media] = MemDB.mainMedia(uUID, locale)

  override def mainMedia(locale: Locale, mediaType: MediaType): Option[Media] = MemDB.mainMedia(uUID, locale, mediaType)

  override def medias(locale: Locale): List[Media] = MemDB.medias(uUID, locale)

  override def medias(locale: Locale, mediaType: MediaType): List[Media] = MemDB.medias(uUID, locale, mediaType)

  override def labels(locale: Locale): List[Label] = MemDB.labels(uUID, locale)

  override def hRef: String = "/concepts/"+uUID
}

object Concept{

//     def apply(uUIDStr: String): Concept =  {
//       Concept(UUID.fromString(uUIDStr))
//     }
}


