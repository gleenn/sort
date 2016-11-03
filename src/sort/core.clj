(ns sort.core
  (:require
    [clojure.string :as string])
  (:gen-class :main true))

(defn -main [& args]
  (println (string/join " " args)))

(defn swap-if [mut-xs i j comparator]
  (let [mut-xs-i (get mut-xs i)
        mut-xs-j (get mut-xs j)]
    (if (comparator mut-xs-i mut-xs-j)
      (do
        (println (str "[" (string/join " " mut-xs) "] swapping " mut-xs-i " and " mut-xs-j))
        (aset mut-xs i mut-xs-j)
        (aset mut-xs j mut-xs-i)))))

(defn bubble [xs]
  (let [mut-xs (into-array xs)]
    (do
      (doseq [i (range (inc (count xs)))]
        (doseq [j (reverse (range 1 i))]
          (println 'i i 'j j)
          (swap-if mut-xs j (dec j) <)))
      (into [] mut-xs))))
