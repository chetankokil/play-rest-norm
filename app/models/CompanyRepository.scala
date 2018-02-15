package models

import javax.inject.{Inject, Singleton}

import play.api.db.DBApi


case class Company(id :Option[Long] = None, name: String)

@Singleton
class CompanyRepository @Inject()(dbCpi: DBApi) {

  private val db = dbCpi.database("default")



}
