import org.scalatest._
import xyz.riedl.Top

import scala.collection.immutable.List
import scala.collection.immutable.HashMap

class TopSpec extends FlatSpec with Matchers {

  "A topolocical sorting algorithm" should "sort elements regarding their dependencies" in {
    val unsorted = List(1,2,3,4)

    val depMap = HashMap[Int,Set[Int]](
      1->Set(3),
      3->Set(4,2),
      2->Set(4),
      4->Set()
    )

    val sorted = Top.sort(unsorted, (e:Int)=> e, (e:Int) => depMap(e))

    val expectation = List(4,2,3,1)

     sorted shouldEqual expectation
  }


  "A topolocical sort and summation algorithm" should "sort elements regarding their dependencies and sum them up" in {
    val unsorted_1 = List(1,2,3,4)

    val depMap_1 = HashMap[Int,Set[Int]](
      1->Set(3),
      3->Set(4,2),
      2->Set(4),
      4->Set()
    )

    val processed_1 = Top.sortAndProcess(
      unsorted_1, (e:Int)=> e,
      (e:Int) => depMap_1(e),
      (source: Int, targets : List[Int]) => {
        targets.foldLeft(source)(_ + _)
      }
    )

    val expectation_1 = List(4,6,13,14)

    processed_1 shouldEqual expectation_1

    val unsorted_2 = List(1,2,3,4)

    val depMap_2 = HashMap[Int,Set[Int]](
      1->Set(),
      3->Set(4,2),
      2->Set(4),
      4->Set()
    )

    val processed_2 = Top.sortAndProcess(
      unsorted_2, (e:Int)=> e,
      (e:Int) => depMap_2(e),
      (source: Int, targets : List[Int]) => {
        targets.foldLeft(source)(_ + _)
      }
    )

    val expectation_2 = List(1,4,6,13)

    processed_2 shouldEqual expectation_2
  }
}
