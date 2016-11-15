(ns sort.merge)

(defn merge-sorted [xs ys]
  (reverse
    (loop [xs xs ys ys sorted '()]
      (cond
        (empty? xs) (concat (reverse ys) sorted)
        (empty? ys) (concat (reverse xs) sorted)
        :else (let [x (first xs) y (first ys)]
                (if (< x y)
                  (recur (drop 1 xs) ys (conj sorted x))
                  (recur (drop 1 ys) xs (conj sorted y))))))))

(defn merge-sort [xs]
  (let [n (count xs)]
    (if (< n 2)
      xs
      (let [split (quot n 2)]
        (merge-sorted
          (merge-sort (take split xs))
          (merge-sort (drop split xs)))))))
