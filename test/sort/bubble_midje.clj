(ns sort.bubble_midje
  (:require [midje.sweet :refer :all]
            [sort.bubble :as subject]))

(fact "sorts lists using bubble sort"
      :has-metadata
      (subject/bubble [])     => []
      (subject/bubble [0])     => [0]
      (subject/bubble [3 1 2]) => [1 2 3]
      (subject/bubble [3 1 2 0]) => [0 1 2 3])
