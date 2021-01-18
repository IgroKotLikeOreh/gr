package com.example.sweater.game

case class Personag(name: String = "", dom: String = "") {

  var lig = false
  var lig2 = false
  var lig3 = false
  var X = 0
  var Y = 0

  def setXY(x: Int, y: Int): Unit ={
    X = x
    Y = y
  }
  def getName() = name
  def isNameFile() = false

  def getX() = X
  def getY() = Y
  def getLig() = lig || lig3

}

