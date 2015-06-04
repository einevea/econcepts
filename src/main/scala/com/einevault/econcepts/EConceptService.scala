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

import java.util.UUID

import akka.actor.Actor
import akka.util.Timeout
import com.einevault.econcepts.model.Concept
import spray.routing._
import spray.http._
import MediaTypes._
import spray.httpx.SprayJsonSupport._
import com.einevault.econcepts.model.EConceptsJsonProtocol._

import scala.concurrent.duration._

class EConceptActor extends Actor with EConceptService {

  def actorRefFactory = context
  def receive = runRoute(econceptsRoute ~ descriptionsRoute)
}

trait BasicService extends HttpService {
  implicit val timeout = Timeout(20.seconds)
}

trait EConceptService extends BasicService {

  val econceptsRoute =
    path("concepts") {
      get {
        respondWithMediaType(`application/json`) {
          complete {
            Concept(UUID.randomUUID())
          }
        }
      } ~ put {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                <h1>get a new concept</h1>
              </body>
            </html>
          }
        }
      }
    }

  val descriptionsRoute =
   path("descriptions"){
    get {
      respondWithMediaType(`text/html`) {
        complete {
          <html>
            <body>
              <h1>get description</h1>
            </body>
          </html>
        }
      }
    }
  }
}
