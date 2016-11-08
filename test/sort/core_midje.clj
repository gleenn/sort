(ns sort.core_midje
  (:require [midje.sweet :refer :all]
            [sort.core :as subject]))

(fact "sorts lists using bubble sort"
      :has-metadata
      (subject/bubble [])     => []
      (subject/bubble [0])     => [0]
      (subject/bubble [3 1 2]) => [1 2 3]
      (subject/bubble [3 1 2 0]) => [0 1 2 3])

(fact "merges two sorted lists"
      :has-metadata
      (subject/merge-sorted [] []) => []
      (subject/merge-sorted [1 3 5] [2 4 6]) => [1 2 3 4 5 6])
