package com.example.sweater.game

import java.awt.{Image, Point}

import scala.collection.mutable.ListBuffer

case class PersonagDop(name: String, fileName: String) {
  var personagForRamsi = new Point(-1,-1)
  var actionLeftForYaken = 2

  def getName() = name

  def moreActions(matrixPersonag: Array[Array[Personag]], gamers: Seq[Gamer], presentGamer: Gamer = null, persX: Int = 0, persY: Int = 0, dom: String = "", personagName: String = "", dopPersonagsNowGame: ListBuffer[PersonagDop]): (String, Boolean) ={
    name match {
      case "Сандор Клиган" => {
        matrixPersonag(persX)(persY) = Personag()
        matrixPersonag.foreach(_.foreach(_.lig3 = false))
        ("", false)
      }
      case "Джон Сноу" => {
        if(presentGamer.persDom.contains(dom))
          for(i <- 0 until presentGamer.domdopSize.size) {
            val u = presentGamer.domdopSize(i)
            if(u._1 == dom) presentGamer.domdopSize(i) = (dom, u._2 + 2)
          }
        else {
          presentGamer.domdopSize += ((dom, 2))
        }
        (dom, false)
      }
      case "Рамси Сноу" => {
        if (personagForRamsi == new Point(-1, -1)) {
          personagForRamsi = new Point(persX, persY)
          ("", true)
        }
        else{
          val a = matrixPersonag(persX)(persY)
          matrixPersonag(persX)(persY) = matrixPersonag(personagForRamsi.x)(personagForRamsi.y)
          matrixPersonag(personagForRamsi.x)(personagForRamsi.y) = a
          matrixPersonag.foreach(_.foreach(_.lig3 = false))
          ("", false)
        }
      }
      case "Якен Хгар" => {
        if(actionLeftForYaken == 2) {
          matrixPersonag(persX)(persY) = Personag()
          matrixPersonag.foreach(_.foreach(_.lig3 = false))
          gamers.foreach(_.pers.foreach(_.foreach(_.lig3 = true)))
          actionLeftForYaken = 1
          ("", true)
        }
        else if(actionLeftForYaken == 1){
          var domNew = ""
          gamers.foreach { gamer =>
            for (i <- 0 until gamer.pers.size; j <- 0 until gamer.pers(i).size) {
              gamer.pers(i)
              if (gamer.pers(i)(j).name == personagName) {
                val per = gamer.pers(i)(j)
                domNew = per.dom
                gamer.pers(i) -= per
              }
            }
          }
          gamers.foreach(_.pers.foreach(_.foreach(_.lig3 = false)))
          actionLeftForYaken = 0
          (domNew, true)
        }
        else{
          dopPersonagsNowGame -= dopPersonagsNowGame.find(_.name == personagName).get
          ("", false)
        }
      }
      case "Лорас Тирел" => {
        var domNew = ""
        if(personagName == "") {
            val per = matrixPersonag(persX)(persY)
            domNew = per.dom
            presentGamer.perLig2(per)
            matrixPersonag(persX)(persY) = Personag()
        }
        else {
          gamers.map { gamer =>
            for (i <- 0 until gamer.pers.size; j <- 0 until gamer.pers(i).size) {
              gamer.pers(i)
              if (gamer.pers(i)(j).name == personagName) {
                val per = gamer.pers(i)(j)
                domNew = per.dom
                presentGamer.perLig2(per)
                gamer.pers(i) -= per
              }
            }
          }
        }
        (domNew, false)
      }
    }
  }
  def actions(matrixPersonag: Array[Array[Personag]], gamers: Seq[Gamer], presentGamer: Gamer = null, dopUse: Boolean = false): (String, Boolean) = {
    def light(namePer: String, drawt: Boolean = true, dopUse: Boolean = true) : (String, Boolean) =   {
      var karta = true
      for(i <- 0 until matrixPersonag.size; j <- 0 until matrixPersonag(i).size ){
        if(matrixPersonag(i)(j).name == namePer){
          val per = matrixPersonag(i)(j)
          if(dopUse){
            if(drawt)
              presentGamer.perLig2(per)
            matrixPersonag(i)(j) = Personag()
          }
          else
            per.lig3 = true
          karta = false
        }
      }
      if(karta) {
        gamers.foreach{gamer =>
          for(i <- 0 until gamer.pers.size; j <- 0 until gamer.pers(i).size ){
            if(gamer.pers(i).size > 0 && gamer.pers(i).apply(j).name == namePer){
              val per = gamer.pers(i)(j)
              if(dopUse){
                if(drawt)
                  presentGamer.perLig2(per)
                gamer.pers(i) -= per
              }
              else
                per.lig3 = true
            }
          }
        }
      }
      (namePer.split(" ").last, false)
    }
    name match {
      case "Бриенна Тарг" => {
        light("Санса Старк")
        light("Арья Старк")
      }
      case "Ходор" => light("Бран Старк")
      case "Шая" => {
        val karta = matrixPersonag.find(_.find(_.name == "Тирион Ланистер").map(_.lig3 = true).isDefined)
        karta.getOrElse(gamers.foreach(_.pers.find(_.find(_.name == "Тирион Ланистер").map(_.lig3 = true).isDefined)))
        if(dopUse){
          val k = presentGamer.pers.find(_.find(_.name == "Тирион Ланистер").isDefined)
          if(k.isDefined) {
            for(i <- 0 until presentGamer.domdopSize.size) {
              val u = presentGamer.domdopSize(i)
              if(u._1 == "Ланистер") presentGamer.domdopSize(i) = ("Ланистер", u._2 + 2)
            }
          }
        }
        ("Ланистер", false)
      }
      case "Сандор Клиган" => matrixPersonag.foreach(_.foreach(per => if(!per.name.equals("Варис"))per.lig3 = true)); ("", true)
      case "Кхал Дрого" => {
        light("Дейенерис Таргариен")
        light("Визерис Таргариен", false)
      }
      case "Джон Сноу" => ("", true)
      case "Бронн" => light("Тирион Ланистер")
      case "Джендри" =>{
        if(dopUse){
          for(i <- 0 until presentGamer.domdopSize.size) {
            val u = presentGamer.domdopSize(i)
            if(u._1 == "Баратеон") presentGamer.domdopSize(i) = ("Баратеон", u._2 + 1)
          }
        }
        ("Баратеон", false)
      }
      case "Рамси Сноу" => matrixPersonag.foreach(_.foreach(_.lig3 = true)); ("", true)
      case "Петир Бейлиш" =>("", true)
      case "Якен Хгар" => matrixPersonag.foreach(_.foreach(per => if(!per.name.equals("Варис"))per.lig3 = true));("", true)
      case "Мелисандра" =>("", false)
      case "Илин Пейн" => light("Эддард Старк", false)
      case "Лорас Тирел" => {
        light("Ренли Баратеон", dopUse = false)
        light("Оленна Тирелл", dopUse = false)
        light("Гарлан Тирелл", dopUse = false)
        light("Маргери Тирелл", dopUse = false)
        ("", true)
      }
    }
  }
}