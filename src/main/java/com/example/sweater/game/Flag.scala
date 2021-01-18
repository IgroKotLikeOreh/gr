package com.example.sweater.game

case class Flag(name: String) {
  var notwin = false
  var gamer: Gamer = null

  def getName() = name
  def nonGamer() = gamer == null
}
