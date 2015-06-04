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

package com.einevault.econcepts

import com.einevault.econcepts.model.Concept
import org.specs2.mutable.Specification
import spray.http.StatusCodes._
import spray.http._
import spray.httpx.SprayJsonSupport
import spray.testkit.Specs2RouteTest
import com.einevault.econcepts.model.EConceptsJsonProtocol._
import spray.httpx.SprayJsonSupport._

class EConceptServiceSpec extends Specification with Specs2RouteTest with EConceptService with SprayJsonSupport {
  def actorRefFactory = system

  "EConceptService" should {

    "return a concept for GET requests to the concepts root path" in {
      Get("/concepts") ~> econceptsRoute ~> check {
        status == OK
        val concept: Concept = responseAs[Concept]
        concept.uUID must not beNull
      }
    }


    "leave GET requests to other paths unhandled" in {
      Get("/jibberjabber") ~> econceptsRoute ~> check {
        handled must beFalse
      }
    }

    "return a new concept for GET requests to the root path" in {
      Put("/concepts") ~> econceptsRoute ~> check {
        responseAs[String] must contain("get a new concept")
      }
    }

    // GET concepts ?tag='x' && lang=lang obtain list of concepts with that tag in that lang
    // GET concepts ?tag='x' && langs=lang1,lang2 obtain list of concepts with that tag in that languages

    // GET concepts/x/descriptions get all descriptions for concept
    // GET concepts/x/tags get all tags for concept
    // GET concepts/x/images  get all images for concept

    // Should implement tag and lang as filters for the responses and make test for it, they could be applied to any of the above




      //    "return a MethodNotAllowed error for PUT requests to the root path" in {
//      Put() ~> sealRoute(econceptRoute) ~> check {
//        status === MethodNotAllowed
//        responseAs[String] === "HTTP method not allowed, supported methods: GET"
//      }
//    }
  }
}