(ns sort.core_midje
  (:require [midje.sweet :refer :all]
            [sort.core :as subject]))

(fact "flags can be parsed from an arglist"
  :has-metadata
  (let [result (subject/bubble [])]
    (subject/bubble [3 1 2]) => [1 2 3]))
