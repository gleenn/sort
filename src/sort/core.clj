(ns sort.core
  (:require
    [clojure.string :as string])
  (:gen-class :main true))

(defn -main [& args]
  (println (string/join " " args)))
