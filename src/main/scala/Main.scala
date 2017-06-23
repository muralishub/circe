
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._

import scala.collection.immutable


object Main extends App{

  // simple string to json
  val user: String = """{"user":{"name": "mike"}}"""

  val userDeserialized: Json = user.asJson


  //scala value type
  val list = List(1, 2, 3)

  val serializedList1: Json = list.asJson

  val decodedSerializedList1 = decode[List[Article]](serializedList1.toString())



  //simple case class to json
  val article = Article("doi", "this is article title")

  val result = article.asJson


  //decode to case class
  val returnArticle: Either[Error, Article] = decode[Article](result.toString())



  val articleList: immutable.Seq[Article] = List(Article("doi1", "title1"), Article("doi2", "title2"))

  val serializedList: Json = articleList.asJson

  val decodedSerializedList: Either[Error, List[Article]] = decode[List[Article]](serializedList.toString())


}

sealed trait Content


case class Article(doi: String, title: String) extends Content
case class Chapter(doi: String, title: String) extends Content