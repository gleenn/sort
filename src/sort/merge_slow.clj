(ns sort.merge_slow)

(defn- merge-sorted- [xs ys sorted]
  (cond
    (empty? xs) (concat (reverse ys) sorted)
    (empty? ys) (concat (reverse xs) sorted)
    :else (let [x (first xs) y (first ys)]
            (if (< x y)
              (merge-sorted- (drop 1 xs) ys (conj sorted x))
              (merge-sorted- (drop 1 ys) xs (conj sorted y))))))

(defn merge-sorted [xs ys]
    (reverse (merge-sorted- xs ys '())))
