package com.example.sweater.controller

import java.awt.image.BufferedImage

import com.example.sweater.game.{Flag, Gamer, Personag, PersonagDop}
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{GetMapping, PostMapping, RequestParam}

import scala.collection.convert.ImplicitConversions.`map AsJavaMap`
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks

@Controller
class GameS() {

  @GetMapping(value = Array("/game"))
  def game(model: Model): String = {

    "game"
  }


}