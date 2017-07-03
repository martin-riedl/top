# TOP - Topological Sorting and Processing
```sequence
Alice->Bob: Hello Bob, how are you?
Note right of Bob: Bob thinks
Bob-->Alice: I am good thanks!
```


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
should result List(4,6,13,14)
