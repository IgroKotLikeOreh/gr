package com.example.sweater.game

import java.util

import freemarker.ext.beans.SimpleMapModel
import freemarker.template.DefaultObjectWrapper

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

case class Gamer(number: Int) {
  var name = "Игрок" + number
  var pers: ListBuffer[ListBuffer[Personag]] = ListBuffer(ListBuffer())
  var persDom: ListBuffer[String] = ListBuffer()
  var domdopSize: ListBuffer[(String, Int)] = ListBuffer()
  var domWin: mutable.Map[String, Boolean] = mutable.HashMap()

  def perLig2(personag: Personag) = {
    if(pers(0).size == 0) {
      persDom += personag.dom
      domdopSize += ((personag.dom, 0))
      pers(0) += personag
      domWin += ((personag.dom, false))
    } else {
      var oldDom = false
      for(per <- pers){
        if(per(0).dom == personag.dom){
          per += personag
          oldDom = true
        }
      }
      if(!oldDom){
        persDom += personag.dom
        domdopSize += ((personag.dom, 0))
        pers += ListBuffer(personag)
        domWin += ((personag.dom, false))
      }
    }
  }



  def getPers() = pers.map(_.toArray).toArray
  def getName() = name
  def getDomWin() = domWin
  def kk() = new SimpleMapModel(domWin.asJava, new DefaultObjectWrapper())


}
