(ns sort.core_midje
  (:require [midje.sweet :refer :all]
            [sort.core :as subject]))

(fact "flags can be parsed from an arglist"
      :has-metadata
      (subject/bubble [])     => []
      (subject/bubble [0])     => [0]
      (subject/bubble [3 1 2]) => [1 2 3]
      (subject/bubble [3 1 2 0]) => [0 1 2 3])
