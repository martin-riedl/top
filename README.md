# TOP - Topological Sorting and Processing

This project provides an algorithm to sort (and process) a given list of objects 
that have loop-free interdependencies. 

## Usage Example

```scala

val unsorted = List(1,2,3,4)
val dependencies = HashMap[Int,Set[Int]](
  1->Set(3),
  3->Set(4,2),
  2->Set(4),
  4->Set()
)

Top.sortAndProcess(
  unsorted, (e:Int)=> e,
  (e:Int) => dependencies(e),
  (source: Int, targets : List[Int]) => {
    targets.foldLeft(source)(_ + _)
  }
)
```
should result 
```scala
List(4,6,13,14)
```
