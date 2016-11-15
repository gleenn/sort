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
;;         (println (str "[" (string/join " " mut-xs) "] swapping " mut-xs-i " and " mut-xs-j))
        (aset mut-xs i mut-xs-j)
        (aset mut-xs j mut-xs-i)))))

(defn bubble [xs]
  (let [mut-xs (into-array xs)]
    (do
      (doseq [i (range (inc (count xs)))]
        (doseq [j (reverse (range 1 i))]
;;           (println 'i i 'j j)
          (swap-if mut-xs j (dec j) <)))
      (into [] mut-xs))))


(defn- merge-sorted- [xs ys sorted]
  (cond
    (empty? xs) (concat (reverse ys) sorted)
    (empty? ys) (concat (reverse xs) sorted)
    :else (let [x (first xs) y (first ys)]
            (if (< x y)
              (merge-sorted- (drop 1 xs) ys (conj sorted x))
              (merge-sorted- (drop 1 ys) xs (conj sorted y))))))

(defn merge-sorted [xs ys]
    (reverse (merge-sorted- (lazy-seq xs) (lazy-seq ys) '())))

(defn merge-sorted-fast [xs ys]
  (reverse
    (loop [xs xs ys ys sorted '()]
      (cond
        (empty? xs) (concat (reverse ys) sorted)
        (empty? ys) (concat (reverse xs) sorted)
        :else (let [x (first xs) y (first ys)]
                (if (< x y)
                  (recur (drop 1 xs) ys (conj sorted x))
                  (recur (drop 1 ys) xs (conj sorted y))))))))
