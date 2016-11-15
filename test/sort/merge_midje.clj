(ns sort.merge_midje
  (:require [sort.merge :as subject]
            [midje.sweet :refer [fact]]))


(fact "merges two sorted lists with less recursion bro"
      (subject/merge-sorted [] []) => []
      (subject/merge-sorted [1] []) => [1]
      (subject/merge-sorted [1 2] []) => [1 2]
      (subject/merge-sorted [1 1 1] []) => [1 1 1]
      (subject/merge-sorted [1 3 5] [2 4 6]) => '(1 2 3 4 5 6)
      (subject/merge-sorted (range 10) '()) => (range 10))

(fact "sorts lists"
      (subject/merge-sort []) => []
      (subject/merge-sort [1]) => [1]
      (subject/merge-sort [3 2 1]) => [1 2 3]
      (subject/merge-sort [3 2 1 4]) => [1 2 3 4]
      (subject/merge-sort (shuffle (range 10))) => (range 10))
