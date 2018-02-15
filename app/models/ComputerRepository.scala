package models

import java.util.Date
import javax.inject.{Inject, Singleton}

import anorm.SqlParser._
import anorm._
import play.api.db.DBApi
import play.api.libs.json.{JsValue, Json, Writes}

import scala.concurrent.Future


case class Computer(id: Option[Long] = None,
                    name: String,
                    introduced: Option[Date],
                    discontinued: Option[Date],
                    companyId: Option[Long])





object Computer {
  implicit val computerWrites = new Writes[Computer] {
    def writes(computer: Computer) = Json.obj(
      "id" -> computer.id,
      "name" -> computer.name,
      "introduced" -> computer.introduced,
      "discontinued" -> computer.discontinued,
      "companyId" -> computer.companyId
    )
  }
}


@Singleton
class ComputerRepository @Inject()(dBApi: DBApi) {


  private val db = dBApi.database("default")

  val parser1: RowParser[Computer] = Macro.indexedParser[Computer]


  def list() : List[Computer] =  {
    db.withConnection { implicit connection =>
      val computers = SQL("Select * from Computer").as(parser1.*);
      computers
    }

  }

}
