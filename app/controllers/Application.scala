package controllers

import javax.inject.Inject

import models.ComputerRepository
import play.api.mvc._
import play.api.libs.json.Json


class Application @Inject()(computerRepository: ComputerRepository,
                            cc: ControllerComponents) extends AbstractController(cc) {

  def home = Action { implicit request =>
      val computers = computerRepository.list()
      Ok(Json.arr(computers))
  }

}