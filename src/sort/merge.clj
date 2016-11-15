(ns sort.merge)

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
