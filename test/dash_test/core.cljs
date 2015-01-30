(ns dash-test.core
  (:require [dash-test.tests :as dash-tests]))

(defn insert-ids [maps]
  "insert-ids takes a sequence of maps and updates each element with an :id
   from sequential integers >= 1."
  (map (fn [m i] (assoc m :id i))
    maps
    (iterate inc 1)))

(defn refresh-tests! [state]
  "Refreshes the state atom with new tests and updated refresh counter."
  (swap! state (fn [s] (assoc s
                         :reload-count (inc (:reload-count s))
                         :tests (insert-ids (dash-tests/tests))))))
