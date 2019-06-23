Minimal example for a Stackoverflow [question](https://stackoverflow.com/questions/56679996/how-can-i-filter-only-some-values-from-my-nested-xml-in-clojure/56688798?noredirect=1#comment99991947_56688798).


To run this with [clj](https://clojure.org/guides/getting_started)

```shell
$ clj --main so

All parsed data:
({:next-status 999, :line-number 1.0, :amount-received 100} {:next-status 999, :line-number 2.0, :amount-received 200} {:next-status 999, :line-number 3.0, :amount-received 300})

Filtered data:
({:next-status 999, :line-number 1.0, :amount-received 100})
```
