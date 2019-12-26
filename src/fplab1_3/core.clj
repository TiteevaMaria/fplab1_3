(ns fplab1-3.core)

(defn v [n r]
  (take n (repeatedly #(rand-int r))))

(defn cn [map_ ar k]
  (if (nil? (first ar))
    (map first (filter #(> (second %) k) map_))
    (recur (if (contains? map_ (first ar))
             (assoc map_ (first ar)(inc (map_ (first ar))))
             (assoc map_ (first ar) 1))
           (rest ar)
           k)))

(defn solve [n r k]
  (let [ar (v n r)]
    (println ar)
    (println (cn {} ar k))
    ))