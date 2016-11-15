(ns sort.merge_midje
  (:require [sort.merge :as subject]
            [midje.sweet :refer [fact]]))


(fact "merges two sorted lists with less recursion bro"
      (subject/merge-sorted-fast [] []) => []
      (subject/merge-sorted-fast [1] []) => [1]
      (subject/merge-sorted-fast [1 2] []) => [1 2]
      (subject/merge-sorted-fast [1 1 1] []) => [1 1 1]
      (subject/merge-sorted-fast [1 3 5] [2 4 6]) => '(1 2 3 4 5 6)
      (subject/merge-sorted-fast (range 10) '()) => (range 10))
