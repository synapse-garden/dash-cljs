(ns dash-test.core)

(defn insert-ids [maps]
  "insert-ids takes a sequence of maps and updates each element with an :id
   from sequential integers >= 1."
  (map (fn [m i] (assoc m :id i))
    maps
    (iterate inc 1)))
